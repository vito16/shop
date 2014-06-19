package com.vito16.shop.controller;

import com.vito16.shop.model.User;
import com.vito16.shop.service.UserService;
import com.vito16.shop.util.UserUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ExceptionHandler;
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
@RequestMapping("/user")
public class UserController {
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);

	@Autowired
	UserService userService;
	
	@RequestMapping(method = RequestMethod.GET)
	public String index() {
		return "user/index";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginForm() {
        return "user/userLogin";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String doLogin(User user, HttpSession session) {
		if(userService.checkLogin(user)){
			user = userService.findByUsernameAndPassword(user.getUsername(),user.getPassword());
            UserUtil.saveUserToSession(session, user);
			logger.debug("用户["+user.getUsername()+"]登陆成功");
			return "redirect:/";
		}
		return "redirect:/user/login?errorPwd=true";
	}

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout( HttpSession session) {
        UserUtil.deleteUserFromSession(session);
        return "redirect:/";
    }

	@RequestMapping(value = "/profile")
	public ModelAndView profile(ModelAndView vo,HttpSession session){
		User user = UserUtil.getUserFromSession(session);
		if(user==null){
			vo.setViewName("redirect:/user/login?timeout=true");
			return vo;
		}
		user = userService.findOne(user.getId());
		vo.addObject(user);
		vo.setViewName("user/userinfo");
		return vo;
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

	@RequestMapping(value="/reg", method = RequestMethod.GET)
	public String reg() {
        return "user/userReg";
	}

	@RequestMapping(value = "/reg", method = RequestMethod.POST)
	public String add(@Valid User user,Model model, BindingResult result) {
        System.out.println(1);
		if (result.hasErrors()) {
            System.out.println(2);
			logger.error("Java Bean 没有通过验证");
			for (ObjectError or : result.getAllErrors()) {
				logger.warn("验证类型:" + or.getCode() + " \t错误消息:"
						+ or.getDefaultMessage());
			}
			model.addAttribute("error", "数据信息错误");
			return "user/userReg";
		}
		userService.save(user);
		logger.info("后台成功添加用户:" + user);
		return "redirect:/";
	}
}
