package com.fheebiy.service;

import com.fheebiy.domain.GoodChip;
import com.fheebiy.domain.KindChip;
import com.fheebiy.domain.User;
import com.fheebiy.dto.GoodChipDto;
import com.fheebiy.repo.GoodChipRepo;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Created by cm on 2017/4/2.
 */
@Service
public class GoodChipService {

    @Autowired
    private GoodChipRepo goodChipRepo;

    @Autowired
    private UserService userService;

    @Autowired
    private KindChipService kindChipService;

    public GoodChip getByUserIdAndKcId(long user_id, long kc_id) {
        return goodChipRepo.getByUserAndKcId(user_id, kc_id);
    }

    public void saveForSell(long user_id, long kc_id, int count, int price) {

        GoodChip gChip = goodChipRepo.getByUserAndKcId(user_id, kc_id);
        if (gChip != null) { //追加出售，则只需要更新个数，和价格还有updateTime即可
            int totalCount = count + gChip.getCount();
            int totalPrice = gChip.getPrice() + price;
            goodChipRepo.updateCountAndPrice(gChip.getGc_id(), totalCount, totalPrice, System.currentTimeMillis());
        } else {            //没有则直接，添加即可
            GoodChip goodChip = new GoodChip();
            goodChip.setUser_id(user_id);
            goodChip.setKc_id(kc_id);
            goodChip.setCount(count);
            goodChip.setPrice(price);
            goodChip.setStatus(0);
            goodChip.setCreateTime(System.currentTimeMillis());
            goodChip.setUpdateTime(System.currentTimeMillis());
            goodChipRepo.saveForSell(goodChip);
        }
    }

    public GoodChip getById(long gc_id) {
        return goodChipRepo.getById(gc_id);
    }

    public void updateStatus(long gc_id, int status) {
        goodChipRepo.updateStatus(gc_id, status);
    }


    public List<GoodChipDto> getAList(int count, long updateTime) {
        List<GoodChip> goodChips = goodChipRepo.getAList(count, updateTime);
        List<GoodChipDto> goodChipDtoList = new ArrayList<GoodChipDto>();
        if (CollectionUtils.isNotEmpty(goodChips)) {
            Set<Long> seller_user_ids = new HashSet<Long>();
            Set<Long> kindChip_ids = new HashSet<Long>();
            for (GoodChip goodChip : goodChips) {
                seller_user_ids.add(goodChip.getUser_id());
                kindChip_ids.add(goodChip.getKc_id());
            }

            String userIdsStr = StringUtils.join(seller_user_ids, ",");
            String kcIdsStr = StringUtils.join(kindChip_ids, ",");

            List<User> userList = userService.getByIds(userIdsStr);
            HashMap<Long, User> userHashMap = new HashMap<Long, User>();
            List<KindChip> kindChipList = kindChipService.getByIds(kcIdsStr);
            HashMap<Long, KindChip> kindChipHashMap = new HashMap<Long, KindChip>();

            for (User user : userList) {
                userHashMap.put(user.getUser_id(), user);
            }

            for (KindChip kindChip : kindChipList) {
                kindChipHashMap.put(kindChip.getKc_id(), kindChip);
            }

            for (GoodChip goodChip : goodChips) {
                GoodChipDto dto = new GoodChipDto();
                dto.setGc_id(goodChip.getGc_id());
                dto.setKc_id(goodChip.getKc_id());
                dto.setUser_id(goodChip.getUser_id());
                dto.setStatus(goodChip.getStatus());
                dto.setCount(goodChip.getCount());
                dto.setPrice(goodChip.getPrice());
                dto.setCreateTime(goodChip.getCreateTime());
                dto.setUpdateTime(goodChip.getUpdateTime());
                User user = userHashMap.get(goodChip.getUser_id());
                if (user != null) {
                    dto.setNickName(user.getNickName());
                    dto.setAvatar(user.getAvatar());
                }

                KindChip kindChip = kindChipHashMap.get(goodChip.getKc_id());
                if (kindChip != null) {
                    dto.setName(kindChip.getName());
                    dto.setFullCount(kindChip.getFullCount());
                    dto.setLevel(kindChip.getLevel());
                }
                goodChipDtoList.add(dto);
            }
        }

        return goodChipDtoList;
    }

}
