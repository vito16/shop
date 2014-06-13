package com.vito16.shop.controller;

import com.vito16.shop.common.Constants;
import com.vito16.shop.model.Admin;
import com.vito16.shop.service.AdminService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

/**
 * @author Vito16 zhouwentao16@gmail.com
 * @date 2013-7-8
 * 
 */
@Controller
@RequestMapping("/admin")
public class AdminController {
	private static final Logger logger = LoggerFactory.getLogger(AdminController.class);
    @Autowired
    AdminService adminService;

	@RequestMapping(method = RequestMethod.GET)
	public String index() {
		return "admin/index";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public Admin loginForm() {
		Admin admin = new Admin();
		return admin;
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String doLogin(Admin admin, HttpSession session) {
		if(adminService.checkLogin(admin)){
			session.setAttribute(Constants.LOGIN_ADMIN, admin);
			logger.debug("管理员["+admin.getUsername()+"]登陆成功");
			return "redirect:/admin/";
		}
		return "redirect:/admin/login?error=true";
	}
	@RequestMapping(value = "/reg", method = RequestMethod.GET)
	public Admin regForm(){
		Admin admin = new Admin();
		admin.setUsername("请输入名称");
		return admin;
	}
	@RequestMapping(value = "/reg", method = RequestMethod.POST)
	public Admin regForm(Admin admin,HttpSession session){
		adminService.save(admin);
		return admin;
	}
}
