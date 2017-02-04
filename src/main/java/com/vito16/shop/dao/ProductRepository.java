package com.vito16.shop.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * @author Vito
 * @email zhouwentao16@gmail.com
 * @date 2013-7-9
 */
@Repository
public interface ProductRepository extends JpaRepository<ProductRepository, Integer> {

    List<ProductRepository> findByOrderByCreateTimeDesc();

    List<ProductRepository> findByOrderByCreateTimeAsc();

    @Query("FROM Product p")
    List<ProductRepository> findPopProducts();

}
