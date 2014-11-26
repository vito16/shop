package com.vito16.shop.controller;

import com.vito16.shop.model.Product;
import com.vito16.shop.service.ProductService;
import com.vito16.shop.util.CartUtil;
import com.vito16.common.log.Logger;
import com.vito16.common.log.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

/**
 * @author Vito zhouwentao16@gmail.com
 * @date 2013-7-8
 */
@Controller
@RequestMapping("/cart")
public class CartController {
    private static final Logger logger = LoggerFactory.getLogger(CartController.class);
    @Autowired
    ProductService productService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String cart() {
        return "order/cart";
    }

    @RequestMapping(value = "/add/{id}/{total}")
    @ResponseBody
    public String addToCart(ModelAndView model, @PathVariable Integer id, @PathVariable Integer total, HttpSession session) {
        Product product = productService.findById(id);
        CartUtil.saveProductToCart(session, product, total);
        logger.debug("添加到购物车成功...");
        return "success";
    }

    @RequestMapping(value = "/delete/{id}")
    @ResponseBody
    public String deleteFromCart(ModelAndView model, @PathVariable(value = "id") Integer productId, HttpSession session) {
        CartUtil.deleteProductFromCart(session, productId);
        logger.debug("购物车商品删除成功...");
        return "success";
    }

    @RequestMapping(value = "/deleteAll")
    @ResponseBody
    public String deleteAllFromCart(HttpSession session) {
        CartUtil.cleanCart(session);
        logger.debug("购物车商品清空成功...");
        return "success";
    }
}
