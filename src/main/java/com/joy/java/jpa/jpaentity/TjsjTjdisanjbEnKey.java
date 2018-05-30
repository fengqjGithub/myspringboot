package com.joy.java.jpa.jpaentity;

import com.google.common.base.Objects;

import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * @Package: com.joy.java.jpa.jpaentity
 * @Class: TjsjTjdisanjbEnKey
 * @Author: 冯前进
 * @date: 2018/5/15 15:15
 * @Description: TODO
 * @Param: param
 * @ReturnType: 
 * @Exception   
 **/
@Embeddable
public class TjsjTjdisanjbEnKey implements Serializable {
    private static final long serialVersionUID = -334319243957837925L;
    private String tjdisanjb_tjlxno;
    private String tjdisanjb_col2;
    private String tjdisanjb_col4;
    private String tjdisanjb_col9;

    public TjsjTjdisanjbEnKey(){}
    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getTjdisanjb_tjlxno() {
        return tjdisanjb_tjlxno;
    }

    public void setTjdisanjb_tjlxno(String tjdisanjb_tjlxno) {
        this.tjdisanjb_tjlxno = tjdisanjb_tjlxno;
    }

    public String getTjdisanjb_col2() {
        return tjdisanjb_col2;
    }

    public void setTjdisanjb_col2(String tjdisanjb_col2) {
        this.tjdisanjb_col2 = tjdisanjb_col2;
    }

    public String getTjdisanjb_col4() {
        return tjdisanjb_col4;
    }

    public void setTjdisanjb_col4(String tjdisanjb_col4) {
        this.tjdisanjb_col4 = tjdisanjb_col4;
    }

    public String getTjdisanjb_col9() {
        return tjdisanjb_col9;
    }

    public void setTjdisanjb_col9(String tjdisanjb_col9) {
        this.tjdisanjb_col9 = tjdisanjb_col9;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TjsjTjdisanjbEnKey)) return false;
        TjsjTjdisanjbEnKey that = (TjsjTjdisanjbEnKey) o;
        return Objects.equal(getTjdisanjb_tjlxno(), that.getTjdisanjb_tjlxno()) &&
                Objects.equal(getTjdisanjb_col2(), that.getTjdisanjb_col2()) &&
                Objects.equal(getTjdisanjb_col4(), that.getTjdisanjb_col4()) &&
                Objects.equal(getTjdisanjb_col9(), that.getTjdisanjb_col9());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getTjdisanjb_tjlxno(), getTjdisanjb_col2(), getTjdisanjb_col4(), getTjdisanjb_col9());
    }
}
