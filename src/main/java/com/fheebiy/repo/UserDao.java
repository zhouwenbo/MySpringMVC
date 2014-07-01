package com.fheebiy.repo;

import com.fheebiy.domain.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by bob zhou on 14-3-22.
 */
@Repository
public interface UserDao {

    @Select("select * from tb_user")
    public List<User> getList();

    @Select("select * from tb_user where user_id = #{user_id}")
    public User getById(@Param("user_id")long user_id);

    @Select("select * from tb_user where name= #{user_name} and password = #{password}")
    public User doLogin(@Param("user_name")String user_name, @Param("password")String password);

}
