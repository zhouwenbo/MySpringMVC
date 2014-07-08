package com.fheebiy.service;

import com.fheebiy.domain.Car;
import com.fheebiy.domain.Company;
import com.fheebiy.dto.CarDto;
import com.fheebiy.repo.CarRepo;
import com.fheebiy.repo.CompanyRepo;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Created by bob zhou on 14-7-3.
 */
@Service
public class CarService {

    @Autowired
    private CarRepo carRepo;

    @Autowired
    private CompanyService companyService;

    public List<CarDto> getList(String carNum, String companyName) {
        String ids = null;
        if (StringUtils.isNotEmpty(companyName)) {
            List<Company> companyList = companyService.getListByName(companyName);
            Set<Long> set = new HashSet<Long>();
            for (Company company : companyList) {
                set.add(company.getId());
            }
            if (set.size() > 0) {
                ids = StringUtils.join(companyList, ",");
            }
        }

        Map<String, Object> para_map = new HashMap<String, Object>();
        para_map.put("carNum", carNum);
        para_map.put("ids", ids);

        List<Car> carList = carRepo.getList(para_map);
        Set<Long> set = new HashSet<Long>();
        for(Car car : carList){
            set.add(car.getCompany_id());
        }
        List<CarDto> dtoList = new ArrayList<CarDto>();
        if (set.size()> 0){
            Map<Long,Company> map = companyService.getComMapByIds(set);
            for(Car car : carList){
                CarDto dto = new CarDto();
                dto.setId(car.getId());
                dto.setCarNum(car.getCarNum());
                dto.setCarBrand(car.getCarBrand());
                dto.setCarType(car.getCarType());
                dto.setCompany_id(car.getCompany_id());
                dto.setCompanyName(map.get(car.getCompany_id()).getName());
                dto.setDevice_id(car.getDevice_id());
                dto.setCreate_time(car.getCreate_time());
                dto.setTonnage(car.getTonnage());
                dto.setRemark(car.getRemark());
                dtoList.add(dto);
            }
        }
        return dtoList;
    }
}
