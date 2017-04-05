package com.fheebiy.controller;

import com.fheebiy.dto.GiftDto;
import com.fheebiy.dto.GoodChipDto;
import com.fheebiy.rest.JsonResponse;
import com.fheebiy.service.GiftService;
import com.fheebiy.service.GoodChipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by cm on 2017/4/5.
 */
@Controller
@RequestMapping("/home")
public class HomePageController {

    @Autowired
    private GiftService giftService;

    @Autowired
    private GoodChipService goodChipService;


    @RequestMapping("/list")
    @ResponseBody
    public Object getGiftAndChipList(HttpServletRequest request) {
        int count = Integer.parseInt(request.getParameter("count"));
        long updateTime = Long.parseLong(request.getParameter("updateTime"));
        if (updateTime == 0) {
            updateTime = System.currentTimeMillis();
        }
        List<GiftDto> giftDtoList = giftService.getAList(count, updateTime);
        List<GoodChipDto> list = goodChipService.getAList(count, updateTime);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("gifts", giftDtoList);
        map.put("chips", list);
        return new JsonResponse(map);
    }


}
