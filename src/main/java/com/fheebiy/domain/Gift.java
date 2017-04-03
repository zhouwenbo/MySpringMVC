package com.fheebiy.domain;

import java.util.*;

/**
 * Created by cm on 2017/3/28.
 * 礼物
 */
public class Gift {

    /**
     * 主键 id
     */
    private long gift_id;

    /**
     * 名称
     */
    private String name;

    /**
     * 描述
     */
    private String description;

    /**
     * 价格
     */
    private double price;

    /**
     * 级别
     */
    private int level;

    /**
     * 链接地址
     */
    private String ourl;

    private String pic1;

    private String pic2;

    private String pic3;

    /**
     * 状态：0默认，1：下架 2：删除
     */
    private int status;

    private Date createTime;

    private long updateTime;

    //level
    public static final int[] level1 = {1, 50};
    public static final int[] level2 = {50, 300};
    public static final int[] level3 = {300, 500};
    public static final int[] level4 = {500, 1000};
    public static final int[] level5 = {1000, 2000};
    public static final int[] level6 = {2000, 2000000};

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

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
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

    public String getOurl() {
        return ourl;
    }

    public void setOurl(String ourl) {
        this.ourl = ourl;
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

    public void initLevel() {
        this.level = getLevel(price);
    }

    public static int getLevel(double price) {
        int level = 1;
        if (levelIn(price, level1)) {
            level = 1;
        } else if (levelIn(price, level2)) {
            level = 2;
        } else if (levelIn(price, level3)) {
            level = 3;
        } else if (levelIn(price, level4)) {
            level = 4;
        } else if (levelIn(price, level5)) {
            level = 5;
        } else if (levelIn(price, level6)) {
            level = 6;
        }
        return level;
    }

    public static boolean levelIn(double price, int[] array) {
        return price >= array[0] && price < array[1];
    }

    /**
     * 爆礼物分类
     */
    public static class BurstOutGroup {

        private int min;

        private int max;

        private int level;

        private int count;

        private static Map<Integer, List<BurstOutGroup>> mapData = new HashMap();

        {
            mapData.put(1, getListLevel1());
            mapData.put(2, getListLevel2());
            mapData.put(3, getListLevel3());
            mapData.put(4, getListLevel4());
            mapData.put(5, getListLevel5());
            mapData.put(6, getListLevel6());
        }


        public int getMin() {
            return min;
        }

        public void setMin(int min) {
            this.min = min;
        }

        public int getMax() {
            return max;
        }

        public void setMax(int max) {
            this.max = max;
        }

        public int getLevel() {
            return level;
        }

        public void setLevel(int level) {
            this.level = level;
        }

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }

        public BurstOutGroup(int min, int max, int level, int count) {
            this.min = min;
            this.max = max;
            this.level = level;
            this.count = count;
        }

        public static List<BurstOutGroup> getBList(int level) {
            return mapData.get(level);
        }

        public static List<BurstOutGroup> getListLevel1() {
            List<BurstOutGroup> list = new ArrayList<BurstOutGroup>();
            list.add(new BurstOutGroup(1, 10, 1, 5));
            list.add(new BurstOutGroup(10, 20, 1, 20));
            list.add(new BurstOutGroup(20, 30, 1, 30));
            list.add(new BurstOutGroup(30, 40, 1, 15));
            list.add(new BurstOutGroup(40, 50, 1, 30));
            return list;
        }

        public static List<BurstOutGroup> getListLevel2() {
            List<BurstOutGroup> list = new ArrayList<BurstOutGroup>();
            list.add(new BurstOutGroup(50, 80, 2, 60));
            list.add(new BurstOutGroup(80, 150, 2, 150));
            list.add(new BurstOutGroup(150, 300, 2, 90));
            return list;
        }

        public static List<BurstOutGroup> getListLevel3() {
            List<BurstOutGroup> list = new ArrayList<BurstOutGroup>();
            list.add(new BurstOutGroup(300, 400, 3, 300));
            list.add(new BurstOutGroup(400, 500, 3, 300));
            return list;
        }


        public static List<BurstOutGroup> getListLevel4() {
            List<BurstOutGroup> list = new ArrayList<BurstOutGroup>();
            list.add(new BurstOutGroup(500, 600, 4, 350));
            list.add(new BurstOutGroup(600, 700, 4, 350));
            list.add(new BurstOutGroup(700, 1000, 4, 300));
            return list;
        }


        public static List<BurstOutGroup> getListLevel5() {
            List<BurstOutGroup> list = new ArrayList<BurstOutGroup>();
            list.add(new BurstOutGroup(1000, 1200, 5, 225));
            list.add(new BurstOutGroup(1200, 1500, 5, 450));
            list.add(new BurstOutGroup(1500, 1700, 5, 450));
            list.add(new BurstOutGroup(1700, 2000, 5, 375));
            return list;
        }


        public static List<BurstOutGroup> getListLevel6() {
            List<BurstOutGroup> list = new ArrayList<BurstOutGroup>();
            list.add(new BurstOutGroup(2000, 2500, 6, 800));
            list.add(new BurstOutGroup(2500, 2800, 6, 800));
            list.add(new BurstOutGroup(2800, 3000, 6, 800));
            list.add(new BurstOutGroup(3000, 3500, 6, 400));
            list.add(new BurstOutGroup(3500, 4000, 6, 600));
            list.add(new BurstOutGroup(4000, 4500, 6, 400));
            list.add(new BurstOutGroup(4500, 3000000, 6, 200));
            return list;
        }

    }

}
