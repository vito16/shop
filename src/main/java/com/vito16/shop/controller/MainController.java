package com.vito16.shop.controller;

import com.vito16.shop.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Vito zhouwentao16@gmail.com
 * @date 2013-7-8
 */
@Controller("/index")
public class MainController {
	private static final Logger logger = LoggerFactory.getLogger(MainController.class);
	@Autowired
	ProductService productService;

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView index(ModelAndView model) {
		model = new ModelAndView("index");
		model.addObject("host","12341234");
		model.addObject("newProductList", productService.findNew());
		model.addObject("popProductList", productService.findPop());
		model.addObject("productList", productService.findAll());
		model.addObject("productTypeList", productService.findType());
		return model;
	}

	/**
	 * 页面访问测试方法
	 * @return
	 */
	@GetMapping("/sayHello")
	@ResponseBody
	public String aa(){
		return "hello";
	}

}
