package com.vito16.shop.controller;

import com.vito16.shop.common.Page;
import com.vito16.shop.common.PageUtil;
import com.vito16.shop.model.News;
import com.vito16.shop.model.Product;
import com.vito16.shop.service.NewsService;
import com.vito16.shop.service.ProductService;
import com.vito16.shop.util.AdminUtil;
import com.vito16.shop.util.CartUtil;
import com.vito16.shop.util.UserUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author Vito16 zhouwentao16@gmail.com
 * @date 2013-7-8
 */
@Controller
@RequestMapping("/news")
public class NewsController {
    private static final Logger logger = LoggerFactory.getLogger(NewsController.class);
    @Autowired
    NewsService newsService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(Model model,HttpServletRequest request) {
        Page<News> page = new Page<News>(PageUtil.PAGE_SIZE);
        int[] pageParams = PageUtil.init(page, request);
        newsService.findNews(page, pageParams);
        model.addAttribute("page",page);
        return "news/newsList";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public String doAdd(News news,HttpSession session) {
        news.setInputUser(AdminUtil.getAdminFromSession(session));
        newsService.addNews(news);
        return "success";
    }

}
