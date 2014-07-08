package com.fheebiy.controller.admin;

import com.alibaba.fastjson.JSON;
import com.fheebiy.common.web.PageContextUtil;
import com.fheebiy.domain.Company;
import com.fheebiy.repo.CompanyRepo;
import com.fheebiy.rest.JsonResponse;
import com.fheebiy.rest.JsonResponseCreator;
import com.mongodb.util.Hash;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by bob zhou on 14-7-1.
 */
@Controller
@RequestMapping("admin/company")
public class CompanyController {

    @Autowired
    private CompanyRepo repo;

    @RequestMapping("viewlist")
    public String viewList() {
        return "admin/company/list";
    }

    @RequestMapping(value = "list")
    @ResponseBody
    public Object list(HttpServletRequest request) {
        String name = request.getParameter("name");
        String address = request.getParameter("address");
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("name", name);
        map.put("address", address);
        PageContextUtil.initPageContext(request);
        List<Company> list = repo.getList(map);
        return JsonResponseCreator.createJsonPage(list);
    }

    @RequestMapping(value = "save")
    @ResponseBody
    public Object saveOrUpdate(Company company){
        long id = company.getId();
        Company comp = repo.getById(id);
        if(comp == null){
            repo.save(company);
        }else {
            repo.update(company);
        }
        return new JsonResponse();
    }

    @RequestMapping(value = "delete")
    @ResponseBody
    public Object delete(long id){
        repo.delete(id);
        return new JsonResponse();
    }

}
