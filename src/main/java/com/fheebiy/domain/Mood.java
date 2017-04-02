package com.fheebiy.domain;

/**
 * Created by cm on 2017/3/28.
 * 心情
 */
public class Mood {

    /**主键id*/
    private long mood_id;

    /**用户id*/
    private long user_id;

    /**心情文字*/
    private String content;

    /**点赞数目*/
    private int praiseCount;

    /**图片地址1*/
    private String pic1;

    /**图片地址2*/
    private String pic2;

    /**图片地址3*/
    private String pic3;

    public long getMood_id() {
        return mood_id;
    }

    public void setMood_id(long mood_id) {
        this.mood_id = mood_id;
    }

    public long getUser_id() {
        return user_id;
    }

    public void setUser_id(long user_id) {
        this.user_id = user_id;
    }


    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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

    public int getPraiseCount() {
        return praiseCount;
    }

    public void setPraiseCount(int praiseCount) {
        this.praiseCount = praiseCount;
    }
}
