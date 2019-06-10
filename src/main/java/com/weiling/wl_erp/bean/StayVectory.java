package com.weiling.wl_erp.bean;

import java.util.Date;

public class StayVectory {
	private Integer id;
	private String pname;
	private String cname;
	private Double sprice;
	private Integer snum;
	private Date sdate;
	private String suser;
	private String beizhu;
	public StayVectory() {
		// TODO Auto-generated constructor stub
	}
	public StayVectory(Integer id, String pname, String cname, Double sprice, Integer snum, Date sdate, String suser,
			String beizhu) {
		this.id = id;
		this.pname = pname;
		this.cname = cname;
		this.sprice = sprice;
		this.snum = snum;
		this.sdate = sdate;
		this.suser = suser;
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
	public Double getSprice() {
		return sprice;
	}
	public void setSprice(Double sprice) {
		this.sprice = sprice;
	}
	public Integer getSnum() {
		return snum;
	}
	public void setSnum(Integer snum) {
		this.snum = snum;
	}
	public Date getSdate() {
		return sdate;
	}
	public void setSdate(Date sdate) {
		this.sdate = sdate;
	}
	public String getSuser() {
		return suser;
	}
	public void setSuser(String suser) {
		this.suser = suser;
	}
	public String getBeizhu() {
		return beizhu;
	}
	public void setBeizhu(String beizhu) {
		this.beizhu = beizhu;
	}
	@Override
	public String toString() {
		return "StayVectory [id=" + id + ", pname=" + pname + ", cname=" + cname + ", sprice=" + sprice + ", snum="
				+ snum + ", sdate=" + sdate + ", suser=" + suser + ", beizhu=" + beizhu + "]";
	}
	
}
