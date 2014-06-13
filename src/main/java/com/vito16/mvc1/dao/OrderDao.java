package com.vito16.mvc1.dao;

import javax.persistence.LockModeType;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vito16.mvc1.model.Order;

import java.awt.print.Pageable;

/**
 * 
 * @author Vito
 * @email zhouwentao16@gmail.com
 * @date 2013-7-9
 * 
 */
@Repository
public interface OrderDao extends JpaRepository<Order, Integer> {
}
