/**
 *
 */
package com.vito16.shop.test;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.vito16.shop.dao.UserDao;
import com.vito16.shop.model.User;
import com.vito16.shop.service.UserService;

/**
 * @author 木鱼 muyu@yiji.com
 * @version 2016/03/14
 */
public class UserTest extends BaseTest {

    private static final Logger logger = LoggerFactory.getLogger(UserTest.class);


    @Autowired
    UserDao userDao;

    @Autowired
    UserService userService;

    @Test
    public void testSave() {
        User user = new User();
        user.setUsername("测试用户");
        user.setPassword("123456");
        userService.save(user);
    }


    @Test
    public void testGetLoginRole(){
        User user = new User();
        user.setUsername("测试用户");
        user.setPassword("123456");
        boolean loginCheck =         userService.checkLogin(user);
        
    }
}
