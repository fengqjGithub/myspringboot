package com.joy.java.jpa.jpaentity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @Package: com.joy.java.jpa.jpaentity
 * @Class: TjsjTjdiyijbEn
 * @Author: 冯前进
 * @date: 2018/5/15 15:15
 * @Description: TODO
 * @Param: param
 * @ReturnType: 
 * @Exception   
 **/

/**
 * 视图映射
 */
@Entity
@Table(name = "tjsj_tjdiyijb_v")
public class TjsjTjdiyijbEn {
    @Id
    private String id;
    @Column(name = "tjdiyijb_tjlxno")
    private String tjdiyijbTjlxno = null;    //统计类型编号 (varchar 32)
    //    @EmbeddedId
//    private TjsjTjdiyijbEnKey tjsjTjdiyijbEnKey;
    @Column(name = "tjdiyijb_tjlblxno")
    private String tjdiyijbTjlblxno = null;    //列表类型编号 (varchar 32)
    private Integer tjdiyijb_bjzt = null;    //标记状态 (int 10)
    private Integer tjdiyijb_order = null;    //排序 (int 10)
    private String tjdiyijb_cxtj = null;    //查询条件 (varchar 256)
    @Column(name = "tjdiyijb_col1")
    private String tjdiyijbCol1 = null;    //列1 (varchar 64)
    private String tjdiyijb_col2 = null;    //列2 (varchar 64)
    private String tjdiyijb_col3 = null;    //列3 (varchar 64)
    private String tjdiyijb_col4 = null;    //列4 (varchar 64)
    private String tjdiyijb_col5 = null;    //列5 (varchar 64)
    private String tjdiyijb_col6 = null;    //列6 (varchar 64)
    private String tjdiyijb_col7 = null;    //列7 (varchar 64)
    private String tjdiyijb_col8 = null;    //列8 (varchar 64)
    private String tjdiyijb_col9 = null;    //列9 (varchar 64)
    private String tjdiyijb_col10 = null;    //列10 (varchar 64)
    private String tjdiyijb_col11 = null;    //列11 (varchar 64)
    private String tjdiyijb_col12 = null;    //列12 (varchar 64)
    private String tjdiyijb_col13 = null;    //列13 (varchar 64)
    private String tjdiyijb_col14 = null;    //列14 (varchar 64)
    private String tjdiyijb_col15 = null;    //列15 (varchar 64)
    private String tjdiyijb_col16 = null;    //列16 (varchar 64)
    private String tjdiyijb_col17 = null;    //列17 (varchar 64)
    private String tjdiyijb_col18 = null;    //列18 (varchar 64)
    private String tjdiyijb_col19 = null;    //列19 (varchar 64)
    private String tjdiyijb_col20 = null;    //列20 (varchar 64)
    private String tjdiyijb_col21 = null;    //列21 (varchar 64)
    private String tjdiyijb_col22 = null;    //列22 (varchar 64)
    private String tjdiyijb_col23 = null;    //列23 (varchar 64)
    private String tjdiyijb_col24 = null;    //列24 (varchar 64)
    private String tjdiyijb_col25 = null;    //列25 (varchar 64)
    private String tjdiyijb_col26 = null;    //列26 (varchar 64)
    private String tjdiyijb_col27 = null;    //列27 (varchar 64)
    private String tjdiyijb_col28 = null;    //列28 (varchar 64)
    private String tjdiyijb_col29 = null;    //列29 (varchar 64)
    private String tjdiyijb_col30 = null;    //列30 (varchar 64)


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTjdiyijbTjlxno() {
        return tjdiyijbTjlxno;
    }

    public void setTjdiyijbTjlxno(String tjdiyijbTjlxno) {
        this.tjdiyijbTjlxno = tjdiyijbTjlxno;
    }

    public String getTjdiyijb_col9() {
        return tjdiyijb_col9;
    }

    public void setTjdiyijb_col9(String tjdiyijb_col9) {
        this.tjdiyijb_col9 = tjdiyijb_col9;
    }

