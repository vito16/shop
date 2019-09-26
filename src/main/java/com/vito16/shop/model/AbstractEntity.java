package com.vito16.shop.model;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@MappedSuperclass
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class AbstractEntity implements Serializable {

    /**
     * 数据序号
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(columnDefinition="BIGINT(20) COMMENT '主键'")
    protected Integer id;


    @CreatedDate
    @Column(columnDefinition="DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间'")
    protected Date createTime;


    @LastModifiedDate
    @Column(columnDefinition="DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间'")
    protected Date updateTime;

}
