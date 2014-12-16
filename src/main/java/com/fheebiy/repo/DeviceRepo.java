package com.fheebiy.repo;

import com.fheebiy.domain.Device;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * Created by bob zhou on 14-7-8.
 */

@Repository
public interface DeviceRepo {

    public List<Device> getList(Map map);

    public Device getById(long id);


}
