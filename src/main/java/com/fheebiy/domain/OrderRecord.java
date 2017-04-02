package com.fheebiy.domain;

import java.util.Date;

/**
 * Created by cm on 2017/4/1.
 * 交易记录
 */
public class OrderRecord {

    /**主键*/
    private long order_id;

    /**买家的user_id*/
    private long buy_user_id;

    /**卖家的user_id*/
    private long sell_usr_id;

    /**交易时间*/
    private Date createTime;

    /**交易金额*/
    private int count;

    public long getOrder_id() {
        return order_id;
    }

    public void setOrder_id(long order_id) {
        this.order_id = order_id;
    }

    public long getBuy_user_id() {
        return buy_user_id;
    }

    public void setBuy_user_id(long buy_user_id) {
        this.buy_user_id = buy_user_id;
    }

    public long getSell_usr_id() {
        return sell_usr_id;
    }

    public void setSell_usr_id(long sell_usr_id) {
        this.sell_usr_id = sell_usr_id;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
