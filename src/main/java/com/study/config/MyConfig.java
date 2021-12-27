package com.study.config;

import com.study.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Author 陈晨 2018150347
 * spring 配置文件
 */
@Configuration
public class MyConfig implements WebMvcConfigurer {
    // 视图控制器
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
