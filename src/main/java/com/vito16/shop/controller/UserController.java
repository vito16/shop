package com.vito16.shop.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import com.vito16.shop.common.AppConfig;
import com.vito16.shop.common.Constants;
import com.vito16.shop.common.Page;
import com.vito16.shop.model.Order;
import com.vito16.shop.model.Remember;
import com.vito16.shop.service.OrderService;
import com.vito16.shop.service.RememberService;
import com.vito16.shop.util.CookieUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.vito16.shop.model.User;
import com.vito16.shop.model.UserAddress;
import com.vito16.shop.service.UserAddressService;
import com.vito16.shop.service.UserService;
import com.vito16.shop.util.UserUtil;

/**
 * @author Vito zhouwentao16@gmail.com
 * @version 2013-7-8
 */
@Controller
@RequestMapping("/user")
public class UserController {
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    AppConfig appConfig;

    @Autowired
    UserService userService;

    @Autowired
    OrderService orderService;

    @Autowired
    UserAddressService userAddressService;

    @Autowired
    RememberService rememberService;

    @RequestMapping(method = RequestMethod.GET)
    public String index() {
        return "user/index";
    }

    @RequestMapping(value = "/reg", method = RequestMethod.GET)
    public String reg() {
        return "user/userReg";
    }

    @RequestMapping(value = "/reg", method = RequestMethod.POST)
    public String doReg(@Valid User user, Model model, BindingResult result) {
        if (result.hasErrors()) {
            for (ObjectError or : result.getAllErrors()) {
                logger.warn("验证类型:" + or.getCode() + " \t错误消息:"
                        + or.getDefaultMessage());
            }
            model.addAttribute("error", "数据错误,请重试");
            return "user/userReg";
        }
        userService.save(user);
        logger.info("成功添加用户:" + user);
        return "redirect:/";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginForm(HttpServletRequest request, HttpSession session) {
        String uuid;
        if ((uuid = CookieUtil.getCookieValue(request, appConfig.USER_COOKIE_NAME)) != null) {
            Remember remember = rememberService.findById(uuid);
            if (remember != null && remember.getUser() != null) {
                if (userService.checkLogin(remember.getUser())) {
                    UserUtil.saveUserToSession(session, remember.getUser());
                    logger.info("用户[{}]使用cookie登录成功.", remember.getUser().getUsername());
                    return "redirect:/";
                }
            }
        }
        return "user/userLogin";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String doLogin(User user, HttpServletRequest request, HttpServletResponse response, HttpSession session) {
        if (userService.checkLogin(user)) {
            user = userService.findByUsernameAndPassword(user.getUsername(), user.getPassword());
            UserUtil.saveUserToSession(session, user);
            logger.info("是否记住登录用户：" + request.getParameter("remember"));

            if ("on".equals(request.getParameter("remember"))) {
                String uuid = UUID.randomUUID().toString();
                Remember remember = new Remember();
                remember.setId(uuid);
                remember.setUser(user);
                remember.setAddTime(new Date());
                rememberService.add(remember);
                CookieUtil.addCookie(response, appConfig.USER_COOKIE_NAME, uuid, appConfig.USER_COOKIE_AGE);
            } else {
                CookieUtil.removeCookie(response, appConfig.USER_COOKIE_NAME);
            }
            logger.info("用户[" + user.getUsername() + "]登陆成功");
            return "redirect:/";
        }
        return "redirect:/user/login?errorPwd=true";
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(HttpSession session,HttpServletResponse response) {
        UserUtil.deleteUserFromSession(session);
        CookieUtil.removeCookie(response, appConfig.USER_COOKIE_NAME);
//        rememberService.delete();
        return "redirect:/";
    }

    @RequestMapping(value = "/profile")
    public String profile(HttpSession session, Model model) {
        User user = UserUtil.getUserFromSession(session);
        if (user == null) {
            return "redirect:/user/login?timeout=true";
        }
        model.addAttribute("user", user);
        return "user/userProfile";
    }

    /**
     * 订单列表
     *
     * @param session
     * @return
     */
    @RequestMapping(value = "/order", method = RequestMethod.GET)
    public String orderList(Model model, HttpSession session, HttpServletRequest request) {
        User user = UserUtil.getUserFromSession(session);
        Page<Order> page = new Page<Order>(request);
        orderService.findOrders(page, user.getId());
        model.addAttribute("page", page);
        return "order/orderList";
    }

    /**
     * 订单查看
     *
     * @param session
     * @return
     */
    @RequestMapping(value = "/order/{id}", method = RequestMethod.GET)
    public String orderView(@PathVariable Integer id, Model model, HttpSession session, HttpServletRequest request) {
        User user = UserUtil.getUserFromSession(session);
        Order order = orderService.findById(id);
        model.addAttribute("order", order);
        return "order/orderView";
    }

    /**
     * 确认收货
     *
     * @param session
     * @return
     */
    @RequestMapping(value = "/order/confirm/{id}")
    @ResponseBody
    public String orderConfirm(@PathVariable Integer id, Model model, HttpSession session, HttpServletRequest request) {
        User user = UserUtil.getUserFromSession(session);
        Order order = orderService.findById(id);
        if(order.getUser().getId()==user.getId()){
            orderService.updateOrderStatus(id, Constants.OrderStatus.ENDED);
            return "success";
        }else{
            return "fail";
        }
    }

    /**
     * 用户地址加载
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/userAddressList/{id}")
    @ModelAttribute
    @ResponseBody
    public List<UserAddress> getUserAddressList(@PathVariable int id) {
        return userAddressService.findByUserId(id);
    }

    @RequestMapping(value = "/userAddress", method = RequestMethod.GET)
    public String userAddress(Model model, HttpSession session) {
        model.addAttribute("title", "地址管理");
        List<UserAddress> userAddressList = userAddressService.findByUserId(UserUtil.getUserFromSession(session).getId());
        model.addAttribute("userAddressList", userAddressList);
        return "user/userAddress";
    }

    @RequestMapping(value = "/userAddress/add", method = RequestMethod.GET)
    public String addUserAddress(Model model) {
        model.addAttribute("title", "添加收货地址");
        return "user/addUserAddress";
    }

    @RequestMapping(value = "/userAddress/add", method = RequestMethod.POST)
    @ResponseBody
    public String doAddUserAddress(HttpSession session, UserAddress userAddress) {
        userAddress.setUser(UserUtil.getUserFromSession(session));
        userAddressService.save(userAddress);
        logger.debug("地址信息保存成功.");
        return "success";
    }

    @RequestMapping(value = "/userAddress/update", method = RequestMethod.POST)
    @ResponseBody
    public String doUpdateUserAddress(HttpSession session, UserAddress userAddress) {
        userAddressService.updateUserAddress(userAddress);
        return "success";
    }

    @RequestMapping(value = "/userAddress/{id}")
    @ResponseBody
    public UserAddress findAddress(@PathVariable Integer id) {
        UserAddress userAddress = userAddressService.findById(id);
        return userAddress;
    }

    @RequestMapping(value = "/userAddress/delete/{id}", method = RequestMethod.GET)
    @ResponseBody
    public String delUserAddress(Model model, @PathVariable Integer id) {
        userAddressService.deleteById(id);
        logger.debug("收货地址删除成功...");
        return "success";
    }


}
