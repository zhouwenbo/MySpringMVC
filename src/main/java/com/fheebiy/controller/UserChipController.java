package com.fheebiy.controller;

import com.fheebiy.common.web.HttpParameterUtil;
import com.fheebiy.domain.UserChip;
import com.fheebiy.rest.JsonResponse;
import com.fheebiy.service.UserChipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by cm on 2017/4/2.
 */
@Controller("/userchip")
public class UserChipController {

    @Autowired
    private UserChipService userChipService;

    @RequestMapping("/list")
    @ResponseBody
    public List<UserChip> getList(HttpServletRequest request){
        Long user_id = HttpParameterUtil.getParameterLong(request, "user_id");
        return userChipService.getUserChipByUser(user_id);
    }


    @RequestMapping("/sell")
    @ResponseBody
    public Object sell(long user_id, long kc_id, int count, int price) {
        userChipService.sell(user_id, kc_id, count, price);
        return new JsonResponse();
    }

}
