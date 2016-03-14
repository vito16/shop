package com.vito16.shop.test;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.format.support.DefaultFormattingConversionService;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.vito16.shop.model.Admin;
import com.vito16.shop.model.Product;
import com.vito16.shop.service.AdminService;
import com.vito16.shop.service.ProductService;

/**
 * @author 木鱼 muyu@yiji.com
 * @version 2016/03/14
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/applicationContext.xml"})
@Transactional
@Rollback
public class ProductTest {

    @Autowired
    AdminService adminService;
    @Autowired
    ProductService productService;

    @Test
    public void test() throws SecurityException, NoSuchFieldException {
        //默认自动注册对@NumberFormat和@DateTimeFormat的支持
        DefaultFormattingConversionService conversionService =
                new DefaultFormattingConversionService();

        //准备测试模型对象
        Product model = new Product();
        model.setCreateTime(new Date());

        //获取类型信息
        TypeDescriptor descriptor =
                new TypeDescriptor(Product.class.getDeclaredField("createTime"));
        TypeDescriptor stringDescriptor = TypeDescriptor.valueOf(Date.class);

        System.out.println(conversionService.convert(model.getCreateTime(), descriptor, stringDescriptor));
    }

    @Test
    public void testAddProduct() {
        Admin admin = adminService.findOne(1);
        Product product = new Product();
        product.setCreateTime(new Date());
        product.setInputUser(admin);
        product.setCode("KDF-SD1-200");
        product.setStock(200l);
        product.setModel("400CM");
        product.setPoint(200);
        product.setTitle("3T Pro 铝坐管");

        Product product2 = new Product();
        product2.setCreateTime(new Date());
        product2.setInputUser(admin);
        product2.setCode("BMC-SLR01-54");
        product2.setStock(200l);
        product2.setModel("54");
        product2.setPoint(19999);
        product2.setTitle("MBC SLR01 车队版碳纤维车架");

        productService.save(product2);
        productService.save(product);

    }

    @Test
    public void testFindNew() {
        List<Product> productList = productService.findOld();
        for (Product product : productList) {
            System.out.println(ToStringBuilder.reflectionToString(product));
        }
    }

}
