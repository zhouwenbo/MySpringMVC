package com.fheebiy.repo;

import com.fheebiy.domain.Gift;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * Created by cm on 2017/3/28.
 */
@Repository
public interface GiftRepo {

     List<Gift> list(Map map);

     @Select("select * from gift where gift_id = #{id}")
     Gift getById(long id);

     void save(Gift gift);

     void update(Gift gift);

     @Delete("delete from gift where gift_id = #{gift_id}")
     void delete(long gift_id);

}