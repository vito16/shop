package com.vito16.shop.controller;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.vito16.shop.common.Constants;
import com.vito16.shop.common.Page;
import com.vito16.shop.common.PageUtil;
import com.vito16.shop.model.Order;
import com.vito16.shop.model.OrderItem;
import com.vito16.shop.model.User;
import com.vito16.shop.model.UserAddress;
import com.vito16.shop.service.OrderService;
import com.vito16.shop.service.UserAddressService;
import com.vito16.shop.service.UserService;
import com.vito16.shop.util.CartUtil;
import com.vito16.shop.util.UserUtil;

/**
 * @author Vito zhouwentao16@gmail.com
 * @date 2013-7-8
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
     * 订单列表
     *
     * @param session
     * @return
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String list(Model model, HttpSession session, HttpServletRequest request) {
        User user = UserUtil.getUserFromSession(session);
        Page<Order> page = new Page<Order>(request);
        orderService.findOrders(page, user.getId());
        model.addAttribute("page", page);
        return "order/orderList";
    }

    /**
     * 订单管理
     *
     * @return
     */
    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String adminList(Model model, HttpServletRequest request) {
        Page<Order> page = new Page<Order>(request);
        orderService.findOrders(page);
        model.addAttribute("page", page);
        return "order/orderAdmin";
    }

    /**
     * 订单确认
     *
     * @param session
     * @return
     */
    @RequestMapping(value = "/purchase", method = RequestMethod.GET)
    public String purchase(Model model, HttpSession session) {
        User user = userService.findOne(UserUtil.getUserFromSession(session).getId());
        List<UserAddress> userAddressList = user.getAddresses();
        model.addAttribute("addressList", userAddressList);
        return "order/orderPurchase";
    }

    @RequestMapping(value = "/userAddressList/{id}")
    @ModelAttribute
    @ResponseBody
    public List<UserAddress> getUserAddressList(@PathVariable int id) {
        return userAddressService.findByUserId(id);
    }


    /**
     * 下单
     *
     * @param address
     * @param session
     * @return
     */
    @RequestMapping(value = "/ordering", method = RequestMethod.POST)
    public String ordering(UserAddress address, HttpSession session) {
        Order order = new Order();
        order.setCreateTime(new Date());
        address.setUser(UserUtil.getUserFromSession(session));
        order.setOrderNumber(new DateTime().toString("yyyyMMddHHmmSS"));
        order.setStatus(Constants.OrderStatus.WAIT_PAY);
        List<OrderItem> oiList = CartUtil.getOrderItemFromCart(session);
        BigDecimal totalSum = new BigDecimal("0");
        for (OrderItem oi : oiList) {
            totalSum = totalSum.add(new BigDecimal(oi.getProduct().getPoint() * oi.getQuantity()));
            oi.setOrder(order);
        }
        order.setTotalPrice(totalSum.doubleValue());
        order.setFinalPrice(totalSum.doubleValue());
        order.setOrderItems(oiList);
        order.setUser(UserUtil.getUserFromSession(session));
        //地址保存
        order.setAddress(address.getAddress());
        order.setZipcode(address.getZipcode());
        order.setConsignee(address.getConsignee());
        order.setPhone(address.getPhone());
        orderService.addOrder(order, oiList, address);
        CartUtil.cleanCart(session);
        return "order/orderingSuccess";
    }

    @RequestMapping(value = "/view/{id}", method = RequestMethod.GET)
    public String viewOrder(@PathVariable Integer id, Model model) {
        model.addAttribute("order", orderService.findById(id));
        return "order/orderView";
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    @ResponseBody
    public String delete(@PathVariable Integer id) {
        orderService.deleteOrder(id);
        return "success";
    }

    @RequestMapping(value = "/pay/{id}", method = RequestMethod.GET)
    @ResponseBody
    public String pay(@PathVariable(value = "id") Integer orderId, HttpSession session) {
        //验证订单是否归当前人员所有
        if (orderService.checkOwned(orderId, UserUtil.getUserFromSession(session).getId())) {
            orderService.pay(orderId);
            return "success";
        }
        return "error";
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

    /**
     * 取消订单
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
     * 订单收货确认
     *
     * @param orderId
     * @return
     */
    @RequestMapping(value = "/confirm/{id}", method = RequestMethod.GET)
    @ResponseBody
    public String confirm(@PathVariable(value = "id") Integer orderId) {
        orderService.updateOrderStatus(orderId, Constants.OrderStatus.ENDED);
        return "success";
    }
}
