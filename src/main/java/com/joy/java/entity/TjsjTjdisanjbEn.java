package com.joy.java.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @Project: sfrzapi
 * @Package: com.hnzr.login.entity
 * @Author: 冯前进
 * @Date: 2018-01-16 15:55
 * @Description: TODO
 **/
@Entity
@Table(name = "tjsj_tjdisanjb_v")
@ApiModel(value = "tjsjTjdisanjbEn", description = "第三级别统计数据")
public class TjsjTjdisanjbEn {
    //    @EmbeddedId
//    private TjsjTjdisanjbEnKey tjsjTjdisanjbEnKey;
    @Id
    @ApiModelProperty(value = "拼接的id")
    private String id;
    @Column(name = "tjdisanjb_tjlxno")
    @ApiModelProperty(value = "统计类型编号")
    private String tjdisanjbTjlxno = null;    //统计类型编号 (varchar 32)\
    @Column(name = "tjdisanjb_tjlblxno")
    @ApiModelProperty(value = "列表类型编号")
    private String tjdisanjbTjlblxno = null;    //列表类型编号 (varchar 32)
    @ApiModelProperty(value = "标记状态")
    private Integer tjdisanjb_bjzt = null;    //标记状态 (int 10)
    @ApiModelProperty(value = "排序")
    private Integer tjdisanjb_order = null;    //排序 (int 10)
    @ApiModelProperty(value = "查询条件")
    private String tjdisanjb_cxtj = null;    //查询条件 (varchar 256)
    @Column(name = "tjdisanjb_col1")
    private String tjdisanjbCol1 = null;    //列1 (varchar 64)
    private String tjdisanjb_col2 = null;    //列2 (varchar 64)
    private String tjdisanjb_col3 = null;    //列3 (varchar 64)
    private String tjdisanjb_col4 = null;    //列4 (varchar 64)
    private String tjdisanjb_col5 = null;    //列5 (varchar 64)
    private String tjdisanjb_col6 = null;    //列6 (varchar 64)
    private String tjdisanjb_col7 = null;    //列7 (varchar 64)
    private String tjdisanjb_col8 = null;    //列8 (varchar 64)
    private String tjdisanjb_col9 = null;    //列9 (varchar 64)
    private String tjdisanjb_col10 = null;    //列10 (varchar 64)
    private String tjdisanjb_col11 = null;    //列11 (varchar 64)
    private String tjdisanjb_col12 = null;    //列12 (varchar 64)
    private String tjdisanjb_col13 = null;    //列13 (varchar 64)
    private String tjdisanjb_col14 = null;    //列14 (varchar 64)
    private String tjdisanjb_col15 = null;    //列15 (varchar 64)
    private String tjdisanjb_col16 = null;    //列16 (varchar 64)
    private String tjdisanjb_col17 = null;    //列17 (varchar 64)
    private String tjdisanjb_col18 = null;    //列18 (varchar 64)
    private String tjdisanjb_col19 = null;    //列19 (varchar 64)
    private String tjdisanjb_col20 = null;    //列20 (varchar 64)
    private String tjdisanjb_col21 = null;    //列21 (varchar 64)
    private String tjdisanjb_col22 = null;    //列22 (varchar 64)
    private String tjdisanjb_col23 = null;    //列23 (varchar 64)
    private String tjdisanjb_col24 = null;    //列24 (varchar 64)
    private String tjdisanjb_col25 = null;    //列25 (varchar 64)
    private String tjdisanjb_col26 = null;    //列26 (varchar 64)
    private String tjdisanjb_col27 = null;    //列27 (varchar 64)
    private String tjdisanjb_col28 = null;    //列28 (varchar 64)
    private String tjdisanjb_col29 = null;    //列29 (varchar 64)
    private String tjdisanjb_col30 = null;    //列30 (varchar 64)

//    public TjsjTjdisanjbEnKey getTjsjTjdisanjbEnKey() {
//        return tjsjTjdisanjbEnKey;
//    }
//
//    public void setTjsjTjdisanjbEnKey(TjsjTjdisanjbEnKey tjsjTjdisanjbEnKey) {
//        this.tjsjTjdisanjbEnKey = tjsjTjdisanjbEnKey;
//    }

