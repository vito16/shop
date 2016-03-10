/**
 *
 */
package com.vito16.shop.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vito16.shop.common.Constants;
import com.vito16.shop.common.Page;
import com.vito16.shop.dao.OrderDao;
import com.vito16.shop.dao.OrderItemDao;
import com.vito16.shop.model.Order;
import com.vito16.shop.model.OrderItem;
import com.vito16.shop.model.UserAddress;

/**
 * @author Vito
 * @email zhouwentao16@gmail.com
 * @date 2013-7-17
 */
@Service
@Transactional
public class OrderService {

    @Autowired
    OrderDao orderDao;
    @Autowired
    OrderItemDao orderItemDao;
    @Autowired
    UserAddressService userAddressService;

    /**
     * 新建订单
     *
     * @param order
     * @param orderItemList
     * @param userAddress
     */
    public void addOrder(Order order, List<OrderItem> orderItemList, UserAddress userAddress) {
        //更新或新增用户收获地址(根据userAddress是否包含id判断新增还是更新)
        userAddressService.save(userAddress);
        save(order);
        for (OrderItem orderItem : orderItemList) {
            orderItemDao.save(orderItem);
        }
    }

    public void save(Order order) {
        orderDao.save(order);
    }

    public Order findById(Integer id) {
        return orderDao.findOne(id);
    }

    public List<Order> findAll() {
        return orderDao.findAll();
    }

    public List<Order> findOrders(Page<Order> page, int[] pageParams) {
        page.setResult(orderDao.findAll(new PageRequest(pageParams[0] - 1, pageParams[1])).getContent());
        page.setTotalCount(orderDao.count());
        return page.getResult();
    }

    /**
     * 删除订单以及订单相关信息
     *
     * @param id 订单ID
     */
    public void deleteOrder(Integer id) {
        orderItemDao.deleteByOrderId(id);
        orderDao.delete(id);
    }

    /**
     * 修改订单状态
     *
     * @param orderID
     * @param status
     */
    public void updateOrderStatus(Integer orderID, Integer status) {
        Order order = orderDao.findOne(orderID);
        order.setStatus(status);
        //状态修改时修改相应时间数据
        if (status == Constants.OrderStatus.PAYED) {
            order.setPayTime(new Date());
        } else if (status == Constants.OrderStatus.SHIPPED) {
            order.setShipTime(new Date());
        } else if (status == Constants.OrderStatus.ENDED) {
            order.setConfirmTime(new Date());
        }
        orderDao.save(order);
    }

    /**
     * 验证订单归属人
     *
     * @param orderId
     * @param userId
     * @return
     */
    public boolean checkOwned(Integer orderId, Integer userId) {
        return orderDao.findOne(orderId).getUser().getId().equals(userId) ? true : false;
    }
}
