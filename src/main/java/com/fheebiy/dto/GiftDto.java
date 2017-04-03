package com.fheebiy.dto;

import com.fheebiy.domain.Gift;
import org.apache.commons.lang.StringUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by cm on 2017/4/2.
 */
public class GiftDto {

    /**主键 id*/
    private long gift_id;

    /**名称*/
    private String name;

    /**描述*/
    private String description;

    /**价格*/
    private double price;

    /**级别*/
    private int level;

    /**链接地址*/
    private String ourl;

    /**状态：0默认，1：下架 2：删除*/
    private int status;

    private Date createTime;

    private long updateTime;

    private List<String> imgs;


    public long getGift_id() {
        return gift_id;
    }

    public void setGift_id(long gift_id) {
        this.gift_id = gift_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getOurl() {
        return ourl;
    }

    public void setOurl(String ourl) {
        this.ourl = ourl;
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

    public long getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(long updateTime) {
        this.updateTime = updateTime;
    }

    public List<String> getImgs() {
        return imgs;
    }

    public void setImgs(List<String> imgs) {
        this.imgs = imgs;
    }


    public static GiftDto fromGift(Gift gift) {
        GiftDto dto = new GiftDto();
        dto.setGift_id(gift.getGift_id());
        dto.setName(gift.getName());
        dto.setDescription(gift.getDescription());
        dto.setPrice(gift.getPrice());
        dto.setLevel(gift.getLevel());
        dto.setOurl(gift.getOurl());
        dto.setStatus(gift.getStatus());
        dto.setCreateTime(gift.getCreateTime());
        dto.setUpdateTime(gift.getUpdateTime());
        List<String> imgs = new ArrayList<String>();
        if (StringUtils.isNotEmpty(gift.getPic1())) {
            imgs.add(gift.getPic1());
        }

        if (StringUtils.isNotEmpty(gift.getPic2())) {
            imgs.add(gift.getPic2());
        }

        if (StringUtils.isNotEmpty(gift.getPic3())) {
            imgs.add(gift.getPic3());
        }

        dto.setImgs(imgs);
        return dto;
    }
}