    public String getTjdiyijb_col10() {
        return tjdiyijb_col10;
    }

    public void setTjdiyijb_col10(String tjdiyijb_col10) {
        this.tjdiyijb_col10 = tjdiyijb_col10;
    }

    public Integer getTjdiyijb_bjzt() {
        return tjdiyijb_bjzt;
    }

    public void setTjdiyijb_bjzt(Integer tjdiyijb_bjzt) {
        this.tjdiyijb_bjzt = tjdiyijb_bjzt;
    }

    public Integer getTjdiyijb_order() {
        return tjdiyijb_order;
    }

    public void setTjdiyijb_order(Integer tjdiyijb_order) {
        this.tjdiyijb_order = tjdiyijb_order;
    }

    public String getTjdiyijb_cxtj() {
        return tjdiyijb_cxtj;
    }

    public void setTjdiyijb_cxtj(String tjdiyijb_cxtj) {
        this.tjdiyijb_cxtj = tjdiyijb_cxtj;
    }

    public String getTjdiyijb_col2() {
        return tjdiyijb_col2;
    }

    public void setTjdiyijb_col2(String tjdiyijb_col2) {
        this.tjdiyijb_col2 = tjdiyijb_col2;
    }

    public String getTjdiyijb_col3() {
        return tjdiyijb_col3;
    }

    public void setTjdiyijb_col3(String tjdiyijb_col3) {
        this.tjdiyijb_col3 = tjdiyijb_col3;
    }

    public String getTjdiyijb_col4() {
        return tjdiyijb_col4;
    }

    public void setTjdiyijb_col4(String tjdiyijb_col4) {
        this.tjdiyijb_col4 = tjdiyijb_col4;
    }

    public String getTjdiyijb_col5() {
        return tjdiyijb_col5;
    }

    public void setTjdiyijb_col5(String tjdiyijb_col5) {
        this.tjdiyijb_col5 = tjdiyijb_col5;
    }

    public String getTjdiyijb_col6() {
        return tjdiyijb_col6;
    }

    public void setTjdiyijb_col6(String tjdiyijb_col6) {
        this.tjdiyijb_col6 = tjdiyijb_col6;
    }

    public String getTjdiyijb_col7() {
        return tjdiyijb_col7;
    }

    public void setTjdiyijb_col7(String tjdiyijb_col7) {
        this.tjdiyijb_col7 = tjdiyijb_col7;
    }

    public String getTjdiyijb_col8() {
        return tjdiyijb_col8;
    }

    public void setTjdiyijb_col8(String tjdiyijb_col8) {
        this.tjdiyijb_col8 = tjdiyijb_col8;
    }

    public String getTjdiyijb_col11() {
        return tjdiyijb_col11;
    }

    public void setTjdiyijb_col11(String tjdiyijb_col11) {
        this.tjdiyijb_col11 = tjdiyijb_col11;
    }

    public String getTjdiyijb_col12() {
        return tjdiyijb_col12;
    }

    public void setTjdiyijb_col12(String tjdiyijb_col12) {
        this.tjdiyijb_col12 = tjdiyijb_col12;
    }

    public String getTjdiyijb_col13() {
        return tjdiyijb_col13;
    }

    public void setTjdiyijb_col13(String tjdiyijb_col13) {
        this.tjdiyijb_col13 = tjdiyijb_col13;
    }

    public String getTjdiyijb_col14() {
        return tjdiyijb_col14;
    }

    public void setTjdiyijb_col14(String tjdiyijb_col14) {
        this.tjdiyijb_col14 = tjdiyijb_col14;
    }

    public String getTjdiyijb_col15() {
        return tjdiyijb_col15;
    }

    public void setTjdiyijb_col15(String tjdiyijb_col15) {
        this.tjdiyijb_col15 = tjdiyijb_col15;
    }

    public String getTjdiyijb_col16() {
        return tjdiyijb_col16;
    }

