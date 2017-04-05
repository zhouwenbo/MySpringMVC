package com.fheebiy.service;

import com.fheebiy.common.StrUtil;
import com.fheebiy.repo.UserRepo;
import com.fheebiy.domain.User;
import com.fheebiy.rest.JsonResponse;
import com.fheebiy.rest.JsonResponseHeader;
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


    public List<User> getAll() {
        return userRepo.getList();
    }

    public User getUserById(long user_id) {
        return userRepo.getById(user_id);
    }

    public User doLogin(String phoneNum, String password) {
        return userRepo.doLogin(phoneNum, password);
    }

    public User saveUser(String phone, String pwd, String nickName) {
        User user = new User();
        user.setPhoneNum(phone);
        user.setPassword(pwd);
        user.setToken(StrUtil.getTokenByPwd(pwd + phone));
        user.setNickName(nickName);
        user.setAge(0);
        user.setSex(0);
        user.setIntegral(100);
        user.setGold(0);
        user.setCredit(8000);
        user.setCreateTime(new Date().getTime());
        user.setUpdateTime(new Date().getTime());
        user.setLastCheckTime(0);
        user.setUser_name("");
        user.setNickName(nickName);
        user.setSchool("");
        user.setArea("");
        user.setAvatar("");
        user.setSignature("");
        userRepo.save(user);

        return user;
    }

    public User getUserByPhone(String phone) {
        return userRepo.getUserByPhoneNum(phone);
    }

    /**
     * 更新金币数量:原因可能是买卖，或者额度，积分兑换等，但总之是要更新金币数量的
     */
    public void updateGold(long updateToCount, long user_id) {
        userRepo.updateGold(updateToCount, user_id);
    }


    public List<User> getByIds(String ids) {
        return userRepo.getByIds(ids);
    }

    public User getByToken(String token) {
        return userRepo.getByToken(token);
    }


    public int exchangeGold(String token, int count) {
        User user = getByToken(token);
        if (user == null) {
            return JsonResponseHeader.STATUS_USER_NOT_EXIST;
        }

        long credit = user.getCredit();
        if (credit < count) {
            return JsonResponseHeader.STATUS_CREDIT_NOT_ENOUGH;
        }

        int spendCredit = count/10;
        long currentCredit = user.getCredit() - spendCredit;
        long currentGold = user.getGold() + count;
        userRepo.updateByExchangeGold(user.getUser_id(), currentCredit, currentGold, System.currentTimeMillis());

        return JsonResponseHeader.STATUS_OK;
    }
}
