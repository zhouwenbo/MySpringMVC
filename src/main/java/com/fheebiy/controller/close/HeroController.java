package com.fheebiy.controller.close;

import com.fheebiy.model.domain.Hero;
import com.fheebiy.service.HeroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Created by zwb on 14-4-9.
 */

@Controller
@RequestMapping("/hero")
public class HeroController {

    @Autowired
    private HeroService heroService;

    @RequestMapping("/list")
    public String viewList(){
       List<Hero> heroList = heroService.getList();
        return "";
    }

    @RequestMapping("/edit")
    public String edit(Model model,@RequestParam(required=false)Long hero_id){
        Hero hero = heroService.getHeroById(hero_id);
        model.addAttribute("hero", hero);
        return "hero/edit";
    }

    @RequestMapping(value="/find/{hid}")
    public String find(Model model, @PathVariable("hid") long hero_id){
        Hero hero = heroService.getHeroById(hero_id);
        model.addAttribute("hero", hero);
        return "hero/detail";
    }

}
