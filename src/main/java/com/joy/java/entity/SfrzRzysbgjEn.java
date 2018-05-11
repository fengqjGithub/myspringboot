package com.joy.java.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @Project: sfrzapi
 * @Package: com.hnzr.entity
 * @Author: 冯前进
 * @Date: 2018-01-25 10:18
 * @Description: TODO
 **/
@Entity
@Table(name="sfrz_rzysbgj")
public class SfrzRzysbgjEn implements Serializable{

    //联合主键
    @EmbeddedId
    private SfrzRzysbgjEnKey id;
//    private String rzysbgj_kcno ;	//考场编码 (varchar 32)
//    private String rzysbgj_zipmc ;	//压缩包名称 (varchar 128)
    private String rzysbgj_ysbdx ;	//压缩包大小 (varchar 64)
    private String rzysbgj_dbsj ;	//压缩包打包时间 (varchar 64)
    private Integer rzysbgj_jd ;	//阶段 (int 10)
    private Integer rzysbgj_clzt ;	//处理状态 (int 10) 1为已处理，2为处理异常
    private String rzysbgj_xzsj ;	//下载时间 (varchar 64)
    private String rzysbgj_scsj ;	//上传时间 (varchar 64)
    private String rzysbgj_czr ;	//操作人 (varchar 64)
    private String rzysbgj_sx ;	//属性 (varchar 255)

    public SfrzRzysbgjEnKey getId() {
        return id;
    }

    public void setId(SfrzRzysbgjEnKey id) {
        this.id = id;
    }

    public String getRzysbgj_ysbdx() {
        return rzysbgj_ysbdx;
    }

    public void setRzysbgj_ysbdx(String rzysbgj_ysbdx) {
        this.rzysbgj_ysbdx = rzysbgj_ysbdx;
    }

    public String getRzysbgj_dbsj() {
        return rzysbgj_dbsj;
    }

    public void setRzysbgj_dbsj(String rzysbgj_dbsj) {
        this.rzysbgj_dbsj = rzysbgj_dbsj;
    }

    public Integer getRzysbgj_jd() {
        return rzysbgj_jd;
    }

    public void setRzysbgj_jd(Integer rzysbgj_jd) {
        this.rzysbgj_jd = rzysbgj_jd;
    }

    public Integer getRzysbgj_clzt() {
        return rzysbgj_clzt;
    }

    public void setRzysbgj_clzt(Integer rzysbgj_clzt) {
        this.rzysbgj_clzt = rzysbgj_clzt;
    }

    public String getRzysbgj_xzsj() {
        return rzysbgj_xzsj;
    }

    public void setRzysbgj_xzsj(String rzysbgj_xzsj) {
        this.rzysbgj_xzsj = rzysbgj_xzsj;
    }

    public String getRzysbgj_scsj() {
        return rzysbgj_scsj;
    }

    public void setRzysbgj_scsj(String rzysbgj_scsj) {
        this.rzysbgj_scsj = rzysbgj_scsj;
    }

    public String getRzysbgj_czr() {
        return rzysbgj_czr;
    }

    public void setRzysbgj_czr(String rzysbgj_czr) {
        this.rzysbgj_czr = rzysbgj_czr;
    }

    public String getRzysbgj_sx() {
        return rzysbgj_sx;
    }

    public void setRzysbgj_sx(String rzysbgj_sx) {
        this.rzysbgj_sx = rzysbgj_sx;
    }
}
