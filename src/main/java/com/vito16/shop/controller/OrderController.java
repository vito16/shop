package com.vito16.shop.controller;

import com.vito16.shop.common.Constants;
import com.vito16.shop.common.Page;
import com.vito16.shop.common.PageUtil;
import com.vito16.shop.model.*;
import com.vito16.shop.service.OrderService;
import com.vito16.shop.service.UserAddressService;
import com.vito16.shop.service.UserService;
import com.vito16.shop.util.CartUtil;
import com.vito16.shop.util.UserUtil;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;
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

    @Autowired
    UserService userService;
    @Autowired
    OrderService orderService;
    @Autowired
    UserAddressService userAddressService;
    /**
     * 订单确认
     * @param session
     * @return
     */
    @RequestMapping(value="/purchase",method = RequestMethod.GET)
    public String purchase(Model model,HttpSession session){
        if(UserUtil.getUserFromSession(session)==null){
            return "redirect:/user/login";
        }
        User user = userService.findOne(UserUtil.getUserFromSession(session).getId());
        List<UserAddress> userAddressList = user.getAddresses();
        model.addAttribute("addressList",userAddressList);
        return "order/orderPurchase";
    }

    /**
     * 订单列表
     * @param session
     * @return
     */
    @RequestMapping(value="/",method = RequestMethod.GET)
    public String list(Model model,HttpSession session,HttpServletRequest request){
        if(UserUtil.getUserFromSession(session)==null){
            return "redirect:/user/login";
        }
        Page<Order> page = new Page<Order>(PageUtil.PAGE_SIZE);
        int[] pageParams = PageUtil.init(page, request);
        orderService.findOrders(page, pageParams);
        model.addAttribute("page", page);
        return "order/orderList";
    }

    /**
     * 下单
     * @param address
     * @param session
     * @return
     */
    @RequestMapping(value="/ordering",method = RequestMethod.POST)
    public String ordering(UserAddress address,HttpSession session){
        Order order = new Order();
        order.setCreateTime(new Date());
        address.setUser(UserUtil.getUserFromSession(session));
        order.setOrderNumber(new DateTime().toString("yyyyMMddHHmmSS"));
        order.setStatus(Constants.OrderStatus.WAIT_PAY);
        List<OrderItem> oiList = CartUtil.getOrderItemFromCart(session);
        for(OrderItem oi : oiList){
            oi.setOrder(order);
        }
        order.setOrderItems(oiList);
        order.setUser(UserUtil.getUserFromSession(session));
        order.setUserAddress(address);
        orderService.addOrder(order, oiList,address);
        return "order/orderingSuccess";
    }

    @RequestMapping(value="/view/{id}",method = RequestMethod.GET)
    public String viewOrder(@PathVariable Integer id,Model model){
        model.addAttribute("order",orderService.findById(id));
        return "order/orderView";
    }
}
