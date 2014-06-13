package com.vito16.shop.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.vito16.shop.model.Product;

/**
 * 
 * @author Vito
 * @email zhouwentao16@gmail.com
 * @date 2013-7-9
 * 
 */
@Repository
public interface ProductDao extends JpaRepository<Product, Integer> {
	@Query("FROM Product p ORDER BY p.createTime")
	public List<Product> findNewProducts();

	@Query("FROM Product p")
	public List<Product> findPopProducts();
}
