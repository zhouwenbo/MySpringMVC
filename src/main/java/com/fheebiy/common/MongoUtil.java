package com.fheebiy.common;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.web.context.ContextLoader;

/**
 * Created by bob zhou on 14-6-12.
 */
public class MongoUtil {
    public static final String COLL_PHONE = "mg_phone";

    private static MongoTemplate mongoTemplate;
    static {
        mongoTemplate = (MongoTemplate)ContextLoader.getCurrentWebApplicationContext().getBean("mongoTemplate");
    }

    public static long nextId(String collName) {
        DBObject counter =
                mongoTemplate.getCollection("counter").findAndModify(
                        new BasicDBObject("_id", collName), // query
                        null,                 // fields
                        null,                 // sort
                        false,                // remove if true
                        new BasicDBObject("$inc", new BasicDBObject("seq", 1)), // update
                        true,                 // returnNew
                        true
                );
        return Long.parseLong(counter.get("seq").toString());
    }

}
