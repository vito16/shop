package com.vito16.shop.common;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @author 木鱼 muyu@yiji.com
 * @version 2017/12/15
 */
@Setter
@Getter
public class ResultBase implements Serializable {

    /**
     * 状态
     */
    private Status status;

    /**
     * 消息
     */
    private String message;


    public void setToFail(){
        this.message = "未知异常";
        this.status = Status.FAIL;
    }

    public void setToFail(String message){
        this.message = message;
        this.status = Status.FAIL;
    }

    public void setToSuccess(){
        this.message = "成功";
        this.status = Status.SUCCESS;
    }

    public void setToSuccess(String message){
        this.message = message;
        this.status = Status.SUCCESS;
    }

    @Override
    public String toString() {
        return ToString.toString(this);
    }
}
