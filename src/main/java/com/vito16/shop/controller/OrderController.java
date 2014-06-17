package com.vito16.shop.controller;

import com.vito16.shop.model.*;
import com.vito16.shop.util.CartItem;
import com.vito16.shop.util.CartUtil;
import com.vito16.shop.util.UserUtil;
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

    /**
     * 订单确认
     * @param session
     * @return
     */
    @RequestMapping(value="/purchase",method = RequestMethod.GET)
    public String purchase(HttpSession session){
        if(UserUtil.getUserFromSession(session)==null){
            return "redirect:/user/login";
        }
        return "order/purchase";
    }

    /**
     * 下单
     * @param address
     * @param order
     * @param session
     * @return
     */
    @RequestMapping(value="/ordering",method = RequestMethod.GET)
    public String ordering(UserAddress address,Order order,HttpSession session){
        order.setCreateTime(new Date());
        order.setOrderNumber(new Date().toString());
        List<OrderItem> oiList = CartUtil.getOrderItemFromCart(session);
        for(OrderItem oi : oiList){
            oi.setOrder(order);
        }
        order.setOrderItems(oiList);
        order.setUser(UserUtil.getUserFromSession(session));
        order.setUserAddress(address);

        return "order/orderingSuccess";
    }
}
