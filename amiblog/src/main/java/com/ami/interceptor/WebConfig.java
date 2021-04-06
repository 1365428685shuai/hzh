package com.ami.interceptor;


import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 配置过滤器
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {
    /**
     * 添加拦截器
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 添加我们自定义的拦截器
        registry.addInterceptor(new LoginInterceptor())
                .addPathPatterns("/admin/**") // 设置要拦截Controller层方法的路径
                .excludePathPatterns("/admin")// 设置不拦截的Controller层方法的路径
                .excludePathPatterns("/admin/login");// 设置不拦截的Controller层方法的路径
    }
}