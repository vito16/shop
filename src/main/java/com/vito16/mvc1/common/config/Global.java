package com.vito16.mvc1.common.config;

import com.vito16.mvc1.common.PropertiesLoader;


/**
 * 全局配置类
 * @author Vito16 zhouwentao16@gmail.com
 * @version 2013-11-02
 */
public class Global {
	/**
	 * 属性文件加载对象
	 */
	private static PropertiesLoader propertiesLoader;
	
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
