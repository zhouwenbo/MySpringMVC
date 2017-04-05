package com.fheebiy.repo;

import com.fheebiy.domain.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by bob zhou on 14-3-22.
 */
@Repository
public interface UserRepo {

    @Select("select * from user")
    List<User> getList();

    @Select("select * from user where user_id = #{user_id}")
    User getById(@Param("user_id")long user_id);

    @Select("select * from user where token = #{0}")
    User getByToken(String token);

    @Select("select * from user where phoneNum = #{0} limit 1")
    User getUserByPhoneNum(String phoneNum);

    @Select("select * from user where phoneNum= #{phoneNum} and password = #{password}")
    User doLogin(@Param("phoneNum")String phoneNum, @Param("password")String password);

    void save(User user);


    @Update("update user set gold = #{0} where user_id = #{1}")
    void updateGold(long count, long user_id);

    @Select("select * from user where user_id in (${ids})")
    List<User> getByIds(@Param("ids")String ids);

    @Update("update user set credit = #{1}, gold = #{2}, updateTime = #{3} where user_id = #{0}")
    void updateByExchangeGold(long user_id, long credit, long goldCount, long updateTime);

}
