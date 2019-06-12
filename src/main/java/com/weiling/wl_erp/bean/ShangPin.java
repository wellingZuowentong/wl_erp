package com.weiling.wl_erp.bean;

import java.math.BigDecimal;

/**
 * 作者：王怀朋
 * 日期：2019/6/11
 * 商品表
 */
public class ShangPin {
    private Integer id;
    private String pname;
    private String cname;
    private BigDecimal sellprice;
    private Integer sellnum;
    private String guige;
    private String beizhu;

    public ShangPin(Integer id, String pname, String cname, BigDecimal sellprice, Integer sellnum, String guige, String beizhu) {
        this.id = id;
        this.pname = pname;
        this.cname = cname;
        this.sellprice = sellprice;
        this.sellnum = sellnum;
        this.guige = guige;
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

    public BigDecimal getSellprice() {
        return sellprice;
    }

    public void setSellprice(BigDecimal sellprice) {
        this.sellprice = sellprice;
    }

    public Integer getSellnum() {
        return sellnum;
    }

    public void setSellnum(Integer sellnum) {
        this.sellnum = sellnum;
    }

    public String getGuige() {
        return guige;
    }

    public void setGuige(String guige) {
        this.guige = guige;
    }

    public String getBeizhu() {
        return beizhu;
    }

    public void setBeizhu(String beizhu) {
        this.beizhu = beizhu;
    }

}
