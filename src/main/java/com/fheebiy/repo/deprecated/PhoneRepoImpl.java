package com.fheebiy.repo.deprecated;

import com.fheebiy.domain.Phone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

/**
 * Created by bob zhou on 14-4-19.
 * @deprecated
 */
@Repository
public class PhoneRepoImpl extends BaseMongoRepo<Phone>{


    @Autowired
    @Qualifier("mongoTemplate")
    @Override
    protected void setMongoTemplate(MongoTemplate mongoTemplate) {
        super.mongoTemplate = mongoTemplate;
    }

    @Override
    protected Class<Phone> getEntityClass() {
        return Phone.class;
    }
}
