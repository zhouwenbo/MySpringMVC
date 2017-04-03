package com.fheebiy.domain;

/**
 * Created by cm on 2017/3/28.
 * 树
 */
public class Tree {



    public static final int TYPE_GIFT = 1;

    public static final int TYPE_DESIRE = 2;

    private long tree_id;

    private long user_id;

    /**
     * 1：礼物树 2：愿望树
     */
    private int type;

    /**
     * 级别
     */
    private int level;

    /**
     * 成长值
     */
    private long progress;

    /**
     * 总共需要的成长值
     */
    private long totalNum;

    private long createTime;

    private long updateTime;

    public long getTree_id() {
        return tree_id;
    }

    public void setTree_id(long tree_id) {
        this.tree_id = tree_id;
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

    public long getProgress() {
        return progress;
    }

    public void setProgress(long progress) {
        this.progress = progress;
    }

    public long getTotalNum() {
        return totalNum;
    }

    public void setTotalNum(long totalNum) {
        this.totalNum = totalNum;
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

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void initTotalNum() {
        setTotalNum(getT(level));
    }

    public static long getT(int level) {
        int x = 0;
        switch (level) {
            case 1:
                x = 1000;
                break;
            case 2:
                x = 8000;
                break;
            case 3:
                x = 15000;
                break;
            case 4:
                x = 100000;
                break;
            case 5:
                x = 180000;
                break;
            case 6:
                x = 250000;
                break;
            default:
                x = 250000;
                break;
        }
        return x;
    }


}

