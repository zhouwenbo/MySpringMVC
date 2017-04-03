package com.fheebiy.service;

import com.fheebiy.domain.Gift;
import com.fheebiy.domain.KindChip;
import com.fheebiy.repo.KindChipRepo;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by cm on 2017/3/31.
 */
@Service
public class KindChipService {

    @Autowired
    private KindChipRepo kindChipRepo;


    public List<KindChip> getList(String name) {
        if (StringUtils.isEmpty(name)) {
           return kindChipRepo.getList(null);
        } else {
            return kindChipRepo.getListByName(name);
        }
    }


    public void saveByGift(Gift gift) {
        int count = (int) gift.getPrice();
        saveByGift(gift.getGift_id(), count, gift.getLevel(), gift.getName());
    }

    /**
     * 生成礼物时，顺便生成礼物的碎片
     * TODO 旅游碎片
     * @param gift_id 礼物id
     * @param fullChipCount 总共需要多少个碎片
     */
    private void saveByGift(long gift_id, int fullChipCount, int level,String giftName) {
        KindChip kindChip = new KindChip();
        kindChip.setType(KindChip.TYPE_GIFT);
        kindChip.setFor_id(gift_id);
        kindChip.setFullCount(fullChipCount);
        kindChip.setLevel(level);
        kindChip.setName(giftName + KindChip.CHIP_WORD);
        kindChip.setStatus(0);
        kindChip.setCreateTime(new Date());
        kindChipRepo.save(kindChip);
    }


    public void updateByGift(Gift gift) {
        int count = (int) gift.getPrice();
        updateByGift(gift.getGift_id(), count, gift.getLevel(), gift.getName());
    }

    public void updateByGift(long gift_id, int fullChipCount, int level, String giftName) {
        kindChipRepo.updateByGift(gift_id, fullChipCount, level ,KindChip.getNameByGiftName(giftName));
    }

    public List<KindChip> getAList(int count, long last_id) {
        return kindChipRepo.getAList(count, last_id);
    }


    public List<KindChip> getListByLevel(int level) {
        return kindChipRepo.getListByLevel(level);
    }


    public List<KindChip> getByIds(String ids) {
        return kindChipRepo.getByIds(ids);
    }

}
