package com.weiling.wl_erp.bean;

public class Client {
	private Integer id;
	private String cname;
	private String phone;
	public Client() {
		// TODO Auto-generated constructor stub
	}

	public Client(Integer id, String cname, String phone) {
		this.id = id;
		this.cname = cname;
		this.phone = phone;
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

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "Client{" +
				"id=" + id +
				", cname='" + cname + '\'' +
				", phone='" + phone + '\'' +
				'}';
	}
}
