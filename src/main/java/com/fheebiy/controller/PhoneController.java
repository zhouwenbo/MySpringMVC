package com.fheebiy.controller;

import com.fheebiy.common.KestrelUtil;
import com.fheebiy.common.MongoUtil;
import com.fheebiy.domain.Phone;
import com.fheebiy.repo.PhoneRepo;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by bob zhou on 14-4-19.
 */
@Controller
@RequestMapping("/phone")
public class PhoneController {

    @Autowired
    PhoneRepo phoneRepo;

    @Value("${kestrel.server.host}")
    static String server;

    @RequestMapping(value = "/find/{pid}")
    public String editPhone(Model model, @PathVariable("pid") long phone_id) {
        Phone phone = phoneRepo.findById(phone_id);
        model.addAttribute("phone", phone);
        return "success";
    }

    @RequestMapping(value = "/add")
    public String add() {
        return "phone/add";
    }

    @RequestMapping("/save")
    public String savePhone(Phone phone) {
        long phone_id = MongoUtil.nextId(MongoUtil.COLL_PHONE);
        phone.setPhone_id(phone_id);
        phoneRepo.save(phone);
        return "success";
    }

    @RequestMapping(value = "/query")
    public String query() {
        return "phone/query";
    }


    @RequestMapping("/list")
    public String list(HttpServletRequest request, Model model) {
        String name = request.getParameter("name");
        String phone_idStr = request.getParameter("phone_id");
        String priceStr = request.getParameter("price");
        if(StringUtils.isEmpty(name)){
            name = null;
        }
        Long phone_id = 0l;
        if (StringUtils.isNotEmpty(phone_idStr)) {
            phone_id = Long.parseLong(phone_idStr);
        }
        Double price = 0.0;
        if (StringUtils.isNotEmpty(priceStr)) {
            price = Double.parseDouble(priceStr);
        }
        String s = KestrelUtil.receive("qname");
        List<Phone> list = phoneRepo.getPhoneList(name,phone_id,price);
        model.addAttribute("list", list);
        return "phone/list";
    }
}
