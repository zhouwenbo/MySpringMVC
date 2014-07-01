package com.fheebiy.domain;

import java.util.Date;

/**
 * Created by bob zhou on 14-6-30.
 */
public class LastLocation {

    private long id;

    private long device_id;

    private double lat;

    private double lng;

    private double blat;

    private double blng;

    private double glat;

    private double glng;

    private int is_update;

    private String location;

    private int velocity;

    private int direction;

    private double mileage;

    private Date deviceTime;

    private Date heartTime;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getDevice_id() {
        return device_id;
    }

    public void setDevice_id(long device_id) {
        this.device_id = device_id;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLng() {
        return lng;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }

    public double getBlat() {
        return blat;
    }

    public void setBlat(double blat) {
        this.blat = blat;
    }

    public double getBlng() {
        return blng;
    }

    public void setBlng(double blng) {
        this.blng = blng;
    }

    public double getGlat() {
        return glat;
    }

    public void setGlat(double glat) {
        this.glat = glat;
    }

    public double getGlng() {
        return glng;
    }

    public void setGlng(double glng) {
        this.glng = glng;
    }

    public int getIs_update() {
        return is_update;
    }

    public void setIs_update(int is_update) {
        this.is_update = is_update;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getVelocity() {
        return velocity;
    }

    public void setVelocity(int velocity) {
        this.velocity = velocity;
    }

    public int getDirection() {
        return direction;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

    public double getMileage() {
        return mileage;
    }

    public void setMileage(double mileage) {
        this.mileage = mileage;
    }

    public Date getDeviceTime() {
        return deviceTime;
    }

    public void setDeviceTime(Date deviceTime) {
        this.deviceTime = deviceTime;
    }

    public Date getHeartTime() {
        return heartTime;
    }

    public void setHeartTime(Date heartTime) {
        this.heartTime = heartTime;
    }
}
