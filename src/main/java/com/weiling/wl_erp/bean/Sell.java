package com.weiling.wl_erp.bean;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 作者：王怀朋
 * 日期：2019/6/13
 */
public class Sell {
    private Integer id;
    private String ordercode;
    private String pname;
    private String cname;
    private Integer oksell;//销售数量
    private BigDecimal sellprice;
    private BigDecimal allprice;
    private BigDecimal overprice;
    private String guige;
    private String selluser;
    private Integer zhuangtai;
    private Date selltime;
    private String beizhu;
    public Sell(){}

    public Sell(Integer id, String ordercode, String pname, String cname, Integer oksell, BigDecimal sellprice, BigDecimal allprice, BigDecimal overprice, String guige, String selluser, Integer zhuangtai, Date selltime, String beizhu) {
        this.id = id;
        this.ordercode = ordercode;
        this.pname = pname;
        this.cname = cname;
        this.oksell = oksell;
        this.sellprice = sellprice;
        this.allprice = allprice;
        this.overprice = overprice;
        this.guige = guige;
        this.selluser = selluser;
        this.zhuangtai = zhuangtai;
        this.selltime = selltime;
        this.beizhu = beizhu;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOrdercode() {
        return ordercode;
    }

    public void setOrdercode(String ordercode) {
        this.ordercode = ordercode;
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

    public Integer getOksell() {
        return oksell;
    }

    public void setOksell(Integer oksell) {
        this.oksell = oksell;
    }

    public BigDecimal getSellprice() {
        return sellprice;
    }

    public void setSellprice(BigDecimal sellprice) {
        this.sellprice = sellprice;
    }

    public BigDecimal getAllprice() {
        return allprice;
    }

    public void setAllprice(BigDecimal allprice) {
        this.allprice = allprice;
    }

    public BigDecimal getOverprice() {
        return overprice;
    }

    public void setOverprice(BigDecimal overprice) {
        this.overprice = overprice;
    }

    public String getGuige() {
        return guige;
    }

    public void setGuige(String guige) {
        this.guige = guige;
    }

    public String getSelluser() {
        return selluser;
    }

    public void setSelluser(String selluser) {
        this.selluser = selluser;
    }

    public Integer getZhuangtai() {
        return zhuangtai;
    }

    public void setZhuangtai(Integer zhuangtai) {
        this.zhuangtai = zhuangtai;
    }

    public Date getSelltime() {
        return selltime;
    }

    public void setSelltime(Date selltime) {
        this.selltime = selltime;
    }

    public String getBeizhu() {
        return beizhu;
    }

    public void setBeizhu(String beizhu) {
        this.beizhu = beizhu;
    }

    @Override
    public String toString() {
        return "Sell{" +
                "id=" + id +
                ", ordercode='" + ordercode + '\'' +
                ", pname='" + pname + '\'' +
                ", cname='" + cname + '\'' +
                ", oksell=" + oksell +
                ", sellprice=" + sellprice +
                ", allprice=" + allprice +
                ", overprice=" + overprice +
                ", guige='" + guige + '\'' +
                ", selluser='" + selluser + '\'' +
                ", zhuangtai=" + zhuangtai +
                ", selltime=" + selltime +
                ", beizhu='" + beizhu + '\'' +
                '}';
    }
}
