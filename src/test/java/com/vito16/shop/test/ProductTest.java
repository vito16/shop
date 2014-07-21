package com.vito16.shop.test;

import com.vito16.shop.model.Product;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.format.support.DefaultFormattingConversionService;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * Created by Vito on 2014/7/15.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/applicationContext.xml"})
@Transactional
@TransactionConfiguration(defaultRollback = true)
public class ProductTest {
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

}
