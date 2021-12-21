package com.study.config;

import com.study.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
public class MyConfig implements WebMvcConfigurer {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("index");
        registry.addViewController("/index.html").setViewName("index");
        registry.addViewController("/main.html").setViewName("dashboard");
    }
    //拦截器

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
//        注册一个拦截器
        registry.addInterceptor(new LoginInterceptor())
//                添加拦截路径
                .addPathPatterns("/**")
//                防止静态资源，首页，登录请求被拦截
                .excludePathPatterns("/static/**","/user/login","/index.html","/","/tv");

    }
}
