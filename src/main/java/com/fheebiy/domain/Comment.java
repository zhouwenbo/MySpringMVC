package com.fheebiy.domain;

/**
 * Created by cm on 2017/4/1.
 */
public class Comment {

    /**主键*/
    private long comment_id;

    /**评论的对象，要么是*/
    private long for_id;

    /**是评论给交易的，还是评论给心情的*/
    private int for_type;

    /**是评论还是回复，0：评论， 1：回复*/
    private int self_type;

    /**如果self_type = 1的话，即如果是回复的话，那是回复给谁的*/
    private long for_user_id;

    /**用户Id*/
    private long user_id;

    /**内容*/
    private String content;


    public long getComment_id() {
        return comment_id;
    }

    public void setComment_id(long comment_id) {
        this.comment_id = comment_id;
    }

    public long getFor_id() {
        return for_id;
    }

    public void setFor_id(long for_id) {
        this.for_id = for_id;
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

    public int getFor_type() {
        return for_type;
    }

    public void setFor_type(int for_type) {
        this.for_type = for_type;
    }

    public int getSelf_type() {
        return self_type;
    }

    public void setSelf_type(int self_type) {
        this.self_type = self_type;
    }

    public long getFor_user_id() {
        return for_user_id;
    }

    public void setFor_user_id(long for_user_id) {
        this.for_user_id = for_user_id;
    }
}
