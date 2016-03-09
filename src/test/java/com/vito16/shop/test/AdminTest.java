package com.vito16.shop.test;

import com.vito16.shop.model.Admin;
import com.vito16.shop.service.AdminService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Vito on 2014/7/15.
 */
public class AdminTest extends BaseTest{

    @Autowired
    AdminService adminService;

    @Test
    public void testAddAdmin() {
        Admin admin = new Admin();
        admin.setUsername("vito");
        admin.setPassword("123456");
        adminService.save(admin);
    }

}
