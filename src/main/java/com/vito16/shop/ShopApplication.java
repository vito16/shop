package com.vito16.shop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;

/**
 * @author 木鱼 muyu@yiji.com
 * @version 2016/03/14
 */
@SpringBootApplication
@EnableJpaRepositories
@EnableJpaAuditing
@EnableTransactionManagement
public class ShopApplication  {

	public static void main(String[] args) {
		SpringApplication.run(ShopApplication.class,args);
	}

}
