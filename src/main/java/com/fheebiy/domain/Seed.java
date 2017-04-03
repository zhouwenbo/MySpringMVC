package com.fheebiy.domain;

/**
 * Created by cm on 2017/3/28.
 * 种子
 */
public class Seed {

    /**
     * 种子id
     */
    private long seed_id;

    /**
     * 用户id
     */
    private long user_id;

    /**
     * 1:礼物种子，2：愿望种子
     */
    private int type;

    /**
     * 几级种子，从1开始，1代表一级种子，2代表2级种子，依次类推
     */
    private int level;

    /**
     * 种子名称
     */
    private String name;

    /**
     * 礼物种子
     */
    public static final int TYPE_GIFT = 1;

    /**
     * 愿望种子
     */
    public static final int TYPE_DESIRE = 2;

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

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public void initName() {
        setName(getName(level, type));
    }

    public static String getName(int level, int type) {
        String s = level + "级";
        String s2 = type == TYPE_GIFT ? "礼物种子" : "愿望种子";
        return s + s2;
    }


}
