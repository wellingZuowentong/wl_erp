package com.weiling.wl_erp.bean;

import java.util.Date;

public class Back {
	private Integer id;
	private String pname;
	private String cname;
	private Double bprice;
	private Integer bnum;
	private Date bdate;
	private String buser;
	private String beizhu;
	public Back() {
		//测试g i t
	}
	public Back(Integer id, String pname, String cname, Double bprice, Integer bnum, Date bdate, String buser,
			String beizhu) {
		this.id = id;
		this.pname = pname;
		this.cname = cname;
		this.bprice = bprice;
		this.bnum = bnum;
		this.bdate = bdate;
		this.buser = buser;
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
	public Double getBprice() {
		return bprice;
	}
	public void setBprice(Double bprice) {
		this.bprice = bprice;
	}
	public Integer getBnum() {
		return bnum;
	}
	public void setBnum(Integer bnum) {
		this.bnum = bnum;
	}
	public Date getBdate() {
		return bdate;
	}
	public void setBdate(Date bdate) {
		this.bdate = bdate;
	}
	public String getBuser() {
		return buser;
	}
	public void setBuser(String buser) {
		this.buser = buser;
	}
	public String getBeizhu() {
		return beizhu;
	}
	public void setBeizhu(String beizhu) {
		this.beizhu = beizhu;
	}
	@Override
	public String toString() {
		return "Back [id=" + id + ", pname=" + pname + ", cname=" + cname + ", bprice=" + bprice + ", bnum=" + bnum
				+ ", bdate=" + bdate + ", buser=" + buser + ", beizhu=" + beizhu + "]";
	}
	
	

}
