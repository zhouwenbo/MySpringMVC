package com.fheebiy.domain;

import java.util.Date;

/**
 * Created by cm on 2017/3/27.
 * 短信验证码
 */
public class SmsCode {

    /**
     * 默认
     */
    public static final int STATUS_DEFAULT = 0;

    /**
     * 已经用过
     */
    public static final int STATUS_USED = 1;

    private long code_id;

    private String code;

    private String phoneNum;

    private Date updateTime;

    private Date createTime;

    private int status;      //0：ok， 1：已用过

    public long getCode_id() {
        return code_id;
    }

    public void setCode_id(long code_id) {
        this.code_id = code_id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
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

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
