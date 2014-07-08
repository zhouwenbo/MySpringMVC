package com.fheebiy.service;

import com.fheebiy.domain.Device;
import com.fheebiy.repo.DeviceRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by bob zhou on 14-7-8.
 */
@Service
public class DeviceService {

    @Autowired
    private DeviceRepo repo;

    /**
     *
     * @param id            主键
     * @param deviceNo      设备编号
     * @param sim_id        sim卡号
     * @param company       公司名称
     * @param deviceModel   设备型号
     * @param status        状态
     * @return
     */
    public List<Device> getList(long id,String deviceNo, String sim_id, String company, int deviceModel, int status){

        return null;
    }

}
