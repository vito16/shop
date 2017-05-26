/**
 * 
 */
package com.vito16.shop.service;

import java.util.List;

import com.vito16.shop.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vito16.shop.common.Page;
import com.vito16.shop.repository.NewsRepository;
import com.vito16.shop.model.News;

/**
 * 新闻模块Service
 * @author Vito
 * @email zhouwentao16@gmail.com
 * @date 2013-7-17
 * 
 */
@Service
@Transactional
public class NewsService extends BaseService {

	@Autowired
    NewsRepository newsDao;

    public void addNews(News news){
        newsDao.save(news);
    }

    public void delNews(Integer newsId){
        newsDao.delete(newsId);
    }

    public List<News> findNews(Page<News> page) {
            page.setResult(newsDao.findAll(page.getPageable()).getContent());
            page.setTotalCount(newsDao.count());
            return page.getResult();
    }

}