    public TjsjTjdisanjbEn() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTjdisanjbTjlblxno() {
        return tjdisanjbTjlblxno;
    }

    public void setTjdisanjbTjlblxno(String tjdisanjbTjlblxno) {
        this.tjdisanjbTjlblxno = tjdisanjbTjlblxno;
    }

    public Integer getTjdisanjb_bjzt() {
        return tjdisanjb_bjzt;
    }

    public void setTjdisanjb_bjzt(Integer tjdisanjb_bjzt) {
        this.tjdisanjb_bjzt = tjdisanjb_bjzt;
    }

    public Integer getTjdisanjb_order() {
        return tjdisanjb_order;
    }

    public void setTjdisanjb_order(Integer tjdisanjb_order) {
        this.tjdisanjb_order = tjdisanjb_order;
    }

    public String getTjdisanjb_cxtj() {
        return tjdisanjb_cxtj;
    }

    public void setTjdisanjb_cxtj(String tjdisanjb_cxtj) {
        this.tjdisanjb_cxtj = tjdisanjb_cxtj;
    }

    public String getTjdisanjbCol1() {
        return tjdisanjbCol1;
    }

    public void setTjdisanjbCol1(String tjdisanjbCol1) {
        this.tjdisanjbCol1 = tjdisanjbCol1;
    }

    public String getTjdisanjb_col3() {
        return tjdisanjb_col3;
    }

    public void setTjdisanjb_col3(String tjdisanjb_col3) {
        this.tjdisanjb_col3 = tjdisanjb_col3;
    }

    public String getTjdisanjb_col6() {
        return tjdisanjb_col6;
    }

    public void setTjdisanjb_col6(String tjdisanjb_col6) {
        this.tjdisanjb_col6 = tjdisanjb_col6;
    }

    public String getTjdisanjb_col7() {
        return tjdisanjb_col7;
    }

    public void setTjdisanjb_col7(String tjdisanjb_col7) {
        this.tjdisanjb_col7 = tjdisanjb_col7;
    }

    public String getTjdisanjb_col8() {
        return tjdisanjb_col8;
    }

    public void setTjdisanjb_col8(String tjdisanjb_col8) {
        this.tjdisanjb_col8 = tjdisanjb_col8;
    }


    public String getTjdisanjb_col10() {
        return tjdisanjb_col10;
    }

    public void setTjdisanjb_col10(String tjdisanjb_col10) {
        this.tjdisanjb_col10 = tjdisanjb_col10;
    }

    public String getTjdisanjb_col11() {
        return tjdisanjb_col11;
    }

    public void setTjdisanjb_col11(String tjdisanjb_col11) {
        this.tjdisanjb_col11 = tjdisanjb_col11;
    }

    public String getTjdisanjb_col12() {
        return tjdisanjb_col12;
    }

    public void setTjdisanjb_col12(String tjdisanjb_col12) {
        this.tjdisanjb_col12 = tjdisanjb_col12;
    }

    public String getTjdisanjb_col13() {
        return tjdisanjb_col13;
    }

    public void setTjdisanjb_col13(String tjdisanjb_col13) {
        this.tjdisanjb_col13 = tjdisanjb_col13;
    }

    public String getTjdisanjb_col14() {
        return tjdisanjb_col14;
    }

    public void setTjdisanjb_col14(String tjdisanjb_col14) {
        this.tjdisanjb_col14 = tjdisanjb_col14;
    }

    public String getTjdisanjb_col15() {
        return tjdisanjb_col15;
    }

    public void setTjdisanjb_col15(String tjdisanjb_col15) {
        this.tjdisanjb_col15 = tjdisanjb_col15;
    }

    public String getTjdisanjb_col16() {
        return tjdisanjb_col16;
    }

