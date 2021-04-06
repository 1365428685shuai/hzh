package com.ami.interceptor;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 自定义登陆拦截器
 */
public class LoginInterceptor extends HandlerInterceptorAdapter {

    /**
     *这个preHandle方法是在controller层方法执行之前执行的，因此拦截的代码通常是写在这个方法中
     * 如果返回值为true表示放行，然后执行controller层的方法
     * 如果返回值为false，那么就不执行controller层的方法，通常会将请求重定向
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
                             Object handler) throws Exception {
        // 查看session中是否存在user，即用户是否已经登陆
        if(request.getSession().getAttribute("user") == null){
            // 不存在那么就重定向到 /admin
            response.sendRedirect("/admin");
            // 不允许通过
            return false;
        }
        return true;// 允许通过
    }
}
