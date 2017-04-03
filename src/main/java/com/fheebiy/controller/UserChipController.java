package com.fheebiy.controller;

import com.fheebiy.common.web.HttpParameterUtil;
import com.fheebiy.domain.User;
import com.fheebiy.dto.UserChipDto;
import com.fheebiy.rest.JsonResponse;
import com.fheebiy.service.UserChipService;
import com.fheebiy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by cm on 2017/4/2.
 */
@Controller
@RequestMapping("/userchip")
public class UserChipController {

    @Autowired
    private UserChipService userChipService;

    @Autowired
    private UserService userService;

    @RequestMapping("/alist")
    @ResponseBody
    public Object getList(HttpServletRequest request) {
        String token = HttpParameterUtil.getParameter(request, "token");
        int count = HttpParameterUtil.getParameterInt(request, "count");
        User user = userService.getByToken(token);
        long updateTime = Long.parseLong(request.getParameter("updateTime"));
        if (updateTime == 0) {
            updateTime = System.currentTimeMillis();
        }
        List<UserChipDto> list = userChipService.getUserChipByUser(user.getUser_id(), updateTime, count);
        return new JsonResponse(list);
    }

/*
    @RequestMapping("/sell")
    @ResponseBody
    public Object sell111(long user_id, long kc_id, int count, int price) {
        userChipService.sell(user_id, kc_id, count, price);
        return new JsonResponse();
    }*/

    @RequestMapping("/sell")
    @ResponseBody
    public Object sell(HttpServletRequest request) {
        String token = HttpParameterUtil.getParameter(request, "token");
        long kc_id = HttpParameterUtil.getParameterLong(request, "kc_id");
        long uc_id = HttpParameterUtil.getParameterLong(request, "uc_id");
        int count = HttpParameterUtil.getParameterInt(request, "count");
        int price = HttpParameterUtil.getParameterInt(request, "price");

        int status = userChipService.sell(token, uc_id, kc_id, count, price);
        return new JsonResponse(status);
    }


}
