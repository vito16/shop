package com.vito16.shop.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author Vito
 * @email zhouwentao16@gmail.com
 * @date 2013-7-9
 */
@Setter
@Getter
@Entity
@DynamicUpdate
@Table(name = "t_product")
public class Product extends AbstractEntity {

    @Column(columnDefinition="VARCHAR(64) NOT NULL COMMENT '商品名称'")
    private String title;

    @Column(columnDefinition="DOUBLE NOT NULL COMMENT '商品价格'")
    private Integer point;

    @ManyToOne
    @JoinColumn
    private Picture masterPic;//主图

    @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<Picture> slavePic;//关联图

    @Lob
    @Column(columnDefinition = "TEXT COMMENT '商品描述'")
    private String note;

    @Column(columnDefinition="VARCHAR(32) NOT NULL COMMENT '商品编码'")
    private String code;

    @Column(columnDefinition="VARCHAR(32) NOT NULL COMMENT '商品型号'")
    private String model;

    @Column(columnDefinition="INT(11) NOT NULL COMMENT '库存数量'")
    private Long stock;

    @ManyToOne
    @JoinColumn
    private Admin inputUser;

}
