package com.vito16.shop.test;

import com.vito16.shop.model.Admin;
import com.vito16.shop.model.Product;
import com.vito16.shop.repository.AdminRepository;
import com.vito16.shop.service.ProductService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;

import java.util.Date;
import java.util.List;

/**
 * @author 木鱼 muyu@yiji.com
 * @version 2016/03/14
 */
public class ProductTest extends BaseTest {

    @Autowired
    ProductService productService;

    @Autowired
    private AdminRepository adminDao;

    @Test
    public void testAddProduct() {
        List<Admin> adminList = adminDao.findAll();
        Admin admin = null;
        if (CollectionUtils.isEmpty(adminList)) {
            admin = new Admin();
            admin.setUsername("product_test");
            admin.setPassword("123456");
            adminDao.save(admin);
        } else {
            admin = adminList.get(0);
        }

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
            System.out.println(product.toString());
        }
    }

}
