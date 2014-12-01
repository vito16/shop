/**
 *
 */
package com.vito16.shop.test;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.Ini;
import org.apache.shiro.config.IniFactorySupport;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.*;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.session.mgt.SessionManager;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import com.vito16.shop.dao.UserDao;
import com.vito16.shop.model.User;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.core.Is.is;

/**
 * @author Vito16 zhouwentao16@gmail.com
 * @date 2013-7-8
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/applicationContext.xml"})
@Transactional
@TransactionConfiguration(defaultRollback = true)
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
    public void testGetLoginInfo() {
        Factory<org.apache.shiro.mgt.SecurityManager> sessionManagerFactory = new IniSecurityManagerFactory("classpath:shiro.ini");
        SecurityManager securityManager = sessionManagerFactory.getInstance();
        SecurityUtils.setSecurityManager(securityManager);
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken("zhou16", "zhou1234",true);
        subject.login(token);

        assertThat(subject.isAuthenticated(), is(true));
        PrincipalCollection principalCollection = subject.getPrincipals();
        logger.info(subject.isRemembered()+"用户登陆验证成功...." + ToStringBuilder.reflectionToString(principalCollection));
        subject.logout();
    }

    @Test
    public void testGetLoginRole(){
        login("classpath:shiro.ini","zhou16","zhou1234");
        assertThat(subject().hasRole("admin"),is(true));
        assertThat(subject().hasRole("user"),is(true));
        subject().logout();

        login("classpath:shiro.ini","vito16","zhou1234");
        assertThat(subject().hasRole("admin"),is(true));
        assertThat(subject().hasRole("user"),is(true));
        subject().logout();
    }
}
