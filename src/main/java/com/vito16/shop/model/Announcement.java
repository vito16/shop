/**
 *
 */
package com.vito16.shop.model;

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
@Table(name = "t_announcement")
public class Announcement implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer id;
    private String content;//公告内容
    private Date createTime;//公告时间
    private Admin createAdmin;//创建用户

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @ManyToOne
    @JoinColumn
    public Admin getCreateAdmin() {
        return createAdmin;
    }

    public void setCreateAdmin(Admin createAdmin) {
        this.createAdmin = createAdmin;
    }
}
