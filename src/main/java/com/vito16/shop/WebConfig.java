package com.vito16.shop;

import com.vito16.shop.common.web.AdminAuthenticationInterceptor;
import com.vito16.shop.common.web.AuthenticationInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig  implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new AuthenticationInterceptor()).addPathPatterns(
                "/user/*","/order/*","/cart/*"
        ).excludePathPatterns("/user/login","/user/reg","/user/logout");

        registry.addInterceptor(new AdminAuthenticationInterceptor()).addPathPatterns(
                "/admin/*","/*/admin/*"
        ).excludePathPatterns("/admin/login","/admin/logout");
    }
}
