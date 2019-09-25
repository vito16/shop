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
 * 公告
 *
 * @author Vito
 * @email zhouwentao16@gmail.com
 * @date 2013-7-18
 */
@Entity
@Setter
@Getter
@Table(name = "t_announcement")
public class Announcement extends AbstractEntity {

    @Column(columnDefinition="VARCHAR(512) NOT NULL COMMENT '公告内容'")
    private String content;

    @ManyToOne
    @JoinColumn(columnDefinition="BIGINT(20) NOT NULL COMMENT '创建管理员ID'")
    private Admin createAdmin;

}
