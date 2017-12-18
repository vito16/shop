package com.vito16.shop.repository;

import com.vito16.shop.model.News;
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
public interface NewsRepository extends JpaRepository<News, Integer> {
}
