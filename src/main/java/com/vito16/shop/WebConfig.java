package com.vito16.shop;

import org.springframework.boot.autoconfigure.velocity.VelocityProperties;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.velocity.VelocityLayoutViewResolver;

/**
 * @author 木鱼 muyu@yiji.com
 * @version 2016/03/14
 */
@EnableSpringDataWebSupport
public class WebConfig extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(WebConfig.class);
    }

    @Bean(name = "velocityViewResolver")
    public VelocityLayoutViewResolver velocityViewResolver(VelocityProperties properties) {
        VelocityLayoutViewResolver resolver = new VelocityLayoutViewResolver();
        properties.applyToViewResolver(resolver);
        resolver.setLayoutUrl("layout/default.vm");
        return resolver;
    }
}
