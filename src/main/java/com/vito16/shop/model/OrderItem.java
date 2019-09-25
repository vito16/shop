/**
 * 
 */
package com.vito16.shop.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 订单关联明细
 * @author Vito16 zhouwentao16@gmail.com
 * @date 2013-7-8
 * 
 */
@Setter
@Getter
@Entity
@Table(name = "t_orderitem")
public class OrderItem extends AbstractEntity {

	@OneToOne
	private Product product;

	@ManyToOne
	@JoinColumn(name="order_id")
	private Order order;

	@Column(columnDefinition="INT(11) NOT NULL COMMENT '订单数量'")
	private Integer quantity;

}
