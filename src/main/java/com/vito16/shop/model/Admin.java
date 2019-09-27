/**
 * 
 */
package com.vito16.shop.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 管理员
 * @author Vito16 zhouwentao16@gmail.com
 * @date 2013-7-8
 * 
 */
@Setter
@Getter
@Entity
@Table(name = "t_admin")
public class Admin extends AbstractEntity {

	@Column(columnDefinition="VARCHAR(16) NOT NULL COMMENT '用户名'")
	private String username;//账户名

	@Column(columnDefinition="VARCHAR(32) NOT NULL COMMENT '密码'")
	private String password;//密码

}
