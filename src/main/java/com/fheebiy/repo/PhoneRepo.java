package com.fheebiy.repo;

import com.fheebiy.domain.Phone;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by bob zhou on 14-6-10.
 * 针对此仓储的构建方式，我曾有四种方式，分别是:
 * 1.继承MongoRepository，自动获取部分常用方法，放弃原因是方法有限，要想定义新的方法，
 * 还是借助于mongoTemplate,因此如同MongoRepository鸡肋,且特别冗余
 * 2.自己封装一个抽象类BaseMongoRepo，定义基本方法，注入Entity.class，借助mongoTemplate实现方法，但是依然显得冗余鸡肋
 * 3.采用注解的方式，这种方式，使我很纠结，很难舍弃，因为注解看起来更加简洁，代码量低，但是最终仍然否定了，因为注解只能查询，
 * 没有删除，修改，添加功能，而且查询参数不止一个时，必须确保参数不为空，才会查到有效数据。
 * 4.就是现在使用的方法，完全松散解耦，随意实现任何想要的方法。其比注解的冗余点在于，需要使用Query和Criteria两个API,代码量会多一点
 */
@Repository
public interface PhoneRepo {

  /*  @Query(value = "{'phone_id':?0}")
    public Phone findById(long phone_id);

    @Query(value = "{'price':{'$gt':?0}}")
    public List<Phone> findByPrice(double price);*/

    Phone findById(long phone_id);

    List<Phone> getPhoneList(String name, long phone_id, double price);

    void save(Phone phone);
}
