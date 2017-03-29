package com.fheebiy.controller.admin;

import com.fheebiy.common.web.PageContextUtil;
import com.fheebiy.domain.Company;
import com.fheebiy.domain.Gift;
import com.fheebiy.dto.CarDto;
import com.fheebiy.repo.GiftRepo;
import com.fheebiy.rest.JsonResponse;
import com.fheebiy.rest.JsonResponseCreator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by cm on 2017/3/28.
 */
@Controller
@RequestMapping("admin/gift")
public class GiftController {

    @Autowired
    private GiftRepo giftRepo;

    @RequestMapping("list")
    @ResponseBody
    public Object getList(HttpServletRequest request) {
        String name = request.getParameter("name");
        PageContextUtil.initPageContext(request);
        Map map = new HashMap();
        map.put("name", name);
        List<Gift> list = giftRepo.list(map);
        return JsonResponseCreator.createJsonPage(list);
    }

    @RequestMapping("viewlist")
    public String viewList() {
        return "admin/gift/list";
    }


    @RequestMapping(value = "save")
    @ResponseBody
    public Object saveOrUpdate(Gift gift){
        long id = gift.getGift_id();
        Gift g = giftRepo.getById(id);
        if(g == null){
            gift.setCreateTime(new Date());
            gift.setUpdateTime(new Date());
            gift.setStatus(0);
            giftRepo.save(gift);
        }else {
            gift.setUpdateTime(new Date());
            giftRepo.update(gift);
        }
        return new JsonResponse();
    }


    @RequestMapping(value = "delete")
    @ResponseBody
    public Object delete(long id){
        giftRepo.delete(id);
        return new JsonResponse();
    }


}
