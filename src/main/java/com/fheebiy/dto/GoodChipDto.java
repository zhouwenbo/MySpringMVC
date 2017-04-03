package com.fheebiy.dto;

/**
 * Created by cm on 2017/4/3.
 */
public class GoodChipDto {


    /**主键*/
    private long gc_id;

    /**交易的碎片种类id,可以去ChipKind查询*/
    private long kc_id;

    /**属于谁*/
    private long user_id;

    /**状态，0：交易中 1：交易结束*/
    private int status;

    /**交易多少个*/
    private int count;

    /**价格，也就是需要几个金币来购买*/
    private int price;

    /**创建时间*/
    private long createTime;

    /**更新时间*/
    private long updateTime;



    /****************卖家的信息****************/
    /**卖家的昵称*/
    private String nickName;

    /**卖家的头像*/
    private String avatar;

    /****************卖家的信息****************/



    /****************碎片的固有信息***********/
    /**名字*/
    private String name;

    /**总共多少个就能换一个礼物*/
    private int fullCount;

    /**级别，和礼物级别对应*/
    private int level;
    /****************碎片的固有信息****************/


    public long getGc_id() {
        return gc_id;
    }

    public void setGc_id(long gc_id) {
        this.gc_id = gc_id;
    }

    public long getKc_id() {
        return kc_id;
    }

    public void setKc_id(long kc_id) {
        this.kc_id = kc_id;
    }

    public long getUser_id() {
        return user_id;
    }

    public void setUser_id(long user_id) {
        this.user_id = user_id;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
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

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getFullCount() {
        return fullCount;
    }

    public void setFullCount(int fullCount) {
        this.fullCount = fullCount;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}
