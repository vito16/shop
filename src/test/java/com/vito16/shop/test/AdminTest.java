package com.vito16.shop.test;

import com.vito16.shop.model.Admin;
import com.vito16.shop.model.Product;
import com.vito16.shop.service.AdminService;
import com.vito16.shop.service.ProductService;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.format.support.DefaultFormattingConversionService;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * Created by Vito on 2014/7/15.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/applicationContext.xml"})
@Transactional
@TransactionConfiguration(defaultRollback = false)
public class AdminTest {

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
