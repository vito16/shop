package com.vito16.shop.controller;

import com.vito16.shop.service.ProductService;
import com.vito16.common.log.Logger;
import com.vito16.common.log.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Vito16 zhouwentao16@gmail.com
 * @date 2013-7-8
 * 
 */
@Controller
@RequestMapping("/")
public class MainController {
	private static final Logger logger = LoggerFactory.getLogger(MainController.class);
	@Autowired
	ProductService productService;

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView index(ModelAndView model) {
		model = new ModelAndView("index");
		model.addObject("newProductList", productService.findNew());
		model.addObject("popProductList", productService.findPop());
		model.addObject("productList", productService.findAll());
		model.addObject("productTypeList", productService.findType());
		return model;
	}

}
