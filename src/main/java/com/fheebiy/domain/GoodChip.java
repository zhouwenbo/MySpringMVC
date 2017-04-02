package com.fheebiy.domain;

/**
 * Created by cm on 2017/4/1.
 * 交易的碎片商品清单
 */
public class GoodChip {

    /**主键*/
    private long gc_id;

    /**交易的碎片的id,可以去ChipKind查询*/
    private long chip_id;

    /**属于谁*/
    private long user_id;

    /**交易多少个*/
    private int count;

    /**价格，也就是需要几个金币来购买*/
    private int price;


    public long getGc_id() {
        return gc_id;
    }

    public void setGc_id(long gc_id) {
        this.gc_id = gc_id;
    }

    public long getChip_id() {
        return chip_id;
    }

    public void setChip_id(long chip_id) {
        this.chip_id = chip_id;
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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
