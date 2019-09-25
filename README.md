购物系统
=====================
[![Build Status](https://travis-ci.org/vito16/shop.svg?branch=master)](https://travis-ci.org/vito16/shop) [![Coverage Status](https://coveralls.io/repos/github/vito16/shop/badge.svg?branch=master)](https://coveralls.io/github/vito16/shop?branch=master)  

在线商城项目，持续完善中...

![功能导图](img/module.png)

## 前提条件  
- redis(Win上可以找3.0的安装包或者Docker方式,Linux和Mac就不多说了)
- Lombok插件(IDEA的话自己安装，Eclipse没试过)
- MySQL数据库(>=5.7)

## 启动服务

    com.vito16.shop.Application.main()
    
主页：[http://localhost:8081/](localhost:8081/)  
后台：[http://localhost:8081/admin/login](localhost:8081/admin/login)  

## 配置修改
可以在application.properties中修改相关配置（http服务端口、数据库配置...）

- 访问端口：server.port
- 数据库相关配置：jdbc.***
- 初始化数据脚本在`/src/main/resources/sql/`下


