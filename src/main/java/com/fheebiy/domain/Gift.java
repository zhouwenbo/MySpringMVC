package com.fheebiy.domain;

import java.util.Date;

/**
 * Created by cm on 2017/3/28.
 * 礼物
 */
public class Gift {

    /**主键 id*/
    private long gift_id;

    /**名称*/
    private String name;

    /**描述*/
    private String description;

    /**价格*/
    private double price;

    /**级别*/
    private int level;

    /**链接地址*/
    private String ourl;

    private String pic1;

    private String pic2;

    private String pic3;

    /**状态：0默认，1：下架 2：删除*/
    private int status;

    private Date createTime;

    private Date updateTime;

    public long getGift_id() {
        return gift_id;
    }

    public void setGift_id(long gift_id) {
        this.gift_id = gift_id;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getOurl() {
        return ourl;
    }

    public void setOurl(String ourl) {
        this.ourl = ourl;
    }


    public String getPic1() {
        return pic1;
    }

    public void setPic1(String pic1) {
        this.pic1 = pic1;
    }

    public String getPic2() {
        return pic2;
    }

    public void setPic2(String pic2) {
        this.pic2 = pic2;
    }

    public String getPic3() {
        return pic3;
    }

    public void setPic3(String pic3) {
        this.pic3 = pic3;
    }
}
