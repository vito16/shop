package com.vito16.shop.controller;

import com.vito16.shop.model.User;
import com.vito16.shop.model.UserAddress;
import com.vito16.shop.service.UserAddressService;
import com.vito16.shop.service.UserService;
import com.vito16.shop.util.UserUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Vito zhouwentao16@gmail.com
 * @version 2013-7-8
 */
@Controller
@RequestMapping("/user")
public class UserController {
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    UserService userService;

    @Autowired
    UserAddressService userAddressService;

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
        if (userService.checkLogin(user)) {
            user = userService.findByUsernameAndPassword(user.getUsername(), user.getPassword());
            UserUtil.saveUserToSession(session, user);
            logger.debug("用户[" + user.getUsername() + "]登陆成功");
            return "redirect:/";
        }
        return "redirect:/user/login?errorPwd=true";
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(HttpSession session) {
        UserUtil.deleteUserFromSession(session);
        return "redirect:/";
    }

    @RequestMapping(value = "/profile")
    public String profile(HttpSession session,Model model) {
        User user = UserUtil.getUserFromSession(session);
        if (user == null) {
            return "redirect:/user/login?timeout=true";
        }
        model.addAttribute("user",user);
        return "user/userProfile";
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

    @RequestMapping(value = "/reg", method = RequestMethod.GET)
    public String reg() {
        return "user/userReg";
    }

    @RequestMapping(value = "/reg", method = RequestMethod.POST)
    public String doReg(@Valid User user, Model model, BindingResult result) {
        if (result.hasErrors()) {
            logger.error("Java Bean 没有通过验证");
            for (ObjectError or : result.getAllErrors()) {
                logger.warn("验证类型:" + or.getCode() + " \t错误消息:"
                        + or.getDefaultMessage());
            }
            model.addAttribute("error", "数据信息错误");
            return "user/userReg";
        }
        userService.save(user);
        logger.info("");
        logger.info("后台成功添加用户:" + user);
        return "redirect:/";
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
    public String doUpdeteUserAddress(HttpSession session,UserAddress userAddress){
        userAddressService.updateUserAddress(userAddress);
        return "success";
    }

    @RequestMapping(value = "/userAddress/{id}", method = RequestMethod.POST)
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
