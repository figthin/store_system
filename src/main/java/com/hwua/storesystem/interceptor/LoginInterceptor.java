package com.hwua.storesystem.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginInterceptor implements HandlerInterceptor {


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (request.getRequestURI().contains("/login")){
            return true;
        }
        Object manager = request.getSession().getAttribute("manager");
        if (manager == null){
            response.sendRedirect("/login");
            return false;
        }else {
            return true;
        }
    }
}
