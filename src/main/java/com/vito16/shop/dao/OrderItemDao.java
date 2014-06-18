package com.vito16.shop.dao;

import com.vito16.shop.model.Order;
import com.vito16.shop.model.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * 
 * @author Vito
 * @email zhouwentao16@gmail.com
 * @date 2013-7-9
 * 
 */
@Repository
public interface OrderItemDao extends JpaRepository<OrderItem, Integer> {
}
