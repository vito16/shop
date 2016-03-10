package com.vito16.shop.test;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.vito16.shop.model.Admin;
import com.vito16.shop.model.Product;
import com.vito16.shop.model.User;
import com.vito16.shop.service.AdminService;
import com.vito16.shop.service.OrderService;
import com.vito16.shop.service.ProductService;
import com.vito16.shop.service.UserService;

/**
 * 初始化测试用例
 * <p/>
 * 插入部分基本的测试数据
 * <p/>
 * Created by Vito on 2014/7/15.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/applicationContext.xml"})
@Transactional
@Commit
public class InitiTest {

    @Autowired
    ProductService productService;
    @Autowired
    UserService userService;
    @Autowired
    OrderService orderService;
    @Autowired
    AdminService adminService;

    @Test
    public void testInit() {
        Admin admin = new Admin();
        admin.setUsername("vito");
        admin.setPassword("123456");
        adminService.save(admin);

        User user = new User();
        user.setUsername("zhouwentao");
        user.setPassword("123456");
        userService.save(user);

        Product team1 = new Product();
        team1.setTitle("3T Doric Team Carbon 坐管");
        team1.setPoint(799);
        team1.setModel("3T-TEAM-DORIC-309");
        team1.setCreateTime(new Date());
        team1.setInputUser(admin);
        productService.save(team1);

        Product team2 = new Product();
        team2.setTitle("BMC SLR01 车队版全碳车架");
        team2.setPoint(19799);
        team2.setModel("BMC-SLR01");
        team2.setCreateTime(new Date());
        team2.setInputUser(admin);
        productService.save(team1);

        Product team3 = new Product();
        team3.setTitle("FOX FLOAT 32 CTD气压前叉");
        team3.setPoint(19799);
        team3.setModel("FOX-32-100");
        team3.setCreateTime(new Date());
        team3.setInputUser(admin);
        productService.save(team1);
    }

}
