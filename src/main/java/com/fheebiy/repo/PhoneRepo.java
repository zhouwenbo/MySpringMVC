package com.fheebiy.repo;

import com.fheebiy.domain.Phone;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by bob zhou on 14-6-10.
 */
@Repository
public interface PhoneRepo extends MongoRepository<Phone, String> {

    @Query(value = "{'phone_id':?0}")
    public Phone findById(long phone_id);

    @Query(value = "{'price':{'$gt':?0}}")
    public List<Phone> findByPrice(double price);

    @Query(value = "{'name':?0,phone_id:?1,price:?2}")
    public List<Phone> getPhoneList(String name, long phone_id, double price);
}
