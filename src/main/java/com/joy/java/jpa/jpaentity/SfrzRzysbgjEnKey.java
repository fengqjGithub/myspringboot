package com.joy.java.jpa.jpaentity;

import com.google.common.base.Objects;

import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * @Package: com.joy.java.jpa.jpaentity
 * @Class: SfrzRzysbgjEnKey
 * @Author: Joy
 * @date: 2018/5/15 15:09
 * @Description: TODO
 * @Param: param
 * @ReturnType: 
 * @Exception   
 **/
@Embeddable
public class SfrzRzysbgjEnKey implements Serializable {
    private static final long serialVersionUID = -33043924395783725L;
    private String rzysbgj_kcno ;	//考场编码 (varchar 32)
    private String rzysbgj_zipmc ;	//压缩包名称 (varchar 128)

    public SfrzRzysbgjEnKey() {
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getRzysbgj_kcno() {
        return rzysbgj_kcno;
    }

    public void setRzysbgj_kcno(String rzysbgj_kcno) {
        this.rzysbgj_kcno = rzysbgj_kcno;
    }

    public String getRzysbgj_zipmc() {
        return rzysbgj_zipmc;
    }

    public void setRzysbgj_zipmc(String rzysbgj_zipmc) {
        this.rzysbgj_zipmc = rzysbgj_zipmc;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SfrzRzysbgjEnKey)) return false;
        SfrzRzysbgjEnKey that = (SfrzRzysbgjEnKey) o;
        return Objects.equal(getRzysbgj_kcno(), that.getRzysbgj_kcno()) &&
                Objects.equal(getRzysbgj_zipmc(), that.getRzysbgj_zipmc());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getRzysbgj_kcno(), getRzysbgj_zipmc());
    }
}
