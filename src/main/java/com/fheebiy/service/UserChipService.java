package com.fheebiy.service;

import com.fheebiy.domain.GoodChip;
import com.fheebiy.domain.KindChip;
import com.fheebiy.domain.User;
import com.fheebiy.domain.UserChip;
import com.fheebiy.dto.UserChipDto;
import com.fheebiy.repo.UserChipRepo;
import com.fheebiy.rest.JsonResponseHeader;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Created by cm on 2017/4/2.
 * 用户碎片
 */
@Service
public class UserChipService {

    @Autowired
    private UserChipRepo userChipRepo;

    @Autowired
    private GoodChipService goodChipService;

    @Autowired
    private UserService userService;

    @Autowired
    private KindChipService kindChipService;

    public List<UserChipDto> getUserChipByUser(long user_id, long updateTime, int count) {
        List<UserChip> list = userChipRepo.getListByUser(user_id, updateTime, count);
        List<UserChipDto> userChipDtoList = new ArrayList<UserChipDto>();
        if (CollectionUtils.isEmpty(list)) {
            return userChipDtoList;
        }

        Set<Long> kindChip_ids = new HashSet<Long>();
        for (UserChip userChip : list) {
            kindChip_ids.add(userChip.getKc_id());
        }
        String kcIdsStr = StringUtils.join(kindChip_ids, ",");

        List<KindChip> kindChipList = kindChipService.getByIds(kcIdsStr);
        HashMap<Long, KindChip> kindChipHashMap = new HashMap<Long, KindChip>();

        for (KindChip kindChip : kindChipList) {
            kindChipHashMap.put(kindChip.getKc_id(), kindChip);
        }


        for (UserChip userChip : list) {
            UserChipDto dto = new UserChipDto();
            dto.setUc_id(userChip.getUc_id());
            dto.setKc_id(userChip.getKc_id());
            dto.setUser_id(userChip.getUser_id());
            dto.setCount(userChip.getCount());
            dto.setSellingCount(userChip.getSellingCount());
            dto.setSoldCount(userChip.getSoldCount());
            dto.setStatus(0);
            dto.setUpdateTime(userChip.getUpdateTime());

            KindChip kindChip = kindChipHashMap.get(userChip.getKc_id());
            if (kindChip != null) {
                dto.setLevel(kindChip.getLevel());
                dto.setName(kindChip.getName());
            }
            userChipDtoList.add(dto);

        }
        return userChipDtoList;
    }

    public void sell(long user_id, long kc_id, int count, int price) {
        goodChipService.saveForSell(user_id, kc_id, count, price);
    }


    public int sell(String token, long uc_id, long kc_id, int count, int price) {
        User user = userService.getByToken(token);
        UserChip userChip = userChipRepo.getById(uc_id);
        if (userChip == null) {
            return JsonResponseHeader.STATUS_USER_CHIP_NOT_EXIST;
        }

        if (userChip.getKc_id() != kc_id || userChip.getUser_id() != user.getUser_id() || userChip.getCount() < count) {
            return JsonResponseHeader.STATUS_ILLEGAL_OPERATION;
        }

        goodChipService.saveForSell(user.getUser_id(), kc_id, count, price);
        userChipRepo.updateForSell(uc_id, count);
        return JsonResponseHeader.STATUS_OK;
    }


    public void updateChip(GoodChip goodChip, long buyer_id, long seller_id) {
        long kc_id = goodChip.getKc_id();

        UserChip buyerUserChip = userChipRepo.getByKcid(kc_id, buyer_id);
        UserChip sellerUserChip = userChipRepo.getByKcid(kc_id, seller_id);
        if (buyerUserChip != null) { //买的这种以前就有，那么只需要加数量就可以了
            userChipRepo.updateCountByKcid(buyerUserChip.getCount() + goodChip.getCount(), kc_id, buyer_id);
        } else {    //没有的话，就需要新建了
            UserChip userChip = new UserChip();
            userChip.setKc_id(kc_id);
            userChip.setUc_id(buyer_id);
            userChip.setCount(goodChip.getCount());
            userChip.setStatus(0);
            userChip.setUpdateTime(new Date().getTime());
            userChipRepo.save(userChip);
        }
        userChipRepo.updateCountByKcid(sellerUserChip.getCount() - goodChip.getCount(), kc_id, seller_id);
    }


}
