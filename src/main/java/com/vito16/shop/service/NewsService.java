/**
 * 
 */
package com.vito16.shop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vito16.shop.common.Page;
import com.vito16.shop.dao.NewsRepository;
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

    public List<News> findNews(Page<News> page, int[] pageParams) {
        /*return doIt(page,List.class,new ProcessInvoker(){

            @Override
            void process() {

            }
        });
        page.setResult(newsDao.findAll(new PageRequest(pageParams[0] - 1, pageParams[1])).getContent());
        page.setTotalCount(newsDao.count());
        return page.getResult();*/
        return null;
    }

}
