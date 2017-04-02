package com.fheebiy.domain;

import java.util.Date;

/**
 * Created by cm on 2017/3/30.
 * 种类碎片
 */
public class KindChip {

    public static final int TYPE_GIFT = 1;

    public static final int TYPE_DESIRE = 2;

    public static final String CHIP_WORD = "碎片";

    /**种类id*/
    private long kc_id;

    /**名字*/
    private String name;

    /**礼物树爆出礼物碎片，愿望树爆出愿望碎片， 1：礼物碎片，2： 愿望碎片*/
    private int type;

    /**礼物对应的礼物id,愿望对应愿望id*/
    private long for_id;

    /**总共多少个就能换一个礼物*/
    private int fullCount;

    /**级别，和礼物级别对应*/
    private int level;

    /**状态*/
    private int status;

    /**创建时间*/
    private Date createTime;

    public long getKc_id() {
        return kc_id;
    }

    public void setKc_id(long kc_id) {
        this.kc_id = kc_id;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public long getFor_id() {
        return for_id;
    }

    public void setFor_id(long for_id) {
        this.for_id = for_id;
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

    public static String getNameByGiftName(String name) {
        return name + CHIP_WORD;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}
