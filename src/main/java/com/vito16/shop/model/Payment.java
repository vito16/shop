/**
 * 
 */
package com.vito16.shop.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 支付方式
 * 
 * @author Vito
 * @email zhouwentao16@gmail.com
 * @date 2013-7-18
 * 
 */
@Setter
@Getter
@Entity
@Table(name = "t_payment")
public class Payment extends AbstractEntity {

	@Column(columnDefinition="VARCHAR(20) NOT NULL COMMENT '付款人名字'")
	private String name;

}
