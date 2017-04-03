package com.fheebiy.controller;

import com.fheebiy.domain.Tree;
import com.fheebiy.rest.JsonResponse;
import com.fheebiy.service.SeedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by cm on 2017/4/3.
 */
@Controller
@RequestMapping("/seed")
public class SeedController {

    @Autowired
    private SeedService seedService;

    @ResponseBody
    @RequestMapping("/plant")
    public Object plantTree(@RequestParam long seed_id, @RequestParam long user_id) {
        Tree tree = seedService.plantTree(seed_id, user_id);
        return new JsonResponse(tree);
    }

}
