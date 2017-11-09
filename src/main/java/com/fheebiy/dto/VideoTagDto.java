package com.fheebiy.dto;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by cm on 2017/11/9.
 */
public class VideoTagDto {

    private long id;

    private int type;

    private String tname;

    private String  name;

    public VideoTagDto(long id, int type, String name) {
        this.id = id;
        this.type = type;
        this.tname = getTName(type);
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }


    private String getTName(int type) {
        if (map.size() == 0) {
            map.put(11, "a");
            map.put(12, "b");
            map.put(13, "c");
            map.put(14, "d");
            map.put(15, "e");
            map.put(16, "f");
            map.put(17, "g");
        }
        return map.get(type);
    }


    public static Map<Integer, String> map = new HashMap<Integer, String>();


}
