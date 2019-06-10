package com.weiling.wl_erp.bean;

import java.util.Date;

public class InVentory {
	private Integer id;
	private String pname;
	private String cname;
	private Double inprice;
	private Integer innum;
	private Date indate;
	private String inuser;
	private String beizhu;
	public InVentory(Integer id, String pname, String cname, Double inprice, Integer innum, Date indate, String inuser,
			String beizhu) {
		this.id = id;
		this.pname = pname;
		this.cname = cname;
		this.inprice = inprice;
		this.innum = innum;
		this.indate = indate;
		this.inuser = inuser;
		this.beizhu = beizhu;
	}
	public InVentory() {
		// TODO Auto-generated constructor stub
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
	public Double getInprice() {
		return inprice;
	}
	public void setInprice(Double inprice) {
		this.inprice = inprice;
	}
	public Integer getInnum() {
		return innum;
	}
	public void setInnum(Integer innum) {
		this.innum = innum;
	}
	public Date getIndate() {
		return indate;
	}
	public void setIndate(Date indate) {
		this.indate = indate;
	}
	public String getInuser() {
		return inuser;
	}
	public void setInuser(String inuser) {
		this.inuser = inuser;
	}
	public String getBeizhu() {
		return beizhu;
	}
	public void setBeizhu(String beizhu) {
		this.beizhu = beizhu;
	}
	@Override
	public String toString() {
		return "InVentory [id=" + id + ", pname=" + pname + ", cname=" + cname + ", inprice=" + inprice + ", innum="
				+ innum + ", indate=" + indate + ", inuser=" + inuser + ", beizhu=" + beizhu + "]";
	}
}
