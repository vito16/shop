/**
 *
 */
package com.vito16.shop.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 订单
 *
 * @author Vito16 zhouwentao16@gmail.com
 * @date 2013-7-8
 */
@Setter
@Getter
@Entity
@Table(name = "t_order")
public class Order extends AbstractEntity {

    @Column(columnDefinition="VARCHAR(64) NOT NULL COMMENT '订单编号'")
    private String orderNumber;

    @ManyToOne
    @JoinColumn(name = "user_id",columnDefinition="BIGINT(20) NOT NULL COMMENT '关联客户'")
    private User user;

    @Column(columnDefinition="VARCHAR(512) NOT NULL COMMENT '收货地址'")
    private String address;

    @Column(columnDefinition="VARCHAR(16) NOT NULL COMMENT '收货电话'")
    private String phone;

    @Column(columnDefinition="VARCHAR(8) NOT NULL COMMENT '收货邮编'")
    private String zipcode;

    @Column(columnDefinition="VARCHAR(16) NOT NULL COMMENT '收货人'")
    private String consignee;

    /**
     * 关联商品
     */
    @OneToMany(mappedBy = "order")
    private List<OrderItem> orderItems;

    @Column(columnDefinition="DATETIME DEFAULT COMMENT '付款时间'")
    private Date payTime;//付款时间

    @Column(columnDefinition="DATETIME DEFAULT COMMENT '发货时间'")
    private Date shipTime;//发货时间

    @Column(columnDefinition="DATETIME DEFAULT COMMENT '确认收货时间'")
    private Date confirmTime;//确认收货时间

    @Column(columnDefinition="INT(11) NOT NULL COMMENT '状态'")
    private Integer status;//状态

    @Column(columnDefinition="DOUBLE NOT NULL COMMENT '实际成交价'")
    private Double finalPrice;//实际成交价

    @Column(columnDefinition="DOUBLE NOT NULL COMMENT '总价'")
    private Double totalPrice;//总价

}
