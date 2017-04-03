package com.fheebiy.controller;

import com.fheebiy.common.web.HttpParameterUtil;
import com.fheebiy.domain.UserChip;
import com.fheebiy.rest.JsonResponse;
import com.fheebiy.rest.JsonResponseHeader;
import com.fheebiy.service.TreeService;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by cm on 2017/4/3.
 */
@Controller
@RequestMapping("/tree")
public class TreeController {

    @Autowired
    TreeService treeService;

    @RequestMapping("/burstout")
    @ResponseBody
    public Object burstOutChip(HttpServletRequest request) {
        long user_id = HttpParameterUtil.getParameterLong(request,"user_id");
        int type = HttpParameterUtil.getParameterInt(request, "type");
        List<UserChip> list =   treeService.burstOutChip(user_id, type);
        if (CollectionUtils.isNotEmpty(list)) {
            return new JsonResponse(JsonResponseHeader.STATUS_DATA_ERROR);
        }
        return new JsonResponse(list);
    }



}
