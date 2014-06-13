/**
 * 
 */
package com.vito16.shop.controller;

import com.vito16.shop.model.Product;
import com.vito16.shop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;

/**
 * @author Vito
 * @email zhouwentao16@gmail.com
 * @date 2013-7-17
 * 
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

    @RequestMapping(value="/",method = RequestMethod.GET)
    public ModelAndView listProduct(ModelAndView model){
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
	public String doNew(Product product) {
        product.setCreateTime(new Date());
		productService.save(product);
        return "redirect:/product/";
	}
}
