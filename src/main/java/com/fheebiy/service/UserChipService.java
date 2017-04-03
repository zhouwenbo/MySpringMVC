package com.fheebiy.service;

import com.fheebiy.domain.GoodChip;
import com.fheebiy.domain.User;
import com.fheebiy.domain.UserChip;
import com.fheebiy.repo.UserChipRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

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

    public List<UserChip> getUserChipByUser(long user_id) {
        return userChipRepo.getListByUser(user_id);
    }

    public void sell(long user_id, long kc_id, int count, int price) {
        goodChipService.saveForSell(user_id, kc_id, count, price);
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
            userChip.setUpdateTime(new Date());
            userChipRepo.save(userChip);
        }
        userChipRepo.updateCountByKcid(sellerUserChip.getCount() - goodChip.getCount(), kc_id, seller_id);
    }


}
