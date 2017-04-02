package com.fheebiy.controller.admin;

import com.fheebiy.common.web.PageContextUtil;
import com.fheebiy.domain.KindChip;
import com.fheebiy.rest.JsonResponse;
import com.fheebiy.rest.JsonResponseCreator;
import com.fheebiy.service.KindChipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by cm on 2017/3/31.
 */
@Controller
@RequestMapping("admin/kindchip")
public class KindChipController {

    @Autowired
    private KindChipService kindChipService;

    @RequestMapping("list")
    @ResponseBody
    public Object getList(HttpServletRequest request) {
        String name = request.getParameter("name");
        PageContextUtil.initPageContext(request);
        //Map map = new HashMap();
        //map.put("name", name);
        // List<Gift> list = giftRepo.list(map);
        List<KindChip> list = kindChipService.getList(name);
        return JsonResponseCreator.createJsonPage(list);
    }


    @RequestMapping("alist")
    @ResponseBody
    public Object getAList(HttpServletRequest request) {
        int count = Integer.parseInt(request.getParameter("count"));
        long last_id = Long.parseLong(request.getParameter("last_id"));
        List<KindChip> list = kindChipService.getAList(count, last_id);
        return new JsonResponse(list);
    }


    @RequestMapping("viewlist")
    public String viewList() {
        return "admin/kindchip/list";
    }


}
