package com.gsd.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName LoginInterceptor.java
 * @Description TODO
 * @createTime 2023年09月18日 15:00:00
 */

public class LoginInterceptor implements HandlerInterceptor {
    /*
    看一下HandlerIntegerceptor的几个方法
        1. preHanle 为true时放行，false则进入afterComplete
        2. posthandle和afterComplete没有拦截功能
     */

    //在SpringMVC种配置？看一下父子容器都包含什么
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("进入权限拦截器");
        //判断session里面有没有admin对象
        if(request.getSession().getAttribute("admin")!=null){
            System.out.println("已登录，直接跳转");
            return true;
        }
        System.out.println("未登录，跳转到登录画面");
        response.sendRedirect(request.getContextPath()+"/login.jsp");
        return false;
        //return HandlerInterceptor.super.preHandle(request, response, handler);
    }
}
