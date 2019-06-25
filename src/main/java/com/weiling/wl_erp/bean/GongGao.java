package com.weiling.wl_erp.bean;

import java.util.Date;

/**
 * 作者：王怀朋
 * 日期：2019/6/25
 */
public class GongGao {
    private Integer id;
    private String biaoti;
    private String neirong;
    private Date uptime;
    public GongGao(){}

    public GongGao(Integer id, String biaoti, String neirong, Date uptime) {
        this.id = id;
        this.biaoti = biaoti;
        this.neirong = neirong;
        this.uptime = uptime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBiaoti() {
        return biaoti;
    }

    public void setBiaoti(String biaoti) {
        this.biaoti = biaoti;
    }

    public String getNeirong() {
        return neirong;
    }

    public void setNeirong(String neirong) {
        this.neirong = neirong;
    }

    public Date getUptime() {
        return uptime;
    }

    public void setUptime(Date uptime) {
        this.uptime = uptime;
    }

    @Override
    public String toString() {
        return "GongGao{" +
                "id=" + id +
                ", biaoti='" + biaoti + '\'' +
                ", neirong='" + neirong + '\'' +
                ", uptime=" + uptime +
                '}';
    }
}
