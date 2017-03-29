package com.fheebiy.domain;

/**
 * Created by cm on 2017/3/28.
 * 碎片
 */
public class Chip {

    /**碎片id*/
    private long clip_id;

    /**属于哪个用户的*/
    private long user_id;

    /**兑换哪个礼物的*/
    private String gift_id;

    /**名字*/
    private String name;

    public long getClip_id() {
        return clip_id;
    }

    public void setClip_id(long clip_id) {
        this.clip_id = clip_id;
    }

    public long getUser_id() {
        return user_id;
    }

    public void setUser_id(long user_id) {
        this.user_id = user_id;
    }

    public String getGift_id() {
        return gift_id;
    }

    public void setGift_id(String gift_id) {
        this.gift_id = gift_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
