package com.weiling.wl_erp.bean;

public class Ventory {
	private Integer id;
	private String pname;
	private String cname;
	private Double inprice;
	private Integer vnum;
	private String beizhu;
	public Ventory() {
		// TODO Auto-generated constructor stub
	}
	public Ventory(Integer id, String pname, String cname, Double inprice, Integer vnum, String beizhu) {
		this.id = id;
		this.pname = pname;
		this.cname = cname;
		this.inprice = inprice;
		this.vnum = vnum;
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
	public Double getInprice() {
		return inprice;
	}
	public void setInprice(Double inprice) {
		this.inprice = inprice;
	}
	public Integer getVnum() {
		return vnum;
	}
	public void setVnum(Integer vnum) {
		this.vnum = vnum;
	}
	public String getBeizhu() {
		return beizhu;
	}
	public void setBeizhu(String beizhu) {
		this.beizhu = beizhu;
	}
	@Override
	public String toString() {
		return "Ventory [id=" + id + ", pname=" + pname + ", cname=" + cname + ", inprice=" + inprice + ", vnum=" + vnum
				+ ", beizhu=" + beizhu + "]";
	}

}
