package com.vito16.shop;

import com.vito16.shop.common.web.AdminAuthenticationInterceptor;
import com.vito16.shop.common.web.AppConfigInterceptor;
import com.vito16.shop.common.web.AuthenticationInterceptor;
import com.vito16.shop.model.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig  implements WebMvcConfigurer {

    @Autowired
    AppConfigInterceptor appConfigInterceptor;

    @Autowired
    AuthenticationInterceptor authenticationInterceptor;

    @Autowired
    AdminAuthenticationInterceptor adminAuthenticationInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(authenticationInterceptor).addPathPatterns(
                "/user/*","/order/*","/cart/*"
        ).excludePathPatterns("/user/login","/user/reg","/user/logout");

        registry.addInterceptor(adminAuthenticationInterceptor).addPathPatterns(
                "/admin/*","/*/admin/*"
        ).excludePathPatterns("/admin/login","/admin/reg","/admin/logout");


        registry.addInterceptor(appConfigInterceptor).addPathPatterns(
                "/*"
        );

    }
}
