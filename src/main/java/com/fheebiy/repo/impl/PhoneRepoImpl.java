package com.fheebiy.repo.impl;

import com.fheebiy.domain.Phone;
import com.fheebiy.repo.PhoneRepo;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by bob zhou on 14-6-11.
 */
@Repository
public class PhoneRepoImpl implements PhoneRepo{

    @Autowired
    protected MongoTemplate mongoTemplate;

    @Override
    public Phone findById(long phone_id) {
        Query query = new Query();
        query.addCriteria(Criteria.where("phone_id").is(phone_id));
        return mongoTemplate.findOne(query, Phone.class);
    }

    @Override
    public void save(Phone phone){
        mongoTemplate.save(phone);
    }

    @Override
    public List<Phone> getPhoneList(String name,long phone_id, double price){
        Query query = new Query();
        Criteria criteria = new Criteria();
        if(StringUtils.isNotEmpty(name)){
            criteria.is("name").is(name);
        }
        if(phone_id > 0){
            criteria.and("phone_id").is(phone_id);
        }
        if(price > 0){
            criteria.and("price").is(price);
        }
        query.addCriteria(criteria);
        return mongoTemplate.find(query, Phone.class);
    }
 
}
