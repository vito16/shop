/**
 * 
 */
package com.vito16.shop.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * 新闻
 * @author Vito
 * @email zhouwentao16@gmail.com
 * @date 2013-7-18
 * 
 */
@Setter
@Getter
@Entity
@Table(name = "t_news")
public class News extends AbstractEntity {

	@Column(columnDefinition="VARCHAR(64) NOT NULL COMMENT '标题'")
	private String title;

	@Column(columnDefinition="VARCHAR(512) NOT NULL COMMENT '内容'")
	private String content;

	@ManyToOne
	@JoinColumn(columnDefinition="COMMENT '管理员'")
    private Admin  inputUser;

}
