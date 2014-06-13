package com.vito16.shop.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vito16.shop.model.ProductType;

/**
 * 
 * @author Vito
 * @email zhouwentao16@gmail.com
 * @date 2013-7-9
 * 
 */
@Repository
public interface ProductTypeDao extends JpaRepository<ProductType, Integer> {
}
