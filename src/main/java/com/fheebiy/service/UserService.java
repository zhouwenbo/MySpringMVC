package com.fheebiy.service;

import com.fheebiy.dao.UserDao;
import com.fheebiy.model.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by bob zhou on 14-3-22.
 */
@Service
public class UserService {

    @Autowired
    private UserDao userDao;


    public List<User> getAll(){
        return userDao.getList();
    }

    public User getUserById(long user_id){
        return userDao.getById(user_id);
    }

    public User doLogin(String user_name, String password){
        return  userDao.doLogin(user_name, password);
    }
}
