package com.fheebiy.dto;

import com.fheebiy.domain.Device;

import java.util.Date;

/**
 * Created by bob zhou on 14-7-8.
 */
public class DeviceDto {

    private long id;

    private long company_id;

    private String companyName;   //扩充字段，公司名称

    private String deviceNo;

    private String sim_id;

    private int deviceModel;    //设备型号，5: K6，6：gt02，7：TB01

    private int status;         //状态，5：正常，6：未使用，7：过期，8：坏设备

    private long car_id;

    private String carNum;      //扩充字段，车牌号码

    private Date deliveryTime;

    private Date expireTime;

    private Date create_time;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getCompany_id() {
        return company_id;
    }

    public void setCompany_id(long company_id) {
        this.company_id = company_id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getDeviceNo() {
        return deviceNo;
    }

    public void setDeviceNo(String deviceNo) {
        this.deviceNo = deviceNo;
    }

    public String getSim_id() {
        return sim_id;
    }

    public void setSim_id(String sim_id) {
        this.sim_id = sim_id;
    }

    public int getDeviceModel() {
        return deviceModel;
    }

    public void setDeviceModel(int deviceModel) {
        this.deviceModel = deviceModel;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public long getCar_id() {
        return car_id;
    }

    public void setCar_id(long car_id) {
        this.car_id = car_id;
    }

    public String getCarNum() {
        return carNum;
    }

    public void setCarNum(String carNum) {
        this.carNum = carNum;
    }

    public Date getDeliveryTime() {
        return deliveryTime;
    }

    public void setDeliveryTime(Date deliveryTime) {
        this.deliveryTime = deliveryTime;
    }

    public Date getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(Date expireTime) {
        this.expireTime = expireTime;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    public static DeviceDto getDto(Device device,String companyName, String carNum){
        DeviceDto dto = new DeviceDto();
        dto.setId(device.getId());
        dto.setCompany_id(device.getCompany_id());
        dto.setCompanyName(companyName);
        dto.setDeviceNo(device.getDeviceNo());
        dto.setSim_id(device.getSim_id());
        dto.setDeviceModel(device.getDeviceModel());
        dto.setStatus(device.getStatus());
        dto.setCar_id(device.getCar_id());
        dto.setCarNum(carNum);
        dto.setDeliveryTime(device.getDeliveryTime());
        dto.setExpireTime(device.getExpireTime());
        dto.setCreate_time(device.getCreate_time());
        return dto;
    }
}
