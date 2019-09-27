package com.vito16.shop.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.util.Date;

/**
 * @author 木鱼 muyu@yiji.com
 * @version 2017/2/13
 */
@Setter
@Getter
@Entity
@Table(name = "t_remember")
public class Remember extends AbstractEntity {

    @ManyToOne
    @JoinColumn
    private User user;

}
