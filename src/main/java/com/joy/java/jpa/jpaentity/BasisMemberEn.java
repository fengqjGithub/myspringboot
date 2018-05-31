package com.joy.java.jpa.jpaentity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
/**
 * @Package: com.joy.java.jpa.jpaentity
 * @Class: BasisMemberEn
 * @Author: Joy
 * @date: 2018/5/15 15:09
 * @Description: TODO
 * @Param: param
 * @ReturnType: 
 * @Exception   
 **/
@Entity
@Table(name = "basis_member")
@ApiModel(value = "用户信息")
public class BasisMemberEn implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "paymentableGenerator")
    @GenericGenerator(name = "paymentableGenerator", strategy = "identity")
    @ApiModelProperty(value = "用户id")
    private Integer memberid = null;	//用户ID (int 10)
    @Column(nullable = true)
    @ApiModelProperty(value = "区域架构id")
    private Integer member_structid = null;	//区域架构ID (int 10)
    @Column(nullable = false)
    @ApiModelProperty(value = "角色类型id")
    private Integer member_parttypeid = null;	//角色类型ID (int 10)
    @Column(nullable = false,length = 64)
    @ApiModelProperty(value = "用户编码")
    private String member_no = null;	//用户编码 (varchar 64)
    @Column(nullable = false,length = 64)
    @JsonIgnore
    private String member_alias = null;	//用户别名 (varchar 64)
    @Column(nullable = false,length = 64)
    private String member_mc = null;	//用户描述 (varchar 128)
    @Column(nullable = false,length = 64)
    @JsonIgnore
    private String member_pwd = null;	//用户密码 (varchar 64)
    @Column(nullable = true)
    @JsonIgnore
    private Integer member_pwd_request = null;	//必须修改密码 (int 10)
    @Column(nullable = true)
    @JsonIgnore
    private Integer member_pwd_reject = null;	//不能更改密码 (int 10)
    @Column(nullable = true)
    @JsonIgnore
    private Integer member_pass_alltime = null;	//用户永不过期 (int 10)
    @Column(nullable = true)
    @JsonIgnore
    private Integer member_stop = null;	//用户停用 (int 10)
    @Column(nullable = true)
    private Timestamp member_time = null;	//用户有效期 (datetime )
    @Column(nullable = true)
    @JsonIgnore
    private Integer member_del = null;	//用户可删除 (int 10)
    @Column(nullable = true)
    @JsonIgnore
    private Integer member_usbkey = null;	//启用USB_KEY (int 10)
    @Column(nullable = true,length = 128)
    @JsonIgnore
    private String member_serialnumber = null;	//USB_KEY序列号 (varchar 128)
    @Column(nullable = true,length = 32)
    @ApiModelProperty(value = "用户名")
    private String member_xm = null;	//用户姓名 (varchar 32)
    @Column(nullable = true,length = 64)
    @JsonIgnore
    private String member_zjno = null;	//证件号码 (varchar 64)
    @Column(nullable = true,length = 128)
    @JsonIgnore
    private String member_email = null;	//用户邮箱 (varchar 128)
    @Column(nullable = true,length = 255)
    @JsonIgnore
    private String member_gzdw = null;	//工作单位 (varchar 255)
    @Column(nullable = true,length = 255)
    @JsonIgnore
    private String member_address = null;	//用户住址 (varchar 255)
    @Column(nullable = true,length = 128)
    @JsonIgnore
    private String member_phone = null;	//用户电话 (varchar 128)
    @Column(nullable = true)
    @JsonIgnore
    private Integer member_online = null;	//是否在线 (int 10)
    @Column(nullable = true)
    @JsonIgnore
    private Timestamp member_logintime = null;	//登录时间 (datetime )
    @Column(nullable = true,length = 128)
    @JsonIgnore
    private String member_loginip = null;	//登录地址 (varchar 128)
    @Column(nullable = true,length = 256)
    @JsonIgnore
    private String member_parameters = null;	//用户常用参数 (varchar 256)
    @Column(nullable = true,length = 128)
    @JsonIgnore
    private Long member_pc = null;	//用户生成批次 (numeric 24)
    @Column(nullable = true)
    @JsonIgnore
    private Integer member_yhpcid = null;	//用户批次 (int 10)
    @Column(nullable = true)
    @JsonIgnore
    private Integer member_order = null;	//用户排序 (int 10)
    @Column(nullable = true,length = 128)
    @JsonIgnore
    private String member_bz = null;	//备注 (varchar 128)

    public Integer getMemberid() {
        return memberid;
    }

    public void setMemberid(Integer memberid) {
        this.memberid = memberid;
    }

    public Integer getMember_structid() {
        return member_structid;
    }

    public void setMember_structid(Integer member_structid) {
        this.member_structid = member_structid;
    }

    public Integer getMember_parttypeid() {
        return member_parttypeid;
    }

    public void setMember_parttypeid(Integer member_parttypeid) {
        this.member_parttypeid = member_parttypeid;
    }

    public String getMember_no() {
        return member_no;
    }

    public void setMember_no(String member_no) {
        this.member_no = member_no;
    }

    public String getMember_alias() {
        return member_alias;
    }

    public void setMember_alias(String member_alias) {
        this.member_alias = member_alias;
    }

    public String getMember_mc() {
        return member_mc;
    }

    public void setMember_mc(String member_mc) {
        this.member_mc = member_mc;
    }

    public String getMember_pwd() {
        return member_pwd;
    }

    public void setMember_pwd(String member_pwd) {
        this.member_pwd = member_pwd;
    }

    public Integer getMember_pwd_request() {
        return member_pwd_request;
    }

    public void setMember_pwd_request(Integer member_pwd_request) {
        this.member_pwd_request = member_pwd_request;
    }

    public Integer getMember_pwd_reject() {
        return member_pwd_reject;
    }

    public void setMember_pwd_reject(Integer member_pwd_reject) {
        this.member_pwd_reject = member_pwd_reject;
    }

    public Integer getMember_pass_alltime() {
        return member_pass_alltime;
    }

    public void setMember_pass_alltime(Integer member_pass_alltime) {
        this.member_pass_alltime = member_pass_alltime;
    }

    public Integer getMember_stop() {
        return member_stop;
    }

    public void setMember_stop(Integer member_stop) {
        this.member_stop = member_stop;
    }

    public Timestamp getMember_time() {
        return member_time;
    }

    public void setMember_time(Timestamp member_time) {
        this.member_time = member_time;
    }

    public Integer getMember_del() {
        return member_del;
    }

    public void setMember_del(Integer member_del) {
        this.member_del = member_del;
    }

    public Integer getMember_usbkey() {
        return member_usbkey;
    }

    public void setMember_usbkey(Integer member_usbkey) {
        this.member_usbkey = member_usbkey;
    }

    public String getMember_serialnumber() {
        return member_serialnumber;
    }

    public void setMember_serialnumber(String member_serialnumber) {
        this.member_serialnumber = member_serialnumber;
    }

    public String getMember_xm() {
        return member_xm;
    }

    public void setMember_xm(String member_xm) {
        this.member_xm = member_xm;
    }

    public String getMember_zjno() {
        return member_zjno;
    }

    public void setMember_zjno(String member_zjno) {
        this.member_zjno = member_zjno;
    }

    public String getMember_email() {
        return member_email;
    }

    public void setMember_email(String member_email) {
        this.member_email = member_email;
    }

    public String getMember_gzdw() {
        return member_gzdw;
    }

    public void setMember_gzdw(String member_gzdw) {
        this.member_gzdw = member_gzdw;
    }

    public String getMember_address() {
        return member_address;
    }

    public void setMember_address(String member_address) {
        this.member_address = member_address;
    }

    public String getMember_phone() {
        return member_phone;
    }

    public void setMember_phone(String member_phone) {
        this.member_phone = member_phone;
    }

    public Integer getMember_online() {
        return member_online;
    }

    public void setMember_online(Integer member_online) {
        this.member_online = member_online;
    }

    public Timestamp getMember_logintime() {
        return member_logintime;
    }

    public void setMember_logintime(Timestamp member_logintime) {
        this.member_logintime = member_logintime;
    }

    public String getMember_loginip() {
        return member_loginip;
    }

    public void setMember_loginip(String member_loginip) {
        this.member_loginip = member_loginip;
    }

    public String getMember_parameters() {
        return member_parameters;
    }

    public void setMember_parameters(String member_parameters) {
        this.member_parameters = member_parameters;
    }

    public Long getMember_pc() {
        return member_pc;
    }

    public void setMember_pc(Long member_pc) {
        this.member_pc = member_pc;
    }

    public Integer getMember_yhpcid() {
        return member_yhpcid;
    }

    public void setMember_yhpcid(Integer member_yhpcid) {
        this.member_yhpcid = member_yhpcid;
    }

    public Integer getMember_order() {
        return member_order;
    }

    public void setMember_order(Integer member_order) {
        this.member_order = member_order;
    }

    public String getMember_bz() {
        return member_bz;
    }

    public void setMember_bz(String member_bz) {
        this.member_bz = member_bz;
    }

    @Override
    public String toString() {
        return "BasisMemberEn{" +
                "memberid=" + memberid +
                ", member_structid=" + member_structid +
                ", member_parttypeid=" + member_parttypeid +
                ", member_no='" + member_no + '\'' +
                ", member_alias='" + member_alias + '\'' +
                ", member_mc='" + member_mc + '\'' +
                ", member_pwd='" + member_pwd + '\'' +
                ", member_pwd_request=" + member_pwd_request +
                ", member_pwd_reject=" + member_pwd_reject +
                ", member_pass_alltime=" + member_pass_alltime +
                ", member_stop=" + member_stop +
                ", member_time=" + member_time +
                ", member_del=" + member_del +
                ", member_usbkey=" + member_usbkey +
                ", member_serialnumber='" + member_serialnumber + '\'' +
                ", member_xm='" + member_xm + '\'' +
                ", member_zjno='" + member_zjno + '\'' +
                ", member_email='" + member_email + '\'' +
                ", member_gzdw='" + member_gzdw + '\'' +
                ", member_address='" + member_address + '\'' +
                ", member_phone='" + member_phone + '\'' +
                ", member_online=" + member_online +
                ", member_logintime=" + member_logintime +
                ", member_loginip='" + member_loginip + '\'' +
                ", member_parameters='" + member_parameters + '\'' +
                ", member_pc=" + member_pc +
                ", member_yhpcid=" + member_yhpcid +
                ", member_order=" + member_order +
                ", member_bz='" + member_bz + '\'' +
                '}';
    }


    public BasisMemberEn(Integer member_structid, Integer member_parttypeid, String member_no, String member_alias, String member_mc, String member_pwd, Integer member_pwd_request, Integer member_pwd_reject, Integer member_pass_alltime, Integer member_stop, Timestamp member_time, Integer member_del, Integer member_usbkey, String member_serialnumber, String member_xm, String member_zjno, String member_email, String member_gzdw, String member_address, String member_phone, Integer member_online, Timestamp member_logintime, String member_loginip, String member_parameters, Long member_pc, Integer member_yhpcid, Integer member_order, String member_bz) {
        this.member_structid = member_structid;
        this.member_parttypeid = member_parttypeid;
        this.member_no = member_no;
        this.member_alias = member_alias;
        this.member_mc = member_mc;
        this.member_pwd = member_pwd;
        this.member_pwd_request = member_pwd_request;
        this.member_pwd_reject = member_pwd_reject;
        this.member_pass_alltime = member_pass_alltime;
        this.member_stop = member_stop;
        this.member_time = member_time;
        this.member_del = member_del;
        this.member_usbkey = member_usbkey;
        this.member_serialnumber = member_serialnumber;
        this.member_xm = member_xm;
        this.member_zjno = member_zjno;
        this.member_email = member_email;
        this.member_gzdw = member_gzdw;
        this.member_address = member_address;
        this.member_phone = member_phone;
        this.member_online = member_online;
        this.member_logintime = member_logintime;
        this.member_loginip = member_loginip;
        this.member_parameters = member_parameters;
        this.member_pc = member_pc;
        this.member_yhpcid = member_yhpcid;
        this.member_order = member_order;
        this.member_bz = member_bz;
    }

    //用户管理信息-添加用户用
    public BasisMemberEn() {
        this.member_pass_alltime = 1;
        this.member_del = 1;
        this.member_online = 2;
        this.member_order = 1;
    }
}
