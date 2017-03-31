package com.fheebiy.domain;

/**
 * Created by cm on 2017/3/28.
 * 用户拥有的碎片
 */
public class UserChip {

    /**主键，不过应该没什么用处*/
    private long uc_id;

    /**碎片种类*/
    private long kc_id;

    /**属于哪个用户的*/
    private long user_id;

    /**有几个*/
    private int  count;

    /**名字todo？？可以保留，也可以通过ck_id去查*/
    private String name;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
