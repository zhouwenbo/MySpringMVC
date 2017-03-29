package com.fheebiy.domain;

/**
 * Created by cm on 2017/3/28.
 * 种子
 */
public class Seed {

    /**种子id*/
    private long seed_id;

    /**用户id*/
    private long user_id;

    /**几级种子，从1开始，1代表一级种子，2代表2级种子，依次类推*/
    private int type;

    /**种子名称*/
    private String name;

    public long getSeed_id() {
        return seed_id;
    }

    public void setSeed_id(long seed_id) {
        this.seed_id = seed_id;
    }

    public long getUser_id() {
        return user_id;
    }

    public void setUser_id(long user_id) {
        this.user_id = user_id;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
