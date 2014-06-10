package com.fheebiy.controller;

import com.fheebiy.model.domain.Phone;
import com.fheebiy.repo.impl.PhoneRepoImpl;
import com.fheebiy.service.PhoneService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by Administrator on 14-4-19.
 */
@Controller
@RequestMapping("/phone")
public class PhoneController {

    @Autowired
    PhoneService phoneService;

    @Autowired
    PhoneRepoImpl phoneRepo;

    @RequestMapping(value="/find/{pid}")
    public String editPhone(Model model, @PathVariable("pid") long phone_id){
       Phone phone = phoneService.getPhoneById(phone_id);
       model.addAttribute("phone", phone);
       return "phone/edit";
    }

    @RequestMapping(value ="/add")
    public String add(){
        return "phone/add";
    }

    @RequestMapping("/save")
    public String savePhone(Phone phone){
        phoneService.save(phone);
        return "success";
    }

    @RequestMapping(value ="/query")
    public String query(){
        return "phone/query";
    }


    @RequestMapping("/list")
    public String list(HttpServletRequest request, Model model) {
        String xinghao = request.getParameter("xinghao");
        String phone_idStr = request.getParameter("phone_id");
        String priceStr = request.getParameter("price");
        if(StringUtils.isNotEmpty(phone_idStr)){
            long phone_id = Long.parseLong(phone_idStr);
        }
        double price = 0 ;
        if(StringUtils.isNotEmpty(priceStr)){
             price = Double.parseDouble(priceStr);
        }
        List<Phone> list = phoneService.getList(price, xinghao);
        model.addAttribute("list", list);
        return "phone/list";
    }

    @RequestMapping("/update")
    public String updatePhone(Phone phone){
        phoneService.update(phone);
        return "success";
    }
}
