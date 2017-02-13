package com.vito16.shop.common;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


/**
 * 全局配置类
 * @author Vito16 zhouwentao16@gmail.com
 * @version 2013-11-02
 */
@Component
public class AppConfig {

	/**
	 * 属性文件加载对象
	 */
	private static PropertiesLoader propertiesLoader;

	@Value("${user.cookie.name}")
	public String USER_COOKIE_NAME;

	@Value("${user.cookie.age}")
	public int USER_COOKIE_AGE;


	/**
	 * 获取配置
	 */
	public static String getConfig(String key) {
		if (propertiesLoader == null){
			propertiesLoader = new PropertiesLoader("application.properties");
		}
		return propertiesLoader.getProperty(key);
	}
	public static String getAdminPath() {
		return getConfig("adminPath");
	}
	public static String getFrontPath() {
		return getConfig("frontPath");
	}
	public static String getUrlSuffix() {
		return getConfig("urlSuffix");
	}
}
