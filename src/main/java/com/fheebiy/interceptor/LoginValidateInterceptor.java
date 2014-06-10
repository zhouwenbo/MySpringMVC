package com.fheebiy.interceptor;

import com.fheebiy.model.domain.User;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;
import java.util.Set;

/**
 * Created by bob zhou on 14-4-9.
 */
public class LoginValidateInterceptor implements HandlerInterceptor {


    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        User user = (User) httpServletRequest.getSession().getAttribute("user");
        if(user == null){
           // httpServletRequest.getRequestDispatcher("../respage/login.html").forward(httpServletRequest, httpServletResponse);
            String url = getRequestURL(httpServletRequest);
            httpServletResponse.sendRedirect("/respage/login.html?redirectURL="+url);
            return false;
        }
        return true;
    }


    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }

    private String getRequestURL(HttpServletRequest httpServletRequest) {
        Map map =httpServletRequest.getParameterMap();
        Set<String> keySet = map.keySet();
        StringBuffer stringBuffer = new StringBuffer();
        if(keySet.size()> 0){
            boolean isFirst = true;
            for(String key : keySet){
                String[] array = (String[])map.get(key);
                if(isFirst){
                    stringBuffer.append("?"+key+"="+array[0]);
                    isFirst = false;
                }else{
                    stringBuffer.append("&"+key+"="+array[0]);
                }
            }
        }
        return httpServletRequest.getRequestURL().toString()+stringBuffer.toString();
    }

}
