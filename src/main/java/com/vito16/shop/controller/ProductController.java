/**
 *
 */
package com.vito16.shop.controller;

import com.vito16.shop.common.Page;
import com.vito16.shop.common.PageUtil;
import com.vito16.shop.model.Product;
import com.vito16.shop.service.ProductService;
import com.vito16.shop.util.AdminUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
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
    private static final Logger logger = LoggerFactory.getLogger(ProductController.class);

    @RequestMapping(value = "/new", method = RequestMethod.GET)
    public String newForm(HttpSession session) {
        if (AdminUtil.getAdminFromSession(session) == null) {
            return "redirect:/admin/login?error=true";
        }
        return "product/productNew";
    }

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public ModelAndView admin(ModelAndView model, HttpSession session, HttpServletRequest request) {
        if (AdminUtil.getAdminFromSession(session) == null) {
            model.setViewName("redirect:/admin/login?error=true");
            return model;
        }
        Page<Product> page = new Page<Product>(PageUtil.PAGE_SIZE);
        int[] pageParams = PageUtil.init(page, request);
        productService.findProducts(page, pageParams);
        model.addObject("page", page);
        model.setViewName("product/productAdmin");
        return model;
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public ModelAndView edit(ModelAndView model, HttpSession session, @PathVariable Integer id) {
        if (AdminUtil.getAdminFromSession(session) == null) {
            model.setViewName("redirect:/admin/login?error=true");
            return model;
        }
        Product product = productService.findById(id);
        model.addObject("product", product);
        model.setViewName("product/productEdit");
        return model;
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public ModelAndView doEdit(ModelAndView model, Product product, HttpSession session, @RequestParam("file") MultipartFile file) {
        if (AdminUtil.getAdminFromSession(session) == null) {
            model.setViewName("redirect:/admin/login?error=true");
            return model;
        }
        if (!file.isEmpty()) {
            uploadImage(product, session, file);
        }
        product.setInputUser(AdminUtil.getAdminFromSession(session));
        productService.save(product);
        model.setViewName("redirect:/product/admin");
        return model;
    }

    private void uploadImage(Product product, HttpSession session, MultipartFile file) {
        String fileName = new Date().getTime() + ".jpg";
        String path = session.getServletContext().getRealPath("/upload");
        String serverFile = path + "/" + fileName;
        try {
            logger.info(path);
            if (!new File(path).exists()) {
                new File(path).mkdirs();
            }
            if (!new File(serverFile).exists()) {
                new File(serverFile).createNewFile();
            }
            byte[] bytes = file.getBytes();
            BufferedOutputStream stream =
                    new BufferedOutputStream(new FileOutputStream(new File(serverFile)));
            stream.write(bytes);
            stream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        product.setPicUrl("/upload/" + fileName);
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView listProduct(ModelAndView model, HttpServletRequest request) {
        Page<Product> page = new Page<Product>(PageUtil.PAGE_SIZE);
        int[] pageParams = PageUtil.init(page, request);
        productService.findProducts(page, pageParams);
        model.addObject("page", page);
        model.setViewName("product/productList");
        return model;
    }

    @RequestMapping(value = "/{id}")
    public String showInfo(@PathVariable Integer id, Model model) {
        Product product = productService.findById(id);
        model.addAttribute("product", product);
        return "product/productView";
    }

    @RequestMapping(value = "/new", method = RequestMethod.POST)
    public String doNew(Product product, HttpSession session, @RequestParam("file") MultipartFile file) {
        if (!file.isEmpty()) {
            uploadImage(product, session, file);
        }
        product.setInputUser(AdminUtil.getAdminFromSession(session));
        product.setCreateTime(new Date());
        productService.save(product);
        return "redirect:/product/admin";
    }

}
