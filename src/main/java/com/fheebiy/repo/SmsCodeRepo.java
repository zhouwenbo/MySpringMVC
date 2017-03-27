package com.fheebiy.repo;

import com.fheebiy.domain.SmsCode;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.Map;

/**
 * Created by cm on 2017/3/27.
 */
@Repository
public interface SmsCodeRepo {

    void save(SmsCode smsCode);

    @Select("select * from smscode where phoneNum = #{0} and code = #{1}")
    SmsCode findByPhoneAndCode(String phoneNum, String code);

}
