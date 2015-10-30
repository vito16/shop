package com.vito16.shop.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.vito16.shop.common.Constants;
import com.vito16.shop.model.OrderItem;
import com.vito16.shop.model.Product;

/**
 * 购物车工具类
 *
 * @author Vito
 * @version 2014/6/16
 */
public class CartUtil {
    public static final String CART = Constants.CART;
    private static Logger logger = LoggerFactory.getLogger(CartUtil.class);

    /**
     * 添加商品到购物车中
     *
     * @param session
     * @param product
     * @param total
     */
    public static synchronized void saveProductToCart(HttpSession session, Product product, Integer total) {
        Map<Integer, CartItem> cartItemMap = (HashMap<Integer, CartItem>) session.getAttribute(CART);
        CartItem ci = new CartItem(product, total);
        if (cartItemMap == null) {
            cartItemMap = new HashMap < Integer, CartItem > ();
        }
        //判断当前购物车中是否包含此商品
        if (cartItemMap.containsKey(product.getId())) {
            CartItem currentCi = cartItemMap.get(product.getId());
            currentCi.setTotal(currentCi.getTotal() + total);
            cartItemMap.put(product.getId(), currentCi);
        } else {
            cartItemMap.put(product.getId(), ci);
        }
        session.setAttribute(CART, cartItemMap);
    }

    /**
     * 删除购物车中的商品
     *
     * @param session
     * @param productId
     */
    public static synchronized void deleteProductFromCart(HttpSession session, Integer productId) {
        Map<Integer, CartItem> cartItemMap = (HashMap<Integer, CartItem>) session.getAttribute(CART);
        if(cartItemMap!=null) {
            cartItemMap.remove(productId);
        }
        session.setAttribute(CART, cartItemMap);
    }

    /**
     * 清空购物车
     *
     * @param session
     */
    public static synchronized void cleanCart(HttpSession session) {
        Map<Integer, CartItem> cartItemMap = (HashMap<Integer, CartItem>) session.getAttribute(CART);
        if(cartItemMap!=null){
            cartItemMap.clear();
        }
        logger.debug("清空购物车 ： cart :"+cartItemMap);
        session.setAttribute(CART, cartItemMap);
    }

    public static List<OrderItem> getOrderItemFromCart(HttpSession session){
        Map<Integer, CartItem> cartItemMap = (HashMap<Integer, CartItem>) session.getAttribute(CART);
        logger.debug("获取商品信息 ： cart :"+cartItemMap);
        if(cartItemMap==null) cartItemMap = new HashMap<Integer, CartItem>();
        List<OrderItem> oiList = new ArrayList<OrderItem>();
        for(CartItem ci:cartItemMap.values()){
            OrderItem oi = new OrderItem();
            oi.setProduct(ci.getProduct());
            oi.setQuantity(ci.getTotal());
            oiList
                    .add(oi);
        }
        return oiList;
    }
}
