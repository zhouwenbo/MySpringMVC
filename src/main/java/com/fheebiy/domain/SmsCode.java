package com.fheebiy.domain;

import java.util.Date;

/**
 * Created by cm on 2017/3/27.
 * 短信验证码
 */
public class SmsCode {

    private long code_id;

    private int code;

    private String phoneNum;

    private Date updateTime;


    public long getCode_id() {
        return code_id;
    }

    public void setCode_id(long code_id) {
        this.code_id = code_id;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
