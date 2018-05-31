package com.joy.java.jpa.jpaentity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @Package: com.joy.java.jpa.jpaentity
 * @Class: TjsjTjdierjbEn
 * @Author: Joy
 * @date: 2018/5/15 15:09
 * @Description: TODO
 * @Param: param
 * @ReturnType: 
 * @Exception   
 **/
@Entity
@Table(name="tjsj_tjdierjb_v")
public class TjsjTjdierjbEn {
    @Id
    private String id;
    @Column(name="tjdierjb_tjlxno")
    private String tjdierjbTjlxno = null;	//统计类型编号 (varchar 32)
//    @EmbeddedId
//    private TjsjTjdierjbEnKey tjsjTjdierjbEnKey;
    private String tjdierjb_tjlblxno = null;	//列表类型编号 (varchar 32)
    private Integer tjdierjb_bjzt = null;	//标记状态 (int 10)
    private Integer tjdierjb_order = null;	//排序 (int 10)
    private String tjdierjb_cxtj = null;	//查询条件 (varchar 256)
    @Column(name="tjdierjb_col1")
    private String tjdierjbCol1 = null;	//列1 (varchar 64)
    private String tjdierjb_col2 = null;	//列2 (varchar 64)
    private String tjdierjb_col3 = null;	//列3 (varchar 64)
    private String tjdierjb_col4 = null;	//列4 (varchar 64)
    private String tjdierjb_col5 = null;	//列5 (varchar 64)
    private String tjdierjb_col6 = null;	//列6 (varchar 64)
    private String tjdierjb_col7 = null;	//列7 (varchar 64)
    private String tjdierjb_col8 = null;	//列8 (varchar 64)
    private String tjdierjb_col9 = null;	//列9 (varchar 64)
    private String tjdierjb_col10 = null;	//列10 (varchar 64)
    private String tjdierjb_col11 = null;	//列11 (varchar 64)
    private String tjdierjb_col12 = null;	//列12 (varchar 64)
    private String tjdierjb_col13 = null;	//列13 (varchar 64)
    private String tjdierjb_col14 = null;	//列14 (varchar 64)
    private String tjdierjb_col15 = null;	//列15 (varchar 64)
    private String tjdierjb_col16 = null;	//列16 (varchar 64)
    private String tjdierjb_col17 = null;	//列17 (varchar 64)
    private String tjdierjb_col18 = null;	//列18 (varchar 64)
    private String tjdierjb_col19 = null;	//列19 (varchar 64)
    private String tjdierjb_col20 = null;	//列20 (varchar 64)
    private String tjdierjb_col21 = null;	//列21 (varchar 64)
    private String tjdierjb_col22 = null;	//列22 (varchar 64)
    private String tjdierjb_col23 = null;	//列23 (varchar 64)
    private String tjdierjb_col24 = null;	//列24 (varchar 64)
    private String tjdierjb_col25 = null;	//列25 (varchar 64)
    private String tjdierjb_col26 = null;	//列26 (varchar 64)
    private String tjdierjb_col27 = null;	//列27 (varchar 64)
    private String tjdierjb_col28 = null;	//列28 (varchar 64)
    private String tjdierjb_col29 = null;	//列29 (varchar 64)
    private String tjdierjb_col30 = null;	//列30 (varchar 64)

    public void setTjdierjb_tjlblxno(String tjdierjb_tjlblxno) {
        this.tjdierjb_tjlblxno = tjdierjb_tjlblxno;
    }

    public Integer getTjdierjb_bjzt() {
        return tjdierjb_bjzt;
    }

    public void setTjdierjb_bjzt(Integer tjdierjb_bjzt) {
        this.tjdierjb_bjzt = tjdierjb_bjzt;
    }

    public Integer getTjdierjb_order() {
        return tjdierjb_order;
    }

    public void setTjdierjb_order(Integer tjdierjb_order) {
        this.tjdierjb_order = tjdierjb_order;
    }

    public String getTjdierjb_cxtj() {
        return tjdierjb_cxtj;
    }

    public void setTjdierjb_cxtj(String tjdierjb_cxtj) {
        this.tjdierjb_cxtj = tjdierjb_cxtj;
    }

    public String getTjdierjbCol1() {
        return tjdierjbCol1;
    }

    public void setTjdierjbCol1(String tjdierjbCol1) {
        this.tjdierjbCol1 = tjdierjbCol1;
    }

    public String getTjdierjb_col3() {
        return tjdierjb_col3;
    }

    public void setTjdierjb_col3(String tjdierjb_col3) {
        this.tjdierjb_col3 = tjdierjb_col3;
    }

    public String getTjdierjb_col4() {
        return tjdierjb_col4;
    }

    public void setTjdierjb_col4(String tjdierjb_col4) {
        this.tjdierjb_col4 = tjdierjb_col4;
    }

    public String getTjdierjb_col5() {
        return tjdierjb_col5;
    }

    public void setTjdierjb_col5(String tjdierjb_col5) {
        this.tjdierjb_col5 = tjdierjb_col5;
    }

    public String getTjdierjb_col6() {
        return tjdierjb_col6;
    }

    public void setTjdierjb_col6(String tjdierjb_col6) {
        this.tjdierjb_col6 = tjdierjb_col6;
    }

