package com.vito16.shop.controller;

import com.vito16.shop.common.Constants;
import com.vito16.shop.common.Page;
import com.vito16.shop.model.Picture;
import com.vito16.shop.model.Product;
import com.vito16.shop.service.PictureService;
import com.vito16.shop.service.ProductService;
import com.vito16.shop.util.AdminUtil;
import com.vito16.shop.util.Image;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Date;

/**
 * @author 木鱼 muyu@yiji.com
 * @version 2017/6/1
 */
@Controller
@RequestMapping(value = "/admin/product")
public class ProductAdminController {

    private static final Logger logger = LoggerFactory.getLogger(ProductAdminController.class);

    @Autowired
    ProductService productService;

    @Autowired
    PictureService pictureService;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView admin(ModelAndView model, HttpSession session, HttpServletRequest request) {
        Page<Product> page = new Page<Product>(request);
        productService.findProducts(page);
        model.addObject("page", page);
        model.setViewName("product/productAdmin");
        return model;
    }

    @RequestMapping(value = "/new", method = RequestMethod.GET)
    public String newForm(HttpSession session) {
        if (AdminUtil.getAdminFromSession(session) == null) {
            return "redirect:/admin/login?error=true";
        }
        return "product/productNew";
    }

    @RequestMapping(value = "/new", method = RequestMethod.POST)
    public String doNew(Product product, HttpSession session, @RequestParam("file") MultipartFile file) {
        if (file!=null&&!file.isEmpty()) {
            uploadImage(product, session, file);
        }
        product.setInputUser(AdminUtil.getAdminFromSession(session));
        product.setCreateTime(new Date());
        productService.save(product);
        return "redirect:/admin/product";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public ModelAndView edit(ModelAndView model, @PathVariable Integer id) {
        Product product = productService.findById(id);
        model.addObject("product", product);
        model.setViewName("admin/product/productEdit");
        return model;
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public ModelAndView doEdit(ModelAndView model, Product product, HttpSession session, @RequestParam(name = "file",required = false) MultipartFile file) {
        if (file!=null&&!file.isEmpty()) {
            uploadImage(product, session, file);
        }
        product.setInputUser(AdminUtil.getAdminFromSession(session));
        productService.save(product);
        model.setViewName("redirect:/admin/product");
        return model;
    }

    private void uploadImage(Product product, HttpSession session, MultipartFile file) {
        String fileName = generateFileName();
        String path = generateFilePath(session);
        String serverFile = path + "/" + fileName;
        Picture picture = uploadAndSaveImg(session, file, fileName, path, serverFile);
        product.setMasterPic(picture);
    }

    private String generateFilePath(HttpSession session) {
        return session.getServletContext().getRealPath("/upload");
    }

    private String generateFileName() {
        return new Date().getTime() + ".jpg";
    }

    private Picture uploadAndSaveImg(HttpSession session, MultipartFile file, String fileName, String path, String serverFile) {
        Picture picture = new Picture();
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
            //缩放处理
            Image image = new Image(serverFile);
            image.resize(Constants.IMG_WIDTH,Constants.IMG_HEIGHT);
            image.save();
        } catch (Exception e) {
            e.printStackTrace();
        }
        picture.setMemo("商品上传");
        picture.setTitle("商品上传");
        picture.setUpdateTime(new Date());
        picture.setUrl("/upload/" + fileName);
        picture.setUpdateAdmin(AdminUtil.getAdminFromSession(session));
        pictureService.save(picture);
        return picture;
    }
}
