package com.vito16.shop.controller;

import com.vito16.shop.common.Page;
import com.vito16.shop.model.News;
import com.vito16.shop.service.NewsService;
import com.vito16.shop.util.AdminUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;

/**
 * @author Vito zhouwentao16@gmail.com
 * @date 2013-7-8
 */
@Controller
@RequestMapping("/news/admin")
public class NewsAdminController {
    private static final Logger logger = LoggerFactory.getLogger(NewsAdminController.class);
    @Autowired
    NewsService newsService;

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String admin(Model model,HttpServletRequest request) {
        Page<News> page = new Page<News>(request);
        newsService.findNews(page);
        model.addAttribute("page",page);
        return "news/newsAdmin";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public String doAdd(News news,HttpSession session) {
        news.setInputUser(AdminUtil.getAdminFromSession(session));
        news.setCreateTime(new Date());
        newsService.addNews(news);
        return "success";
    }

}
