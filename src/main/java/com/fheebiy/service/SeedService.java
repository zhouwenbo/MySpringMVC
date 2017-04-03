package com.fheebiy.service;

import com.fheebiy.domain.Seed;
import com.fheebiy.repo.SeedRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by cm on 2017/4/3.
 */
@Service
public class SeedService {

    @Autowired
    private SeedRepo seedRepo;

    public void saveForUserRegister(long user_id) {
        Seed giftSeed = new Seed();
        giftSeed.setUser_id(user_id);
        giftSeed.setLevel(1);
        giftSeed.setType(Seed.TYPE_GIFT);
        giftSeed.initName();
        seedRepo.save(giftSeed);


        Seed desireSeed = new Seed();
        desireSeed.setUser_id(user_id);
        desireSeed.setLevel(1);
        desireSeed.setType(Seed.TYPE_DESIRE);
        desireSeed.initName();
        seedRepo.save(desireSeed);
    }

}
