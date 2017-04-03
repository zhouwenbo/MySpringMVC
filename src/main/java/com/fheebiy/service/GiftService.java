package com.fheebiy.service;

import com.fheebiy.common.LogUtil;
import com.fheebiy.domain.Gift;
import com.fheebiy.dto.GiftDto;
import com.fheebiy.repo.GiftRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by cm on 2017/3/31.
 */
@Service
public class GiftService {

    @Autowired
    private GiftRepo giftRepo;

    @Autowired
    private KindChipService kindChipService;

    public static final String TAG = "GiftService";

    private Gift getGiftByName(String name) {
        return giftRepo.getByName(name);
    }

    public Gift getById(long id) {
        return giftRepo.getById(id);
    }

    public void save(Gift gift) {
        giftRepo.save(gift);
    }

    public void update(Gift gift) {
        giftRepo.update(gift);
    }

    public void saveOrUpdate(Gift gift) {
        long id = gift.getGift_id();
        Gift g = getById(id);
        if (g == null) {
            gift.setCreateTime(new Date());
            gift.setUpdateTime(new Date().getTime());
            gift.setStatus(0);
            gift.initLevel();
            save(gift);
            Gift g2 = getGiftByName(gift.getName());
            if (g2 != null) {
                gift.setGift_id(g2.getGift_id());
                kindChipService.saveByGift(gift);
            } else {
                LogUtil.d(TAG, "getGiftByName = NULL and name = " + gift.getName());
            }
        } else {
            gift.setUpdateTime(new Date().getTime());
            gift.initLevel();
            update(gift);
            kindChipService.updateByGift(gift);
        }
    }

    public List<GiftDto> getAList(int count, long updateTime) {
        List<Gift>  list = giftRepo.getAList(count, updateTime);
        List<GiftDto> dtoList = new ArrayList<GiftDto>();
        for(Gift gift : list) {
            GiftDto dto = GiftDto.fromGift(gift);
            dtoList.add(dto);
        }
        return dtoList;
    }

    public List<Gift> getListByLevel(int level) {
        return giftRepo.getListByLevel(level);
    }


}
