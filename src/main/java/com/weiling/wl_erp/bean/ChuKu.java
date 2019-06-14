package com.weiling.wl_erp.bean;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 作者：王怀朋
 * 日期：2019/6/13
 * 出库信息
 */
public class ChuKu {
    private Integer id;
    private String pname;
    private String cname;
    private Integer outnum;
    private BigDecimal outprice;
    private BigDecimal outallprice;
    private String guige;
    private String outuser;
    private Integer zhuangtai;
    private Date outtime;
    private String beizhu;
    public ChuKu(){}
    public ChuKu(Integer id, String pname, String cname, Integer outnum, BigDecimal outprice, BigDecimal outallprice, String guige, String outuser, Integer zhuangtai, Date outtime, String beizhu) {
        this.id = id;
        this.pname = pname;
        this.cname = cname;
        this.outnum = outnum;
        this.outprice = outprice;
        this.outallprice = outallprice;
        this.guige = guige;
        this.outuser = outuser;
        this.zhuangtai = zhuangtai;
        this.outtime = outtime;
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

    public Integer getOutnum() {
        return outnum;
    }

    public void setOutnum(Integer outnum) {
        this.outnum = outnum;
    }

    public BigDecimal getOutprice() {
        return outprice;
    }

    public void setOutprice(BigDecimal outprice) {
        this.outprice = outprice;
    }

    public BigDecimal getOutallprice() {
        return outallprice;
    }

    public void setOutallprice(BigDecimal outallprice) {
        this.outallprice = outallprice;
    }

    public String getGuige() {
        return guige;
    }

    public void setGuige(String guige) {
        this.guige = guige;
    }

    public String getOutuser() {
        return outuser;
    }

    public void setOutuser(String outuser) {
        this.outuser = outuser;
    }

    public Integer getZhuangtai() {
        return zhuangtai;
    }

    public void setZhuangtai(Integer zhuangtai) {
        this.zhuangtai = zhuangtai;
    }

    public Date getOuttime() {
        return outtime;
    }

    public void setOuttime(Date outtime) {
        this.outtime = outtime;
    }

    public String getBeizhu() {
        return beizhu;
    }

    public void setBeizhu(String beizhu) {
        this.beizhu = beizhu;
    }

    @Override
    public String toString() {
        return "ChuKu{" +
                "id=" + id +
                ", pname='" + pname + '\'' +
                ", cname='" + cname + '\'' +
                ", outnum=" + outnum +
                ", outprice=" + outprice +
                ", outallprice=" + outallprice +
                ", guige='" + guige + '\'' +
                ", outuser='" + outuser + '\'' +
                ", zhuangtai=" + zhuangtai +
                ", outtime=" + outtime +
                ", beizhu='" + beizhu + '\'' +
                '}';
    }
}
