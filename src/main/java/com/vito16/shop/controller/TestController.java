/*
 * www.yiji.com Inc.
 * Copyright (c) 2015 All Rights Reserved.
 */

/*
 * 修订记录：
 * muyu@yiji.com 2015-11-02 16:37 创建
 */
package com.vito16.shop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author 木鱼 muyu@yiji.com
 * @version 2015/11/2
 */
@Controller
@RequestMapping(value="/test")
public class TestController  {

    @ResponseBody
    @RequestMapping(value="hello",method = RequestMethod.GET)
    public String index2() {
        return "userhellondex";
    }

}
