/**
 * 
 */
package com.vito16.shop.common;

/**
 * @author Vito
 * @email zhouwentao16@gmail.com
 * @date 2013-7-18
 * 
 */
public class Constants {
	public static final String LOGIN_USER = "login_user";
	public static final String LOGIN_ADMIN = "login_admin";
	public static final String CART = "cart";

    public static class OrderStatus {
        public static final Integer WAIT_PAY = 0;//代付款
        public static final Integer PAYED = 1;//已付款
        public static final Integer SHIPPED = 2;//已发货
        public static final Integer DELETED = 3;//已删除
        public static final Integer ENDED = 4;//已完成
    }
}