    public void setTjdisanjb_col16(String tjdisanjb_col16) {
        this.tjdisanjb_col16 = tjdisanjb_col16;
    }

    public String getTjdisanjb_col17() {
        return tjdisanjb_col17;
    }

    public void setTjdisanjb_col17(String tjdisanjb_col17) {
        this.tjdisanjb_col17 = tjdisanjb_col17;
    }

    public String getTjdisanjb_col18() {
        return tjdisanjb_col18;
    }

    public void setTjdisanjb_col18(String tjdisanjb_col18) {
        this.tjdisanjb_col18 = tjdisanjb_col18;
    }

    public String getTjdisanjb_col19() {
        return tjdisanjb_col19;
    }

    public void setTjdisanjb_col19(String tjdisanjb_col19) {
        this.tjdisanjb_col19 = tjdisanjb_col19;
    }

    public String getTjdisanjb_col20() {
        return tjdisanjb_col20;
    }

    public void setTjdisanjb_col20(String tjdisanjb_col20) {
        this.tjdisanjb_col20 = tjdisanjb_col20;
    }

    public String getTjdisanjb_col21() {
        return tjdisanjb_col21;
    }

    public void setTjdisanjb_col21(String tjdisanjb_col21) {
        this.tjdisanjb_col21 = tjdisanjb_col21;
    }

    public String getTjdisanjb_col22() {
        return tjdisanjb_col22;
    }

    public void setTjdisanjb_col22(String tjdisanjb_col22) {
        this.tjdisanjb_col22 = tjdisanjb_col22;
    }

    public String getTjdisanjb_col23() {
        return tjdisanjb_col23;
    }

    public void setTjdisanjb_col23(String tjdisanjb_col23) {
        this.tjdisanjb_col23 = tjdisanjb_col23;
    }

    public String getTjdisanjb_col24() {
        return tjdisanjb_col24;
    }

    public void setTjdisanjb_col24(String tjdisanjb_col24) {
        this.tjdisanjb_col24 = tjdisanjb_col24;
    }

    public String getTjdisanjb_col25() {
        return tjdisanjb_col25;
    }

    public void setTjdisanjb_col25(String tjdisanjb_col25) {
        this.tjdisanjb_col25 = tjdisanjb_col25;
    }

    public String getTjdisanjb_col26() {
        return tjdisanjb_col26;
    }

    public void setTjdisanjb_col26(String tjdisanjb_col26) {
        this.tjdisanjb_col26 = tjdisanjb_col26;
    }

    public String getTjdisanjb_col27() {
        return tjdisanjb_col27;
    }

    public void setTjdisanjb_col27(String tjdisanjb_col27) {
        this.tjdisanjb_col27 = tjdisanjb_col27;
    }

    public String getTjdisanjb_col28() {
        return tjdisanjb_col28;
    }

    public void setTjdisanjb_col28(String tjdisanjb_col28) {
        this.tjdisanjb_col28 = tjdisanjb_col28;
    }

    public String getTjdisanjb_col29() {
        return tjdisanjb_col29;
    }

    public void setTjdisanjb_col29(String tjdisanjb_col29) {
        this.tjdisanjb_col29 = tjdisanjb_col29;
    }

    public String getTjdisanjb_col30() {
        return tjdisanjb_col30;
    }

    public void setTjdisanjb_col30(String tjdisanjb_col30) {
        this.tjdisanjb_col30 = tjdisanjb_col30;
    }

    public String getTjdisanjb_col5() {
        return tjdisanjb_col5;
    }

    public void setTjdisanjb_col5(String tjdisanjb_col5) {
        this.tjdisanjb_col5 = tjdisanjb_col5;
    }

    public String getTjdisanjbTjlxno() {
        return tjdisanjbTjlxno;
    }

    public void setTjdisanjbTjlxno(String tjdisanjbTjlxno) {
        this.tjdisanjbTjlxno = tjdisanjbTjlxno;
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
}
