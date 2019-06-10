package com.weiling.wl_erp.bean;

import java.util.Date;

public class OutVentory {
	private Integer id;
	private String pname;
	private String cname;
	private Double outprice;
	private Integer outnum;
	private Date outdate;
	private String outuser;
	private String dutypresion;
	private String beizhu;
	public OutVentory() {
		// TODO Auto-generated constructor stub
	}

	public OutVentory(Integer id, String pname, String cname, Double outprice, Integer outnum, Date outdate, String outuser, String dutypresion, String beizhu) {
		this.id = id;
		this.pname = pname;
		this.cname = cname;
		this.outprice = outprice;
		this.outnum = outnum;
		this.outdate = outdate;
		this.outuser = outuser;
		this.dutypresion = dutypresion;
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
	public Double getOutprice() {
		return outprice;
	}
	public void setOutprice(Double outprice) {
		this.outprice = outprice;
	}
	public Integer getOutnum() {
		return outnum;
	}
	public void setOutnum(Integer outnum) {
		this.outnum = outnum;
	}
	public Date getOutdate() {
		return outdate;
	}
	public void setOutdate(Date outdate) {
		this.outdate = outdate;
	}
	public String getOutuser() {
		return outuser;
	}
	public void setOutuser(String outuser) {
		this.outuser = outuser;
	}
	public String getDutypresion() {
		return dutypresion;
	}

	public void setDutypresion(String dutypresion) {
		this.dutypresion = dutypresion;
	}
	public String getBeizhu() {
		return beizhu;
	}
	public void setBeizhu(String beizhu) {
		this.beizhu = beizhu;
	}

	@Override
	public String toString() {
		return "OutVentory{" +
				"id=" + id +
				", pname='" + pname + '\'' +
				", cname='" + cname + '\'' +
				", outprice=" + outprice +
				", outnum=" + outnum +
				", outdate=" + outdate +
				", outuser='" + outuser + '\'' +
				", dutypresion='" + dutypresion + '\'' +
				", beizhu='" + beizhu + '\'' +
				'}';
	}
}