    public String getTjdierjb_col8() {
        return tjdierjb_col8;
    }

    public void setTjdierjb_col8(String tjdierjb_col8) {
        this.tjdierjb_col8 = tjdierjb_col8;
    }

    public String getTjdierjb_col10() {
        return tjdierjb_col10;
    }

    public void setTjdierjb_col10(String tjdierjb_col10) {
        this.tjdierjb_col10 = tjdierjb_col10;
    }

    public String getTjdierjb_col11() {
        return tjdierjb_col11;
    }

    public void setTjdierjb_col11(String tjdierjb_col11) {
        this.tjdierjb_col11 = tjdierjb_col11;
    }

    public String getTjdierjb_col12() {
        return tjdierjb_col12;
    }

    public void setTjdierjb_col12(String tjdierjb_col12) {
        this.tjdierjb_col12 = tjdierjb_col12;
    }

    public String getTjdierjb_col13() {
        return tjdierjb_col13;
    }

    public void setTjdierjb_col13(String tjdierjb_col13) {
        this.tjdierjb_col13 = tjdierjb_col13;
    }

    public String getTjdierjb_col14() {
        return tjdierjb_col14;
    }

    public void setTjdierjb_col14(String tjdierjb_col14) {
        this.tjdierjb_col14 = tjdierjb_col14;
    }

    public String getTjdierjb_col15() {
        return tjdierjb_col15;
    }

    public void setTjdierjb_col15(String tjdierjb_col15) {
        this.tjdierjb_col15 = tjdierjb_col15;
    }

    public String getTjdierjb_col16() {
        return tjdierjb_col16;
    }

    public void setTjdierjb_col16(String tjdierjb_col16) {
        this.tjdierjb_col16 = tjdierjb_col16;
    }

    public String getTjdierjb_col17() {
        return tjdierjb_col17;
    }

    public void setTjdierjb_col17(String tjdierjb_col17) {
        this.tjdierjb_col17 = tjdierjb_col17;
    }

    public String getTjdierjb_col18() {
        return tjdierjb_col18;
    }

    public void setTjdierjb_col18(String tjdierjb_col18) {
        this.tjdierjb_col18 = tjdierjb_col18;
    }

    public String getTjdierjb_col19() {
        return tjdierjb_col19;
    }

    public void setTjdierjb_col19(String tjdierjb_col19) {
        this.tjdierjb_col19 = tjdierjb_col19;
    }

    public String getTjdierjb_col20() {
        return tjdierjb_col20;
    }

    public void setTjdierjb_col20(String tjdierjb_col20) {
        this.tjdierjb_col20 = tjdierjb_col20;
    }

    public String getTjdierjb_col21() {
        return tjdierjb_col21;
    }

    public void setTjdierjb_col21(String tjdierjb_col21) {
        this.tjdierjb_col21 = tjdierjb_col21;
    }

    public String getTjdierjb_col22() {
        return tjdierjb_col22;
    }

    public void setTjdierjb_col22(String tjdierjb_col22) {
        this.tjdierjb_col22 = tjdierjb_col22;
    }

    public String getTjdierjb_col23() {
        return tjdierjb_col23;
    }

    public void setTjdierjb_col23(String tjdierjb_col23) {
        this.tjdierjb_col23 = tjdierjb_col23;
    }

    public String getTjdierjb_col24() {
        return tjdierjb_col24;
    }

    public void setTjdierjb_col24(String tjdierjb_col24) {
        this.tjdierjb_col24 = tjdierjb_col24;
    }

    public String getTjdierjb_col25() {
        return tjdierjb_col25;
    }

    public void setTjdierjb_col25(String tjdierjb_col25) {
        this.tjdierjb_col25 = tjdierjb_col25;
    }

    public String getTjdierjb_col26() {
        return tjdierjb_col26;
    }

    public void setTjdierjb_col26(String tjdierjb_col26) {
        this.tjdierjb_col26 = tjdierjb_col26;
    }

    public String getTjdierjb_col27() {
        return tjdierjb_col27;
    }

    public void setTjdierjb_col27(String tjdierjb_col27) {
        this.tjdierjb_col27 = tjdierjb_col27;
    }

    public String getTjdierjb_col28() {
        return tjdierjb_col28;
    }

    public void setTjdierjb_col28(String tjdierjb_col28) {
        this.tjdierjb_col28 = tjdierjb_col28;
    }

    public String getTjdierjb_col29() {
        return tjdierjb_col29;
    }

    public void setTjdierjb_col29(String tjdierjb_col29) {
        this.tjdierjb_col29 = tjdierjb_col29;
    }

    public String getTjdierjb_col30() {
        return tjdierjb_col30;
    }

    public void setTjdierjb_col30(String tjdierjb_col30) {
        this.tjdierjb_col30 = tjdierjb_col30;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTjdierjbTjlxno() {
        return tjdierjbTjlxno;
    }

    public void setTjdierjbTjlxno(String tjdierjbTjlxno) {
        this.tjdierjbTjlxno = tjdierjbTjlxno;
    }

    public String getTjdierjb_tjlblxno() {
        return tjdierjb_tjlblxno;
    }

    public String getTjdierjb_col2() {
        return tjdierjb_col2;
    }

    public void setTjdierjb_col2(String tjdierjb_col2) {
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

}
