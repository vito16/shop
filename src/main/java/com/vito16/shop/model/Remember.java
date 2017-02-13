package com.vito16.shop.model;

import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.util.Date;

/**
 * @author 木鱼 muyu@yiji.com
 * @version 2017/2/13
 */
@Entity
@Table(name = "t_remember")
public class Remember {

    @Id
    private String id;

    @ManyToOne
    @JoinColumn
    private User user;

    @CreatedDate
    private Date addTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }
}