    public void setTjdiyijb_col16(String tjdiyijb_col16) {
        this.tjdiyijb_col16 = tjdiyijb_col16;
    }

    public String getTjdiyijb_col17() {
        return tjdiyijb_col17;
    }

    public void setTjdiyijb_col17(String tjdiyijb_col17) {
        this.tjdiyijb_col17 = tjdiyijb_col17;
    }

    public String getTjdiyijb_col18() {
        return tjdiyijb_col18;
    }

    public void setTjdiyijb_col18(String tjdiyijb_col18) {
        this.tjdiyijb_col18 = tjdiyijb_col18;
    }

    public String getTjdiyijb_col19() {
        return tjdiyijb_col19;
    }

    public void setTjdiyijb_col19(String tjdiyijb_col19) {
        this.tjdiyijb_col19 = tjdiyijb_col19;
    }

    public String getTjdiyijb_col20() {
        return tjdiyijb_col20;
    }

    public void setTjdiyijb_col20(String tjdiyijb_col20) {
        this.tjdiyijb_col20 = tjdiyijb_col20;
    }

    public String getTjdiyijb_col21() {
        return tjdiyijb_col21;
    }

    public void setTjdiyijb_col21(String tjdiyijb_col21) {
        this.tjdiyijb_col21 = tjdiyijb_col21;
    }

    public String getTjdiyijb_col22() {
        return tjdiyijb_col22;
    }

    public void setTjdiyijb_col22(String tjdiyijb_col22) {
        this.tjdiyijb_col22 = tjdiyijb_col22;
    }

    public String getTjdiyijb_col23() {
        return tjdiyijb_col23;
    }

    public void setTjdiyijb_col23(String tjdiyijb_col23) {
        this.tjdiyijb_col23 = tjdiyijb_col23;
    }

    public String getTjdiyijb_col24() {
        return tjdiyijb_col24;
    }

    public void setTjdiyijb_col24(String tjdiyijb_col24) {
        this.tjdiyijb_col24 = tjdiyijb_col24;
    }

    public String getTjdiyijb_col25() {
        return tjdiyijb_col25;
    }

    public void setTjdiyijb_col25(String tjdiyijb_col25) {
        this.tjdiyijb_col25 = tjdiyijb_col25;
    }

    public String getTjdiyijb_col26() {
        return tjdiyijb_col26;
    }

    public void setTjdiyijb_col26(String tjdiyijb_col26) {
        this.tjdiyijb_col26 = tjdiyijb_col26;
    }

    public String getTjdiyijb_col27() {
        return tjdiyijb_col27;
    }

    public void setTjdiyijb_col27(String tjdiyijb_col27) {
        this.tjdiyijb_col27 = tjdiyijb_col27;
    }

    public String getTjdiyijb_col28() {
        return tjdiyijb_col28;
    }

    public void setTjdiyijb_col28(String tjdiyijb_col28) {
        this.tjdiyijb_col28 = tjdiyijb_col28;
    }

    public String getTjdiyijb_col29() {
        return tjdiyijb_col29;
    }

    public void setTjdiyijb_col29(String tjdiyijb_col29) {
        this.tjdiyijb_col29 = tjdiyijb_col29;
    }

    public String getTjdiyijb_col30() {
        return tjdiyijb_col30;
    }

    public void setTjdiyijb_col30(String tjdiyijb_col30) {
        this.tjdiyijb_col30 = tjdiyijb_col30;
    }

    public String getTjdiyijbTjlblxno() {
        return tjdiyijbTjlblxno;
    }

    public void setTjdiyijbTjlblxno(String tjdiyijbTjlblxno) {
        this.tjdiyijbTjlblxno = tjdiyijbTjlblxno;
    }

    public String getTjdiyijbCol1() {
        return tjdiyijbCol1;
    }

    public void setTjdiyijbCol1(String tjdiyijbCol1) {
        this.tjdiyijbCol1 = tjdiyijbCol1;
    }
}
