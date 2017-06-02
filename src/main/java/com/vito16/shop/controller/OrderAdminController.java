package com.vito16.shop.controller;

import com.vito16.shop.common.Constants;
import com.vito16.shop.common.Page;
import com.vito16.shop.model.Order;
import com.vito16.shop.model.OrderItem;
import com.vito16.shop.model.User;
import com.vito16.shop.model.UserAddress;
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
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @author Vito zhouwentao16@gmail.com
 * @date 2013-7-8
 */
@Controller
@RequestMapping("/admin/order")
public class OrderAdminController {
    private static final Logger logger = LoggerFactory.getLogger(OrderAdminController.class);

    @Autowired
    UserService userService;
    @Autowired
    OrderService orderService;
    @Autowired
    UserAddressService userAddressService;

    /**
     * 订单管理
     *
     * @return
     */
    @RequestMapping(method = RequestMethod.GET)
    public String adminList(Model model, HttpServletRequest request) {
        Page<Order> page = new Page<Order>(request);
        orderService.findOrders(page);
        model.addAttribute("page", page);
        return "admin/order/orderList";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String viewOrder(@PathVariable Integer id, Model model) {
        model.addAttribute("order", orderService.findById(id));
        return "admin/order/orderDetail";
    }

    /**
     * 订单删除
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    @ResponseBody
    public String delete(@PathVariable Integer id) {
        orderService.deleteOrder(id);
        return "success";
    }

    /**
     * 订单取消
     *
     * @param orderId
     * @return
     */
    @RequestMapping(value = "/cancel/{id}", method = RequestMethod.GET)
    @ResponseBody
    public String cancel(@PathVariable(value = "id") Integer orderId) {
        orderService.updateOrderStatus(orderId, Constants.OrderStatus.DELETED);
        return "success";
    }

    /**
     * 订单发货
     *
     * @param orderId
     * @return
     */
    @RequestMapping(value = "/ship/{id}", method = RequestMethod.GET)
    @ResponseBody
    public String ship(@PathVariable(value = "id") Integer orderId, HttpSession session) {
        orderService.updateOrderStatus(orderId, Constants.OrderStatus.SHIPPED);
        return "success";
    }


}
