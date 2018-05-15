package com.joy.java.jpa.jpaentity;

import com.google.common.base.Objects;

import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * @Package: com.joy.java.jpa.jpaentity
 * @Class: TjsjTjdiyijbEnKey
 * @Author: 冯前进
 * @date: 2018/5/15 15:09
 * @Description: TODO
 * @Param: param
 * @ReturnType: 
 * @Exception   
 **/
@Embeddable
public class TjsjTjdiyijbEnKey implements Serializable {
    private static final long serialVersionUID = -33043192495783725L;
    private String tjdiyijb_tjlxno = null;	//统计类型编号 (varchar 32)
    private String tjdiyijb_col10 = null;	//列1 (varchar 64)
    private String tjdiyijb_col9 = null;	//列9 (varchar 64)

    public TjsjTjdiyijbEnKey() {
    }

    public String getTjdiyijb_tjlxno() {
        return tjdiyijb_tjlxno;
    }

    public void setTjdiyijb_tjlxno(String tjdiyijb_tjlxno) {
        this.tjdiyijb_tjlxno = tjdiyijb_tjlxno;
    }

    public String getTjdiyijb_col10() {
        return tjdiyijb_col10;
    }

    public void setTjdiyijb_col10(String tjdiyijb_col10) {
        this.tjdiyijb_col10 = tjdiyijb_col10;
    }

    public String getTjdiyijb_col9() {
        return tjdiyijb_col9;
    }

    public void setTjdiyijb_col9(String tjdiyijb_col9) {
        this.tjdiyijb_col9 = tjdiyijb_col9;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TjsjTjdiyijbEnKey)) return false;
        TjsjTjdiyijbEnKey that = (TjsjTjdiyijbEnKey) o;
        return Objects.equal(getTjdiyijb_tjlxno(), that.getTjdiyijb_tjlxno()) &&
                Objects.equal(getTjdiyijb_col10(), that.getTjdiyijb_col10()) &&
                Objects.equal(getTjdiyijb_col9(), that.getTjdiyijb_col9());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getTjdiyijb_tjlxno(), getTjdiyijb_col10(), getTjdiyijb_col9());
    }
}
