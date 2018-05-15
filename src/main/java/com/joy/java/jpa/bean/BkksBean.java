package com.joy.java.jpa.bean;

import com.joy.java.util.lang.MyStringUtil;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @Project: sfrzapi
 * @Package: com.joy.java.jpa.bean
 * @Author: 冯前进
 * @Date: 2018-04-18 16:53
 * @Description: TODO
 **/

/**
 * 虚拟表
 */
@Entity
public class BkksBean {
    @Id
    private String id;
    private String ks_ksno;
    private String ks_xm;
    private String ks_bmxh;
    private String ks_zkzh;
    private String ks_zjno;
    private String ks_xb;
    private String ks_lxrdh;
    private String ks_xjno;
    private String ks_sfks;
    private String ks_zw;
    private String km_no;
    private String km_mc;
    private String kscc_no;
    private String kscc_mc;
    private String kscc_kssj;
    private String kscc_jssj;
    private String kcss_no;
    private String kcss_mc;
    private String kcss_sx;
    private String kc_no;
    private String kc_mc;
    private String bmd_no;
    private String bmd_mc;
    private String ks_cjbj;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getKs_ksno() {
        return ks_ksno;
    }

    public void setKs_ksno(String ks_ksno) {
        this.ks_ksno = ks_ksno;
    }

    public String getKs_xm() {
        return ks_xm;
    }

    public void setKs_xm(String ks_xm) {
        this.ks_xm = ks_xm;
    }

    public String getKs_bmxh() {
        return ks_bmxh;
    }

    public void setKs_bmxh(String ks_bmxh) {
        this.ks_bmxh = ks_bmxh;
    }

    public String getKs_zkzh() {
        return ks_zkzh;
    }

    public void setKs_zkzh(String ks_zkzh) {
        this.ks_zkzh = ks_zkzh;
    }

    public String getKs_zjno() {
        return ks_zjno;
    }

    public void setKs_zjno(String ks_zjno) {
        this.ks_zjno = ks_zjno;
    }

    public String getKs_xb() {
        return ks_xb;
    }

    public void setKs_xb(String ks_xb) {
        this.ks_xb = ks_xb;
    }

    public String getKs_lxrdh() {
        return ks_lxrdh;
    }

    public void setKs_lxrdh(String ks_lxrdh) {
        this.ks_lxrdh = ks_lxrdh;
    }

    public String getKs_xjno() {
        return ks_xjno;
    }

    public void setKs_xjno(String ks_xjno) {
        this.ks_xjno = ks_xjno;
    }

    public String getKs_sfks() {
        return ks_sfks;
    }

    public void setKs_sfks(String ks_sfks) {
        this.ks_sfks = ks_sfks;
    }

    public String getKs_zw() {
        return ks_zw;
    }

    public void setKs_zw(String ks_zw) {
        this.ks_zw = ks_zw;
    }

    public String getKm_no() {
        return km_no;
    }

    public void setKm_no(String km_no) {
        this.km_no = km_no;
    }

    public String getKm_mc() {
        return km_mc;
    }

    public void setKm_mc(String km_mc) {
        this.km_mc = km_mc;
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

    public String getKcss_no() {
        return kcss_no;
    }

    public void setKcss_no(String kcss_no) {
        this.kcss_no = kcss_no;
    }

    public String getKcss_mc() {
        return kcss_mc;
    }

    public void setKcss_mc(String kcss_mc) {
        this.kcss_mc = kcss_mc;
    }

    public String getKcss_sx() {
        return kcss_sx;
    }

    public void setKcss_sx(String kcss_sx) {
        this.kcss_sx = kcss_sx;
    }

    public String getKc_no() {
        return kc_no;
    }

    public void setKc_no(String kc_no) {
        this.kc_no = kc_no;
    }

    public String getKc_mc() {
        return kc_mc;
    }

    public void setKc_mc(String kc_mc) {
        this.kc_mc = kc_mc;
    }

    public String getBmd_no() {
        return bmd_no;
    }

    public void setBmd_no(String bmd_no) {
        this.bmd_no = bmd_no;
    }

    public String getBmd_mc() {
        return bmd_mc;
    }

    public void setBmd_mc(String bmd_mc) {
        this.bmd_mc = bmd_mc;
    }

    public String getKs_cjbj() {
        return ks_cjbj;
    }

    public void setKs_cjbj(String ks_cjbj) {
        this.ks_cjbj = ks_cjbj;
    }

    public String toString() {
        return getNullD(ks_ksno) + "," + getNullD(ks_xm) + "," + getNullD(ks_bmxh) + "," + getNullD(ks_zkzh) + "," + getNullD(ks_zjno) + "," + getNullD(ks_xb) + "," + getNullD(ks_lxrdh) + "," + getNullD(ks_xjno) + "," + getNullD(ks_sfks) + "," +
                getNullD(ks_zw) + "," + getNullD(km_no) + "," + getNullD(km_mc) + "," + getNullD(kscc_no) + "," + getNullD(kscc_mc) + "," + getNullD(kscc_kssj) + "," + getNullD(kscc_jssj) + "," +
                getNullD(kcss_no) + "," + getNullD(kcss_mc) + "," + getNullD(kcss_sx) + "," + getNullD(kc_no) + "," + getNullD(kc_mc) + "," + getNullD(bmd_no) + "," + getNullD(bmd_mc) + "," + getNullD(ks_cjbj);
    }

    private String getNullD(String str) {
        if (MyStringUtil.isBlankMy(str)) {
            return "";
        }
        return str;
    }
}
