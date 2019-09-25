package com.vito16.shop.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 商品类型
 * 
 * @author Vito
 * @email zhouwentao16@gmail.com
 * @date 2013-7-9
 * 
 */
@Setter
@Getter
@Entity
@Table(name = "t_producttype")
public class ProductType extends AbstractEntity {

	@Column(columnDefinition="VARCHAR(32) NOT NULL COMMENT '分类名称'")
	private String name;

}
