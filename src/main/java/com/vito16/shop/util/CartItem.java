package com.vito16.shop.util;

import com.vito16.shop.model.Product;

/**
 * 购物车关联项
 * @author Vito
 * @version 2014/6/16
 */
public class CartItem {
    private Product product;//商品
    private Integer total;//数量

    public CartItem(Product product, Integer total) {
        this.product = product;
        this.total = total;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }
}
