package com.joy.java.jpa.bean;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * @Project: sfrzapi
 * @Package: com.joy.java.jpa.bean
 * @Author: 冯前进
 * @Date: 2018-04-14 9:44
 * @Description: TODO
 **/
//虚拟表
@Entity
public class TestBean implements Serializable {
    @Id
    private Integer ksccid = null;    //场次ID (int 10)
    private String kscc_no = null;    //场次编号 (varchar 32)
    private String kscc_mc = null;    //场次名称 (varchar 64)
    private String kscc_kssj = null;    //开始时间 (varchar 64)
    private String kscc_jssj = null;    //结束时间 (varchar 64)
    private String kscc_sjms = null;    //时间描述 (varchar 64)
    private String kscc_zskssj = null;
    private String kscc_zsjssj = null;

    public Integer getKsccid() {
        return ksccid;
    }

    public void setKsccid(Integer ksccid) {
        this.ksccid = ksccid;
    }

    public String getKscc_no() {
        return kscc_no;
    }

    public void setKscc_no(String kscc_no) {
        this.kscc_no = kscc_no;
    }

    public String getKscc_mc() {
        return kscc_mc;
    }

    public void setKscc_mc(String kscc_mc) {
        this.kscc_mc = kscc_mc;
    }

    public String getKscc_kssj() {
        return kscc_kssj;
    }

    public void setKscc_kssj(String kscc_kssj) {
        this.kscc_kssj = kscc_kssj;
    }

    public String getKscc_jssj() {
        return kscc_jssj;
    }

    public void setKscc_jssj(String kscc_jssj) {
        this.kscc_jssj = kscc_jssj;
    }

    public String getKscc_sjms() {
        return kscc_sjms;
    }

    public void setKscc_sjms(String kscc_sjms) {
        this.kscc_sjms = kscc_sjms;
    }

    public String getKscc_zskssj() {
        return kscc_zskssj;
    }

    public void setKscc_zskssj(String kscc_zskssj) {
        this.kscc_zskssj = kscc_zskssj;
    }

    public String getKscc_zsjssj() {
        return kscc_zsjssj;
    }

    public void setKscc_zsjssj(String kscc_zsjssj) {
        this.kscc_zsjssj = kscc_zsjssj;
    }
}
