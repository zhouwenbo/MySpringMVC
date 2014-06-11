package com.fheebiy.service;

import com.fheebiy.domain.Phone;
import com.fheebiy.repo.PhoneRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by bob zhou on 14-4-19.
 */
@Service
public class PhoneService {

   /* @Autowired
    private PhoneRepoImpl repo;
*/
    @Autowired
    private PhoneRepo phoneRepo;
/*
    public Phone getPhoneById(long phone_id){
        Query query = new Query();
        query.addCriteria(Criteria.where("phone_id").is(phone_id));
       // return repo.findOne(query);
    }

    public void save(Phone phone){
         repo.save(phone);
    }*/

    public List<Phone> getList(double price,String name){
        Query query = new Query();
        query.addCriteria(Criteria.where("name").is(name)/*.and("name").is("iphone5s")*/);
        return null;
    }


    public void update(Phone phone){
        Query query = new Query();
        query.addCriteria(Criteria.where("_id").is("53536b1ec2f9ae58e26fc6b3"));
        Update update = Update.update("price",phone.getPrice());

                //.addToSet("name",phone.getName()).addToSet("size", phone.getSize());
      /*  update.addToSet("name",phone.getName());
       //// update.addToSet("size", phone.getSize());
        update.addToSet("price", phone.getPrice());
        update.addToSet("weight", phone.getWeight());*/
        //repo.update(query, update);
    }
}
