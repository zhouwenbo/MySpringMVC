package com.fheebiy.controller;

import com.fheebiy.common.DateUtil;
import com.fheebiy.common.smsgcode.HttpSender;
import com.fheebiy.domain.SmsCode;
import com.fheebiy.domain.User;
import com.fheebiy.repo.SmsCodeRepo;
import com.fheebiy.rest.JsonResponse;
import com.fheebiy.rest.JsonResponseHeader;
import com.fheebiy.service.UserService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

/**
 * Created by zwb on 14-3-31.
 */
@Controller
@RequestMapping("/user")
public class UserController {

    public static final String ST_NONE_CODE = "1";

    public static final String ST_HAVE_CODE = "2";

    @Autowired
    private UserService userService;

    @Autowired
    private SmsCodeRepo smsCodeRepo;

    @RequestMapping("/find")
    public String editUser(Model model,@RequestParam(required=true)Long user_id){
        User user = userService.getUserById(user_id);
        model.addAttribute("user", user);
        return "user/detail";
    }


    @RequestMapping("/login")
    public void doLogin(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, @RequestParam(required = true)String user_name, @RequestParam(required = true)String password,@RequestParam(required = false)String redirectURL) throws IOException {
        User user = userService.doLogin(user_name, password);
        if(user == null){
            if(!StringUtils.isEmpty(redirectURL)){
                httpServletResponse.sendRedirect("/respage/login.html?redirectURL="+redirectURL);
            }
        }else{
            httpServletRequest.getSession().setAttribute("user", user);
            if(!StringUtils.isEmpty(redirectURL)){
                httpServletResponse.sendRedirect(redirectURL);
            }else{
                httpServletResponse.sendRedirect("/index.jsp");
            }
        }
    }

    @RequestMapping("/register")
    @ResponseBody
    public Object doRegister(HttpServletRequest request) {
        String phone = request.getParameter("phone");
        String st = request.getParameter("st");
        String code = request.getParameter("code");
        if (ST_NONE_CODE.equals(st)) {
            if (!StringUtils.isEmpty(phone) && phone.length() > 10) {
                int resultCode = HttpSender.sendSMS(phone);
                System.out.print("___________resultCode-------------" + resultCode);
                if (resultCode > 0) {
                    SmsCode smsCode = new SmsCode();
                    smsCode.setCode(resultCode);
                    smsCode.setPhoneNum(phone);
                    smsCode.setUpdateTime(new Date());
                    smsCodeRepo.save(smsCode);
                    System.out.println("save_____________gogogo!!");
                    return new JsonResponse();
                }
            }
        } else if (ST_HAVE_CODE.equals(st)) {
            if (StringUtils.isNotEmpty(phone) && StringUtils.isNotEmpty(code)) {
                SmsCode smsCode = smsCodeRepo.findByPhoneAndCode(phone, code);
                if (smsCode != null) {
                    long updateTime = smsCode.getUpdateTime().getTime();
                    System.out.println("smsCode------------------!!" + smsCode.getPhoneNum() + " ,smsCode = " + smsCode.getCode_id());
                    if (System.currentTimeMillis() - updateTime < 10 * DateUtil.ONE_MINUTE) {
                        return new JsonResponse();
                    } else {
                        return new JsonResponse(JsonResponseHeader.STATUS_REGISTER_CODE_DELAY, null);
                    }
                }
            } else {
                new JsonResponse(JsonResponseHeader.STATUS_REGISTER_CODE_ERROR, null);
            }
        }
        return new JsonResponse();
    }

}
