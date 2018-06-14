package com.joy.java.jpa.bean;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

@ApiModel(value = "sessionBean",description = "登录返回信息")
public class SessionBean implements Serializable {
    //信息状态吗
    @ApiModelProperty(value = "信息状态码")
    private String returnState;
    @ApiModelProperty(value = "返回信息")
    private String returnMessage;
    @ApiModelProperty(value = "用户token信息")
    private String tokenid;
    @ApiModelProperty(value = "城市no")//后面查询统计都会用到
    private String csno="";
    @ApiModelProperty(value = "县区no")
    private String xqno="";

    public String getReturnState() {
        return returnState;
    }

    public void setReturnState(String returnState) {
        this.returnState = returnState;
    }

    public String getReturnMessage() {
        return returnMessage;
    }

    public void setReturnMessage(String returnMessage) {
        this.returnMessage = returnMessage;
    }

    public String getTokenid() {
        return tokenid;
    }

    public void setTokenid(String tokenid) {
        this.tokenid = tokenid;
    }

    public String getCsno() {
        return csno;
    }

    public void setCsno(String csno) {
        this.csno = csno;
    }

    public String getXqno() {
        return xqno;
    }

    public void setXqno(String xqno) {
        this.xqno = xqno;
    }
}
