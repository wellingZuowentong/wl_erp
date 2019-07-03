package com.weiling.wl_erp.bean;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 作者：王怀朋
 * 日期：2019/6/21
 */
public class OkBack {
    private Integer id;
    private String pname;
    private String cname;
    private Integer backnum;
    private BigDecimal backprice;
    private String ordercode;
    private Date backtime;
    private String guige;
    private String backuser;
    private String beizhu;
    public OkBack(){}

    public OkBack(Integer id, String pname, String cname, Integer backnum, BigDecimal backprice, String ordercode, Date backtime, String guige, String backuser, String beizhu) {
        this.id = id;
        this.pname = pname;
        this.cname = cname;
        this.backnum = backnum;
        this.backprice = backprice;
        this.ordercode = ordercode;
        this.backtime = backtime;
        this.guige = guige;
        this.backuser = backuser;
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

    public String getGuige() {
        return guige;
    }

    public void setGuige(String guige) {
        this.guige = guige;
    }

    public String getBackuser() {
        return backuser;
    }

    public void setBackuser(String backuser) {
        this.backuser = backuser;
    }

    public String getBeizhu() {
        return beizhu;
    }

    public void setBeizhu(String beizhu) {
        this.beizhu = beizhu;
    }

    @Override
    public String toString() {
        return "OkBack{" +
                "id=" + id +
                ", pname='" + pname + '\'' +
                ", cname='" + cname + '\'' +
                ", backnum=" + backnum +
                ", backprice=" + backprice +
                ", ordercode='" + ordercode + '\'' +
                ", backtime=" + backtime +
                ", guige='" + guige + '\'' +
                ", backuser='" + backuser + '\'' +
                ", beizhu='" + beizhu + '\'' +
                '}';
    }
}
