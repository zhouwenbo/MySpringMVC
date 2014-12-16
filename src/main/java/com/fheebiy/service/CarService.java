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

    public static final String COMPANY_NOT_FOUND = "NOT_FOUND";

    public List<CarDto> getList(String carNum, String companyName) {
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
        para_map.put("carNum", carNum);
        para_map.put("ids", ids);

        List<Car> carList = carRepo.getList(para_map);
        Set<Long> set = new HashSet<Long>();
        for (Car car : carList) {
            set.add(car.getCompany_id());
        }
        Map<Long, Company> map = new HashMap<Long, Company>();
        if (set.size() > 0) {
            map = companyService.getComMapByIds(set);
        }

        List<CarDto> dtoList = new ArrayList<CarDto>();
        for (Car car : carList) {
            CarDto dto = new CarDto();
            dto.setId(car.getId());
            dto.setCarNum(car.getCarNum());
            dto.setCarBrand(car.getCarBrand());
            dto.setCarType(car.getCarType());
            dto.setCompany_id(car.getCompany_id());
            Company company = map.get(car.getCompany_id());
            String comName;
            if (company == null) {
                comName = COMPANY_NOT_FOUND;
                dto.setCompany_id(0);
            } else {
                comName = company.getName();
            }
            dto.setCompanyName(comName);
            dto.setDevice_id(car.getDevice_id());
            dto.setCreate_time(car.getCreate_time());
            dto.setTonnage(car.getTonnage());
            dto.setRemark(car.getRemark());
            dtoList.add(dto);
        }
        return dtoList;
    }
}
