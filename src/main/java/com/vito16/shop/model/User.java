/**
 * 
 */
package com.vito16.shop.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

/**
 * @author Vito16 zhouwentao16@gmail.com
 * @date 2013-7-8
 * 
 */
@Setter
@Getter
@Entity
@NoArgsConstructor
@Table(name = "t_user")
public class User extends AbstractEntity {

	@Column(columnDefinition="VARCHAR(32) DEFAULT NULL COMMENT '账号(暂时没用)'")
	private String account;

	@Column(columnDefinition="VARCHAR(32) NOT NULL COMMENT '用户名'")
	private String username;

	@Column(columnDefinition="DOUBLE DEFAULT 0 NOT NULL COMMENT '账户余额'")
	private Long balance;

	@Column(columnDefinition="DOUBLE DEFAULT 0 NOT NULL COMMENT '积分值'")
	private Long point;

	@Column(columnDefinition="VARCHAR(32) DEFAULT NULL COMMENT '手机号码'")
	private String phone;

	@Column(columnDefinition="VARCHAR(32) DEFAULT NULL COMMENT '座机电话'")
	private String telPhone;

	@Column(columnDefinition="VARCHAR(64) DEFAULT NULL COMMENT '地址'")
	private String address;

	@Column(columnDefinition="VARCHAR(16) DEFAULT NULL COMMENT '邮编'")
	private String zipCode;

	@Column(columnDefinition="VARCHAR(32) DEFAULT NULL COMMENT '备注'")
	private String remark;

	@Column(columnDefinition="VARCHAR(64) NOT NULL COMMENT '密码'")
	private String password;

	/**
	 * 收货地址
	 */
	@OneToMany(mappedBy="user")
	private List<UserAddress> addresses;

	/**
	 * 订单
	 */
	@OneToMany(mappedBy = "user")
	private List<Order> orders;

	/**
	 * 密码加密盐
	 */
	@Column(columnDefinition="VARCHAR(64) DEFAULT NULL COMMENT '盐'")
    private String slat;

	/**
	 * @param id
	 * @param username
	 * @param password
	 */
	public User(Integer id, String username, String password) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
	}

}
