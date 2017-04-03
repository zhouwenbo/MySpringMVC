package com.fheebiy.controller;

import com.fheebiy.common.web.HttpParameterUtil;
import com.fheebiy.domain.GoodChip;
import com.fheebiy.domain.User;
import com.fheebiy.dto.GoodChipDto;
import com.fheebiy.rest.JsonResponse;
import com.fheebiy.rest.JsonResponseHeader;
import com.fheebiy.service.GoodChipService;
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
@Controller("/goodchip")
public class GoodChipController {

    @Autowired
    private GoodChipService goodChipService;

    @Autowired
    private UserService userService;

    @Autowired
    private UserChipService userChipService;

    @RequestMapping("/buy")
    @ResponseBody
    public Object buy(HttpServletRequest request) {
        long gc_id = HttpParameterUtil.getParameterLong(request, "gc_id");
        long user_id = HttpParameterUtil.getParameterLong(request, "user_id");      //买家的user_id
        GoodChip goodChip = goodChipService.getById(gc_id);
        if (goodChip != null) {
            User buyer = userService.getUserById(user_id);
            User seller = userService.getUserById(goodChip.getUser_id());
            int price = goodChip.getPrice();
            long gold = buyer.getGold();
            if (gold < price) {
                return new JsonResponse(JsonResponseHeader.STATUS_GOLD_NOT_ENOUGH);
            } else {
                //买家的金币减少
                long currentGold = gold - price;
                userService.updateGold(currentGold, user_id);
                userService.updateGold(seller.getGold() + price, seller.getUser_id());

                userChipService.updateChip(goodChip,buyer.getUser_id(), seller.getUser_id() );
                //goodChipService.
            }

        } else {
            return new JsonResponse(JsonResponseHeader.STATUS_CHIP_NOT_EXIST);
        }

        return new JsonResponse();
    }

    @RequestMapping("/alist")
    @ResponseBody
    public Object getAList(HttpServletRequest request) {
        int count = Integer.parseInt(request.getParameter("count"));
        long updateTime = Long.parseLong(request.getParameter("updateTime"));
        if (updateTime == 0) {
            updateTime = System.currentTimeMillis();
        }
        List<GoodChipDto> list = goodChipService.getAList(count, updateTime);
        return new JsonResponse(list);
    }

}
