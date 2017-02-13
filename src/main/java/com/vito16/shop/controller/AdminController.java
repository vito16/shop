package com.vito16.shop.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.vito16.shop.common.Page;
import com.vito16.shop.common.PageUtil;
import com.vito16.shop.model.Order;
import com.vito16.shop.service.OrderService;
import com.vito16.shop.util.UserUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.vito16.shop.model.Admin;
import com.vito16.shop.service.AdminService;
import com.vito16.shop.util.AdminUtil;

/**
 * @author Vito zhouwentao16@gmail.com
 * @date 2013-7-8
 */
@Controller
@RequestMapping("/admin")
public class AdminController {
    private static final Logger logger = LoggerFactory.getLogger(AdminController.class);

    @Autowired
    AdminService adminService;

    @Autowired
    OrderService orderService;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginForm() {
        return "admin/adminLogin";
    }

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    @ResponseBody
    public String test() {
        return "admin";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String doLogin(Admin admin, HttpSession session) {
        if (adminService.checkLogin(admin)) {
            AdminUtil.saveAdminToSession(session, adminService.findByUsernameAndPassword(admin.getUsername(), admin.getPassword()));
            logger.debug("管理员[{}]登陆成功",admin.getUsername());
            return "redirect:/";
        }
        return "redirect:/admin/login?errorPwd=true";
    }

    @RequestMapping(value = "/order", method = RequestMethod.GET)
    public String order(Model model,HttpServletRequest request){
        Page<Order> page = new Page<Order>(request);
        orderService.findOrders(page);
        model.addAttribute("page", page);
        return "admin/order/orderList";
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String doLogout(HttpSession session) {
        AdminUtil.deleteAdminFromSession(session);
        return "redirect:/";
    }

    @RequestMapping(value = "/reg", method = RequestMethod.GET)
    public String regForm() {
        return "admin/adminReg";
    }

    @RequestMapping(value = "/reg", method = RequestMethod.POST)
    public String regForm(Admin admin, HttpSession session) {
        adminService.save(admin);
        return "redirect:/";
    }
}
