package com.vito16.shop.controller;

import com.vito16.shop.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Vito16 zhouwentao16@gmail.com
 * @date 2013-7-8
 * 
 */
@Controller
@RequestMapping("/order")
public class OrderController {
	private static final Logger logger = LoggerFactory.getLogger(OrderController.class);
	
	@RequestMapping(method = RequestMethod.GET)
	public String index() {
		return "user/index";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public User loginForm() {
		User user = new User();

		return user;
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String doLogin(User user, HttpSession session) {
		return "user/index";
	}

	@RequestMapping("/list")
	public ModelAndView listUser(ModelAndView model) {
		List<User> userList = new ArrayList<User>();
		User user1 = new User();
		user1.setUsername("测试用户1");
		user1.setPassword("123");
		user1.setId(1);
		userList.add(user1);

		User user2 = new User();
		user2.setUsername("测试用户2");
		user2.setPassword("123");
		user2.setId(2);
		userList.add(user2);

		User user3 = new User();
		user3.setUsername("测试用户3");
		user3.setPassword("12333");
		user3.setId(3);
		userList.add(user3);

		User user = new User(2, null, null);

		model.addObject(userList).addObject(user);
		return model;
	}

	@RequestMapping("/new")
	public User newUser() {
		User user = new User();
		user.setUsername("请填写用户名");
		user.setPassword("");
		return user;
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String add(@Valid User user, BindingResult result) {
		if (result.hasErrors()) {
			logger.error("Java Bean 没有通过验证");
			for (ObjectError or : result.getAllErrors()) {
				logger.warn("验证类型:" + or.getCode() + " \t错误消息:"
						+ or.getDefaultMessage());
			}
			return "user/new";
		}
		logger.info("后台成功添加用户:" + user);
		return "redirect:/user";
	}
}
