package com.fheebiy.service;

import com.fheebiy.domain.Company;
import com.fheebiy.domain.Device;
import com.fheebiy.dto.DeviceDto;
import com.fheebiy.repo.DeviceRepo;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Created by bob zhou on 14-7-8.
 */
@Service
public class DeviceService {

    @Autowired
    private DeviceRepo repo;

    @Autowired
    private CompanyService companyService;

    public static final String COMPANY_NOT_FOUND = "NOT_FOUND";

    /**
     * @param id          主键
     * @param deviceNo    设备编号
     * @param sim_id      sim卡号
     * @param companyName 公司名称
     * @param deviceModel 设备型号
     * @param status      状态
     * @return
     */
    public List getList(long id, String deviceNo, String sim_id, String companyName, int deviceModel, int status) {
        String ids = null;
        if (StringUtils.isNotEmpty(companyName)) {
            List<Company> companyList = companyService.getListByName(companyName);
            Set<Long> set = new HashSet<Long>();
            for (Company company : companyList) {
                set.add(company.getId());
            }
            if (set.size() > 0) {
                ids = StringUtils.join(set, ",");
            }
        }

        Map<String, Object> para_map = new HashMap<String, Object>();
        para_map.put("id", id);
        para_map.put("deviceNo", deviceNo);
        para_map.put("sim_id", sim_id);
        para_map.put("ids", ids);
        para_map.put("deviceModel", deviceModel);
        para_map.put("status", status);

        List<Device> deviceList = repo.getList(para_map);
        Set<Long> set = new HashSet<Long>();
        for (Device device : deviceList) {
            set.add(device.getCompany_id());
        }
        Map<Long, Company> map = new HashMap<Long, Company>();
        if (set.size() > 0) {
            map = companyService.getComMapByIds(set);
        }
        List<DeviceDto> list = new ArrayList<DeviceDto>();
        for (Device device : deviceList) {
            Company company = map.get(device.getCompany_id());
            String comName;
            if (company == null) {
                comName = COMPANY_NOT_FOUND;
                device.setCompany_id(0);
            } else {
                comName = company.getName();
            }
            DeviceDto dto = DeviceDto.getDto(device,comName,"");
            list.add(dto);
        }
        return list;
    }

}
