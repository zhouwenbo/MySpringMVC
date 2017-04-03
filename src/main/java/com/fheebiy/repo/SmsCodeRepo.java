package com.fheebiy.repo;

import com.fheebiy.domain.SmsCode;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;


/**
 * Created by cm on 2017/3/27.
 */
@Repository
public interface SmsCodeRepo {

    void save(SmsCode smsCode);

    @Select("select * from smscode where phoneNum = #{0} and code = #{1} and status=#{2} order by createTime desc limit 1")
    SmsCode findByPhoneAndCode(String phoneNum, String code, int status);

    @Update("update smscode set status = #{1} where code_id = #{0}")
    void updateStatus(long code_id, int status);
}
