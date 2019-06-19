/**
 * 
 */
package com.vito16.shop.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.io.Serializable;
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
public class User implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 数据序号
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	/**
	 * 账号
	 */
	private String account;

	/**
	 * 用户名
	 */
	private String username;

	/**
	 * 账户余额
	 */
	private Long balance;

	/**
	 * 积分值
	 */
	private Long point;

	/**
	 * 手机号码
	 */
	private String phone;

	/**
	 * 座机电话
	 */
	private String telPhone;

	/**
	 * 地址
	 */
	private String address;

	/**
	 * 邮编
	 */
	private String zipCode;

	/**
	 * 备注
	 */
	private String remark;

	/**
	 * 密码信息(加密)
	 */
	private String password;

	/**
	 * 收货地址
	 */
	@OneToMany(mappedBy="user")
	private List<UserAddress> addresses; // 关联收货地址

	/**
	 * 订单
	 */
	@OneToMany(mappedBy = "user")
	private List<Order> orders;// 订单

	/**
	 * 密码加密盐
	 */
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

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password="
				+ password + "]";
	}

}
