package com.weiling.wl_erp.bean;

public class Client {
	private Integer id;
	private String cname;
	public Client() {
		// TODO Auto-generated constructor stub
	}
	public Client(Integer id, String cname) {
		this.id = id;
		this.cname = cname;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	@Override
	public String toString() {
		return "Client [id=" + id + ", cname=" + cname + "]";
	}

}
