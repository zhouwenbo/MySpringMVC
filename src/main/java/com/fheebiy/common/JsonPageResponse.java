package com.fheebiy.common;

import java.util.ArrayList;

/**
 * @author Administrator
 *         为EasyUI提供列表
 */
public class JsonPageResponse {
    private long total;
    private Object rows;

    public JsonPageResponse(long total, Object rows) {
        this.total = total;
        if (rows == null) {
            rows = new ArrayList<String>();
        }
        this.rows = rows;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public Object getRows() {
        return rows;
    }

    public void setRows(Object rows) {
        this.rows = rows;
    }
}
