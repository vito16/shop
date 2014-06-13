package com.vito16.mvc1.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.vito16.mvc1.model.News;
import com.vito16.mvc1.model.Order;
import com.vito16.mvc1.model.Product;
import com.vito16.mvc1.model.ProductType;

/**
 * 
 * @author Vito
 * @email zhouwentao16@gmail.com
 * @date 2013-7-9
 * 
 */
@Repository
public interface NewsDao extends JpaRepository<News, Integer> {
}
