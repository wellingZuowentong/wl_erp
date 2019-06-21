package com.weiling.wl_erp.bean;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 作者：王怀朋
 * 日期：2019/6/21
 */
public class Back {
    private Integer id;
    private String pname;
    private String cname;
    private Integer backnum;
    private BigDecimal backprice;
    private String ordercode;
    private Date backtime;
    private String backuser;
    private Integer zhuangtai;
    private String beizhu;
    public Back(){}

    public Back(Integer id, String pname, String cname, Integer backnum, BigDecimal backprice, String ordercode, Date backtime, String backuser, Integer zhuangtai, String beizhu) {
        this.id = id;
        this.pname = pname;
        this.cname = cname;
        this.backnum = backnum;
        this.backprice = backprice;
        this.ordercode = ordercode;
        this.backtime = backtime;
        this.backuser = backuser;
        this.zhuangtai = zhuangtai;
        this.beizhu = beizhu;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public Integer getBacknum() {
        return backnum;
    }

    public void setBacknum(Integer backnum) {
        this.backnum = backnum;
    }

    public BigDecimal getBackprice() {
        return backprice;
    }

    public void setBackprice(BigDecimal backprice) {
        this.backprice = backprice;
    }

    public String getOrdercode() {
        return ordercode;
    }

    public void setOrdercode(String ordercode) {
        this.ordercode = ordercode;
    }

    public Date getBacktime() {
        return backtime;
    }

    public void setBacktime(Date backtime) {
        this.backtime = backtime;
    }

    public String getBackuser() {
        return backuser;
    }

    public void setBackuser(String backuser) {
        this.backuser = backuser;
    }

    public Integer getZhuangtai() {
        return zhuangtai;
    }

    public void setZhuangtai(Integer zhuangtai) {
        this.zhuangtai = zhuangtai;
    }

    public String getBeizhu() {
        return beizhu;
    }

    public void setBeizhu(String beizhu) {
        this.beizhu = beizhu;
    }

    @Override
    public String toString() {
        return "Back{" +
                "id=" + id +
                ", pname='" + pname + '\'' +
                ", cname='" + cname + '\'' +
                ", backnum=" + backnum +
                ", backprice=" + backprice +
                ", ordercode='" + ordercode + '\'' +
                ", backtime=" + backtime +
                ", backuser='" + backuser + '\'' +
                ", zhuangtai=" + zhuangtai +
                ", beizhu='" + beizhu + '\'' +
                '}';
    }
}
