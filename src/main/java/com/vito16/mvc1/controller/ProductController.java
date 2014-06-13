/**
 * 
 */
package com.vito16.mvc1.controller;

import com.vito16.mvc1.model.Product;
import com.vito16.mvc1.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

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

	@RequestMapping(value = "{id}")
	public ModelAndView showInfo(@PathVariable Integer id, ModelAndView model) {
		Product product = productService.findById(id);
		model.addObject("popProductList", productService.findPop());
		model.addObject("product", product);
		model.setViewName("proinfo");
		return model;
	}

	@RequestMapping(value = "/new", method = RequestMethod.POST)
	public ModelAndView doNew(Product product, ModelAndView model) {
		productService.save(product);
		return model;
	}
}
