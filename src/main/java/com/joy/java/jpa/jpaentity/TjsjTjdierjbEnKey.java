package com.joy.java.jpa.jpaentity;

import com.google.common.base.Objects;

import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * @Package: com.joy.java.jpa.jpaentity
 * @Class: TjsjTjdierjbEnKey
 * @Author: 冯前进
 * @date: 2018/5/15 15:08
 * @Description: TODO
 * @Param: param
 * @ReturnType: 
 * @Exception   
 **/
@Embeddable
public class TjsjTjdierjbEnKey implements Serializable {
    private static final long serialVersionUID = -330431924395783725L;
    private String tjdierjb_tjlxno;
    private String tjdierjb_col2;
    private String tjdierjb_col7;
    private String tjdierjb_col9;

    public TjsjTjdierjbEnKey(){}

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getTjdierjb_tjlxno() {
        return tjdierjb_tjlxno;
    }

    public void setTjdierjb_tjlxno(String tjdierjb_tjlxno) {
        this.tjdierjb_tjlxno = tjdierjb_tjlxno;
    }

    public String getTjdierjb_col2() {
        return tjdierjb_col2;
    }

    public void setTjdierjb_col1(String tjdierjb_col2) {
        this.tjdierjb_col2 = tjdierjb_col2;
    }

    public String getTjdierjb_col7() {
        return tjdierjb_col7;
    }

    public void setTjdierjb_col7(String tjdierjb_col7) {
        this.tjdierjb_col7 = tjdierjb_col7;
    }

    public String getTjdierjb_col9() {
        return tjdierjb_col9;
    }

    public void setTjdierjb_col9(String tjdierjb_col9) {
        this.tjdierjb_col9 = tjdierjb_col9;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TjsjTjdierjbEnKey)) return false;
        TjsjTjdierjbEnKey that = (TjsjTjdierjbEnKey) o;
        return Objects.equal(getTjdierjb_tjlxno(), that.getTjdierjb_tjlxno()) &&
                Objects.equal(getTjdierjb_col2(), that.getTjdierjb_col2()) &&
                Objects.equal(getTjdierjb_col7(), that.getTjdierjb_col7()) &&
                Objects.equal(getTjdierjb_col9(), that.getTjdierjb_col9());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getTjdierjb_tjlxno(), getTjdierjb_col2(), getTjdierjb_col7(), getTjdierjb_col9());
    }
}
