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
    private String order;
    private Date backtime;
    private String backuser;
    private String beizhu;

    public Back(){}

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

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
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
                ", order='" + order + '\'' +
                ", backtime=" + backtime +
                ", backuser='" + backuser + '\'' +
                ", beizhu='" + beizhu + '\'' +
                '}';
    }
}
