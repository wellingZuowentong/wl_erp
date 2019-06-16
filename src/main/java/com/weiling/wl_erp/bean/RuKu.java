package com.weiling.wl_erp.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 作者：王怀朋
 * 日期：2019/6/11
 * 入库表
 */
public class RuKu {
    private Integer id;
    private String pname;
    private String cname;
    private BigDecimal inprice;
    private BigDecimal outprice;
    private BigDecimal sellprice;
    private Integer vnum;
    private Integer sellnum;
    private String guige;
    private Date rukutime;
    private Date updatetime;
    private String username;
    private Integer sid;
    private String beizhu;
    public RuKu(){}

    public RuKu(Integer id, String pname, String cname, BigDecimal inprice, BigDecimal outprice, BigDecimal sellprice, Integer vnum, Integer sellnum, String guige, Date rukutime, Date updatetime, String username, Integer sid, String beizhu) {
        this.id = id;
        this.pname = pname;
        this.cname = cname;
        this.inprice = inprice;
        this.outprice = outprice;
        this.sellprice = sellprice;
        this.vnum = vnum;
        this.sellnum = sellnum;
        this.guige = guige;
        this.rukutime = rukutime;
        this.updatetime = updatetime;
        this.username = username;
        this.sid = sid;
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

    public BigDecimal getInprice() {
        return inprice;
    }

    public void setInprice(BigDecimal inprice) {
        this.inprice = inprice;
    }

    public BigDecimal getOutprice() {
        return outprice;
    }

    public void setOutprice(BigDecimal outprice) {
        this.outprice = outprice;
    }

    public BigDecimal getSellprice() {
        return sellprice;
    }

    public void setSellprice(BigDecimal sellprice) {
        this.sellprice = sellprice;
    }

    public Integer getVnum() {
        return vnum;
    }

    public void setVnum(Integer vnum) {
        this.vnum = vnum;
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

    public Date getRukutime() {
        return rukutime;
    }

    public void setRukutime(Date rukutime) {
        this.rukutime = rukutime;
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public String getBeizhu() {
        return beizhu;
    }

    public void setBeizhu(String beizhu) {
        this.beizhu = beizhu;
    }

    @Override
    public String toString() {
        return "RuKu{" +
                "id=" + id +
                ", pname='" + pname + '\'' +
                ", cname='" + cname + '\'' +
                ", inprice=" + inprice +
                ", outprice=" + outprice +
                ", sellprice=" + sellprice +
                ", vnum=" + vnum +
                ", sellnum=" + sellnum +
                ", guige='" + guige + '\'' +
                ", rukutime=" + rukutime +
                ", updatetime=" + updatetime +
                ", username='" + username + '\'' +
                ", sid=" + sid +
                ", beizhu='" + beizhu + '\'' +
                '}';
    }
}
