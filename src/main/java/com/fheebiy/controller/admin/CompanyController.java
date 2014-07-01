package com.fheebiy.controller.admin;

import com.alibaba.fastjson.JSON;
import com.fheebiy.domain.Company;
import com.fheebiy.repo.CompanyRepo;
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
@RequestMapping("company")
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
        int pno = 1;
        int psize = 10;
        String pnoStr = request.getParameter("pno");
        String psizeStr = request.getParameter("psize");
        if(StringUtils.isNotEmpty(pnoStr)){
            pno = Integer.parseInt(pnoStr);
        }
        if(StringUtils.isNotEmpty(psizeStr)){
            psize = Integer.parseInt(psizeStr);
        }
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("name", name);
        map.put("address", address);
        map.put("pst",(pno-1)*psize);
        map.put("psize",psize);
        List<Company> list = repo.getList(map);
        System.out.println("time="+list.get(0).getCreate_time());
        String s =  JSON.toJSONString(list);
        System.out.println(s);
        return list;
    }
}
