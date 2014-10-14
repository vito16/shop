小小商店
=====================

简单的一个在线商店，基于Spring 和 Bootstrap 项目来完成,使用到了Spring MVC和一些常用第三方jar包  
ORM层使用的Spring data jpa来完成，大大简化常规的CRUD操作，并且方便基础层代码扩展.  
数据库连接池使用了Alibaba的Druid，性能比较不错.
后期慢慢增加一些重要点的功能吧。算是一个功能集合的演示项目吧。

## 安装
项目使用Maven管理依赖关系  
1. 其中一个依赖需要到[vito-util](https://github.com/vito16/util)拉取源码  
    
    git clone git@github.com:vito16/util.git
    cd util
    mvn install
2. 下载vito-shop  
     
	git clone git@github.com:vito16/shop.git
	cd shop
	mvn idea:idea  (使用Intellij IDEA的情况，如果是Eclipse，那就mvn eclipse:eclipse)
    
3. 运行项目

    jetty:run
    
4. 项目访问地址

	http://localhost:9999/

有什么问题给我发邮件吧....

