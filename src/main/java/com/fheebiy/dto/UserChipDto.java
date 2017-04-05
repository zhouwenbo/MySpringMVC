package com.fheebiy.dto;

/**
 * Created by cm on 2017/4/3.
 */
public class UserChipDto {

    /**主键，不过应该没什么用处*/
    private long uc_id;

    /**碎片种类*/
    private long kc_id;

    /**属于哪个用户的*/
    private long user_id;

    /**有几个*/
    private int  count;

    /**交易中的有几个*/
    private int sellingCount;

    /**交易完毕的有几个*/
    private int soldCount;

    /**状态，0：默认 1：出售中*/
    private int status;

    /**更新时间*/
    private long updateTime;

    /**从KindChip中查询*/
    private String name;

    /**从kindChip中查询*/
    private int level;

    /**价格，如果sellingCount > 0的话，就去GoodChip中查询价格*/
    private int price;

    public long getUc_id() {
        return uc_id;
    }

    public void setUc_id(long uc_id) {
        this.uc_id = uc_id;
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

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getSellingCount() {
        return sellingCount;
    }

    public void setSellingCount(int sellingCount) {
        this.sellingCount = sellingCount;
    }

    public int getSoldCount() {
        return soldCount;
    }

    public void setSoldCount(int soldCount) {
        this.soldCount = soldCount;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public long getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(long updateTime) {
        this.updateTime = updateTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
