/**
 *
 */
package com.vito16.shop.controller;

import com.vito16.shop.model.Product;
import com.vito16.shop.service.ProductService;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.util.Date;

/**
 * @author Vito
 * @email zhouwentao16@gmail.com
 * @date 2013-7-17
 */
@Controller
@RequestMapping(value = "/product")
public class ProductController {

    @Autowired
    ProductService productService;

    @RequestMapping(value = "/new", method = RequestMethod.GET)
    public Product newForm() {

        Product product = new Product();
        return product;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView listProduct(ModelAndView model) {
        model.addObject("productList", productService.findAll());
        model.setViewName("product/list");
        return model;
    }

    @RequestMapping(value = "/{id}")
    public ModelAndView showInfo(@PathVariable Integer id, ModelAndView model) {
        Product product = productService.findById(id);
        model.addObject("product", product);
        model.setViewName("product/view");
        return model;
    }

    @RequestMapping(value = "/new", method = RequestMethod.POST)
    public String doNew(Product product,HttpSession session, @RequestParam("productPic") CommonsMultipartFile productPic) {
        String path = "D:\\Work\\idea\\shop\\src\\main\\webapp\\tmm\\";  //获取本地存储路径
        String fileName = new Date().getTime()+".jpg";
        if (!productPic.isEmpty()) {
            File file = new File(path + fileName); //新建一个文件
            try {
                productPic.getFileItem().write(file);//将上传的文件写入新建的文件中
            } catch (Exception e) {
                e.printStackTrace();
            }
            product.setPicUrl("/tmp/"+fileName);
        }
        product.setCreateTime(new Date());
        productService.save(product);
        return "redirect:/product/";
    }
}
