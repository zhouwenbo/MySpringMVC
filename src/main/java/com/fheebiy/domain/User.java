package com.fheebiy.domain;

/**
 * Created by zwb on 14-3-22.
 */
public class User {

    /**主键*/
    private long user_id;

    /**用户名, account名*/
    private String user_name;

    /**电话号码*/
    private String phoneNum;

    /**密码*/
    private String password;

    /**token*/
    private String token;

    /**昵称*/
    private String nickName;

    /**年龄*/
    private int age;     //默认0

    /**性别*/
    private int sex;    //0:默认，男 1：女

    /**学校*/
    private String school;

    /**头像图片地址*/
    private String avatar;

    /**地域*/
    private String area;

    /**积分*/
    private long integral;

    /**金币*/
    private long gold;

    /**额度*/
    private long credit;

    /**个性签名*/
    private String signature;

    /**心情和种子在另外一张表，通过user_id关联*/

    /**上次签到时间*/
    private long lastCheckTime;

    private long createTime;

    private long updateTime;

    public long getUser_id() {
        return user_id;
    }

    public void setUser_id(long user_id) {
        this.user_id = user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public void setLastCheckTime(long lastCheckTime) {
        this.lastCheckTime = lastCheckTime;
    }

    public long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(long createTime) {
        this.createTime = createTime;
    }

    public long getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(long updateTime) {
        this.updateTime = updateTime;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public long getIntegral() {
        return integral;
    }

    public void setIntegral(long integral) {
        this.integral = integral;
    }

    public long getGold() {
        return gold;
    }

    public void setGold(long gold) {
        this.gold = gold;
    }

    public long getCredit() {
        return credit;
    }

    public void setCredit(long credit) {
        this.credit = credit;
    }

    public long getLastCheckTime() {
        return lastCheckTime;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }
}
