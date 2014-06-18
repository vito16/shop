/**
 * 
 */
package com.vito16.shop.service;

import com.vito16.shop.common.Page;
import com.vito16.shop.dao.OrderDao;
import com.vito16.shop.dao.OrderItemDao;
import com.vito16.shop.dao.ProductDao;
import com.vito16.shop.dao.ProductTypeDao;
import com.vito16.shop.model.Order;
import com.vito16.shop.model.OrderItem;
import com.vito16.shop.model.Product;
import com.vito16.shop.model.ProductType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Vito
 * @email zhouwentao16@gmail.com
 * @date 2013-7-17
 * 
 */
@Service
public class OrderService {

	@Autowired
    OrderDao orderDao;
    @Autowired
    OrderItemDao orderItemDao;

    public void addOrder(Order order,List<OrderItem> orderItemList){
        save(order);
        for(OrderItem orderItem:orderItemList){
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
        page.setResult(orderDao.findAll(new PageRequest(pageParams[0]-1,pageParams[1])).getContent());
        page.setTotalCount(orderDao.count());
        return page.getResult();
    }
}
