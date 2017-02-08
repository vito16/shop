package com.vito16.shop.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author 木鱼 muyu@yiji.com
 * @version 2017/2/8
 */
@Component
public class AppConfig {

    @Value("${user.cookie.name}")
    public String USER_COOKIE_NAME;

    @Value("${user.cookie.age}")
    public int USER_COOKIE_AGE;
}
