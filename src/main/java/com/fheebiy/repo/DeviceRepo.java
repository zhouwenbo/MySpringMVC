package com.fheebiy.repo;

import com.fheebiy.domain.Device;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by bob zhou on 14-7-8.
 */

@Repository
public interface DeviceRepo {

    public List<Device> getList();

    public Device getById(long id);


}
