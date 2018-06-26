package com.joy.java.mybatis.model;

import java.io.Serializable;
import javax.persistence.*;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * qy_cs
 * @author 
 */
@Table(name="hngx20180423..qy_cs")
public class QyCs implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer csid;

    private Integer csSfid;

    @NotEmpty
    private String csNo;

    @NotEmpty
    private String csMc;

    private String csJc;

    private String csCtqh;

    private String csYzbm;

    private String csSx;

    private Integer csOrder;

    private String csBz;

    private static final long serialVersionUID = 1L;

    public Integer getCsid() {
        return csid;
    }

    public void setCsid(Integer csid) {
        this.csid = csid;
    }

    public Integer getCsSfid() {
        return csSfid;
    }

    public void setCsSfid(Integer csSfid) {
        this.csSfid = csSfid;
    }

    public String getCsNo() {
        return csNo;
    }

    public void setCsNo(String csNo) {
        this.csNo = csNo;
    }

    public String getCsMc() {
        return csMc;
    }

    public void setCsMc(String csMc) {
        this.csMc = csMc;
    }

    public String getCsJc() {
        return csJc;
    }

    public void setCsJc(String csJc) {
        this.csJc = csJc;
    }

    public String getCsCtqh() {
        return csCtqh;
    }

    public void setCsCtqh(String csCtqh) {
        this.csCtqh = csCtqh;
    }

    public String getCsYzbm() {
        return csYzbm;
    }

    public void setCsYzbm(String csYzbm) {
        this.csYzbm = csYzbm;
    }

    public String getCsSx() {
        return csSx;
    }

    public void setCsSx(String csSx) {
        this.csSx = csSx;
    }

    public Integer getCsOrder() {
        return csOrder;
    }

    public void setCsOrder(Integer csOrder) {
        this.csOrder = csOrder;
    }

    public String getCsBz() {
        return csBz;
    }

    public void setCsBz(String csBz) {
        this.csBz = csBz;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        QyCs other = (QyCs) that;
        return (this.getCsid() == null ? other.getCsid() == null : this.getCsid().equals(other.getCsid()))
            && (this.getCsSfid() == null ? other.getCsSfid() == null : this.getCsSfid().equals(other.getCsSfid()))
            && (this.getCsNo() == null ? other.getCsNo() == null : this.getCsNo().equals(other.getCsNo()))
            && (this.getCsMc() == null ? other.getCsMc() == null : this.getCsMc().equals(other.getCsMc()))
            && (this.getCsJc() == null ? other.getCsJc() == null : this.getCsJc().equals(other.getCsJc()))
            && (this.getCsCtqh() == null ? other.getCsCtqh() == null : this.getCsCtqh().equals(other.getCsCtqh()))
            && (this.getCsYzbm() == null ? other.getCsYzbm() == null : this.getCsYzbm().equals(other.getCsYzbm()))
            && (this.getCsSx() == null ? other.getCsSx() == null : this.getCsSx().equals(other.getCsSx()))
            && (this.getCsOrder() == null ? other.getCsOrder() == null : this.getCsOrder().equals(other.getCsOrder()))
            && (this.getCsBz() == null ? other.getCsBz() == null : this.getCsBz().equals(other.getCsBz()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getCsid() == null) ? 0 : getCsid().hashCode());
        result = prime * result + ((getCsSfid() == null) ? 0 : getCsSfid().hashCode());
        result = prime * result + ((getCsNo() == null) ? 0 : getCsNo().hashCode());
        result = prime * result + ((getCsMc() == null) ? 0 : getCsMc().hashCode());
        result = prime * result + ((getCsJc() == null) ? 0 : getCsJc().hashCode());
        result = prime * result + ((getCsCtqh() == null) ? 0 : getCsCtqh().hashCode());
        result = prime * result + ((getCsYzbm() == null) ? 0 : getCsYzbm().hashCode());
        result = prime * result + ((getCsSx() == null) ? 0 : getCsSx().hashCode());
        result = prime * result + ((getCsOrder() == null) ? 0 : getCsOrder().hashCode());
        result = prime * result + ((getCsBz() == null) ? 0 : getCsBz().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", csid=").append(csid);
        sb.append(", csSfid=").append(csSfid);
        sb.append(", csNo=").append(csNo);
        sb.append(", csMc=").append(csMc);
        sb.append(", csJc=").append(csJc);
        sb.append(", csCtqh=").append(csCtqh);
        sb.append(", csYzbm=").append(csYzbm);
        sb.append(", csSx=").append(csSx);
        sb.append(", csOrder=").append(csOrder);
        sb.append(", csBz=").append(csBz);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}