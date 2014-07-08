package com.fheebiy.controller.admin;

import com.fheebiy.common.web.HttpParameterUtil;
import com.fheebiy.common.web.PageContextUtil;
import com.fheebiy.domain.Car;
import com.fheebiy.dto.CarDto;
import com.fheebiy.repo.CarRepo;
import com.fheebiy.rest.JsonResponse;
import com.fheebiy.rest.JsonResponseCreator;
import com.fheebiy.service.CarService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by bob zhou on 14-7-3.
 */
@Controller
@RequestMapping("admin/car")
public class CarController {

    @Autowired
    private CarService carService;

    @Autowired
    private CarRepo repo;

    @RequestMapping("list")
    @ResponseBody
    public Object getList(HttpServletRequest request) {
        String carNum = request.getParameter("carNum");
        String company = request.getParameter("company");
        PageContextUtil.initPageContext(request);
        List<CarDto> list = carService.getList(carNum, company);
        return JsonResponseCreator.createJsonPage(list);
    }


    @RequestMapping("viewlist")
    public String viewList() {
        return "admin/car/list";
    }

    @RequestMapping("save")
    @ResponseBody
    public Object saveOrUpdate(HttpServletRequest request) {
        String idStr = request.getParameter("id");
        String deviceIdStr = request.getParameter("device_id");
        String tonnageStr = request.getParameter("tonnage");
        String carNum = request.getParameter("carNum");
        String carType = request.getParameter("carType");
        String carBrand = request.getParameter("carBrand");
        String remark = request.getParameter("remark");
        Car car = new Car();
        if (StringUtils.isNotEmpty(idStr)) {
            long id = Long.parseLong(idStr);
            car.setId(id);
        }
        if (StringUtils.isNotEmpty(deviceIdStr)) {
            long device_id = Long.parseLong(deviceIdStr);
            car.setDevice_id(device_id);
        }
        if (StringUtils.isNotEmpty(tonnageStr)) {
            double tonnage = Long.parseLong(tonnageStr);
            car.setTonnage(tonnage);
        }
        long company_id = HttpParameterUtil.getParameterLong(request, "company_id");
        car.setCompany_id(company_id);
        car.setCarNum(carNum);
        car.setCarType(carType);
        car.setCarBrand(carBrand);
        car.setRemark(remark);

        long id = car.getId();
        Car carr = repo.getById(id);
        if (carr == null) {
            Car carl = repo.getCarByCarNum(car.getCarNum());
            if (carl == null) {
                repo.save(car);
            } else {
                return new JsonResponse(201);
            }
        } else {
            repo.update(car);
        }
        return new JsonResponse();
    }

    @RequestMapping("delete")
    @ResponseBody
    public Object delete(long id) {
        repo.delete(id);
        return new JsonResponse();
    }

}
