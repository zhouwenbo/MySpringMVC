package com.fheebiy.domain;

import java.util.Date;

/**
 * Created by cm on 2017/3/28.
 * 树
 */
public class Tree {

    /**礼物树*/
    public static final int GIFT_TREE_TOTAL_NUM = 100;

    /**愿望树*/
    public static final int DESIRE_TREE_TOTAL_NUM = 100;

    public static final int TYPE_GIFT = 1;

    public static final int TYPE_DESIRE = 2;

    private long tree_id;

    private long user_id;

    /**1：礼物树 2：愿望树*/
    private int type;

    /**级别*/
    private int level;

    /**成长值*/
    private long progress;

    /**总共需要的成长值*/
    private long totalNum;

    private Date createTime;

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

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}

