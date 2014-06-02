package com.fheebiy.service;

import com.fheebiy.dao.HeroDao;
import com.fheebiy.model.domain.Hero;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 14-4-9.
 */
@Service
public class HeroService{

    @Autowired
    private HeroDao heroDao;


    public Hero getHeroById(long hero_id){
         return  heroDao.getById(hero_id);
    }

    public List<Hero> getList(){
       return heroDao.getList();
    }
}
