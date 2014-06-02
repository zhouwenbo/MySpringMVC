package com.fheebiy.controller;

import com.fheebiy.model.domain.User;
import com.fheebiy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by zwb on 14-3-31.
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/find")
    public String editUser(Model model,@RequestParam(required=true)Long user_id){
        User user = userService.getUserById(user_id);
        model.addAttribute("user", user);
        return "user/edit";
    }


    @RequestMapping("/login")
    public void doLogin(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, @RequestParam(required = true)String user_name, @RequestParam(required = true)String password,@RequestParam(required = false)String redirectURL) throws IOException {

       String x ;

        User user = userService.doLogin(user_name, password);
        if(user == null){
            if(!StringUtils.isEmpty(redirectURL)){
                httpServletResponse.sendRedirect("/mvc/respage/login.html?redirectURL="+redirectURL);
            }
        }else{
            httpServletRequest.getSession().setAttribute("user", user);
            if(!StringUtils.isEmpty(redirectURL)){
                httpServletResponse.sendRedirect(redirectURL);
            }else{
                httpServletResponse.sendRedirect("/mvc/index.jsp");
            }
        }
    }
}
