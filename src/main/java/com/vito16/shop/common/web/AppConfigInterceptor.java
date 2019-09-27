package com.vito16.shop.common.web;

import com.vito16.shop.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 全局系统配置添加到Controller级别中
 *
 * @author 木鱼 muyu@yiji.com
 * @version 2019/9/22
 */
@Slf4j
@Component
public class AppConfigInterceptor implements HandlerInterceptor, InitializingBean {

    @Autowired
    UserService userService;

    @Autowired
    Environment env;


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object object) throws Exception {
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest,
                           HttpServletResponse httpServletResponse,
                           Object o, ModelAndView modelAndView) throws Exception {
        //将Env放入每个Response范围中，方便模板页面调用
//        modelAndView.addObject("env", env);
    }
    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest,
                                HttpServletResponse httpServletResponse,
                                Object o, Exception e) throws Exception {
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        /*Properties props = new Properties();
        MutablePropertySources propSrcs = ((AbstractEnvironment) springEnv).getPropertySources();
        StreamSupport.stream(propSrcs.spliterator(), false)
                .filter(ps -> ps instanceof EnumerablePropertySource)
                .map(ps -> ((EnumerablePropertySource) ps).getPropertyNames())
                .flatMap(Arrays::<String>stream)
                .forEach(propName -> props.setProperty(propName, springEnv.getProperty(propName)));*/
        //TODO 将全系统配置放入缓存中，方便获取
    }
}
