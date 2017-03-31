package com.fheebiy.service;

import com.fheebiy.common.StrUtil;
import com.fheebiy.repo.UserRepo;
import com.fheebiy.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by bob zhou on 14-3-22.
 */
@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;


    public List<User> getAll(){
        return userRepo.getList();
    }

    public User getUserById(long user_id){
        return userRepo.getById(user_id);
    }

    public User doLogin(String phoneNum, String password){
        return  userRepo.doLogin(phoneNum, password);
    }

    public User saveUser(String phone, String pwd, String nickName) {
        User user = new User();
        user.setPhoneNum(phone);
        user.setPassword(pwd);
        user.setToken(StrUtil.getTokenByPwd(pwd));
        user.setNickName(nickName);
        user.setAge(0);
        user.setSex(0);
        user.setIntegral(100);
        user.setGold(0);
        user.setCredit(8000);
        user.setCreateTime(new Date());
        user.setUpdateTime(new Date());
        userRepo.save(user);

        return user;
    }

    public User getUserByPhone(String phone) {
        return userRepo.getUserByPhoneNum(phone);
    }

}
