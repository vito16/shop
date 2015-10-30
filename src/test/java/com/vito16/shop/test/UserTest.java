/**
 *
 */
package com.vito16.shop.test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

import com.vito16.shop.Application;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.vito16.shop.dao.UserDao;
import com.vito16.shop.model.User;

/**
 * @author Vito16 zhouwentao16@gmail.com
 * @date 2013-7-8
 */
public class UserTest extends BaseTest {

    private static final Logger logger = LoggerFactory.getLogger(UserTest.class);


    @Autowired
    UserDao userDao;

    @Test
    public void testSave() {
        User u = new User();
        u.setUsername("测试用户");
        u.setPassword("123456");
        userDao.save(u);
    }


    @Test
    public void testGetLoginRole(){
        /*login("classpath:shiro.ini","zhou16","zhou1234");
        assertThat(subject().hasRole("admin"),is(true));
        assertThat(subject().hasRole("user"),is(true));
        subject().logout();

        login("classpath:shiro.ini","vito16","zhou1234");
        assertThat(subject().hasRole("admin"),is(true));
        assertThat(subject().hasRole("user"),is(true));
        subject().logout();*/
    }
}
