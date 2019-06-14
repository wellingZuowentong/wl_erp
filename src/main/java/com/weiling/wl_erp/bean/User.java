package com.weiling.wl_erp.bean;

public class User {
	private Integer id;
	private String name;
	private String password;
	private Integer qx;
	public User() {
		// TODO Auto-generated constructor stub
	}

	public User(Integer id, String name, String password, Integer qx) {
		this.id = id;
		this.name = name;
		this.password = password;
		this.qx = qx;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getQx() {
		return qx;
	}

	public void setQx(Integer qx) {
		this.qx = qx;
	}

	@Override
	public String toString() {
		return "User{" +
				"id=" + id +
				", name='" + name + '\'' +
				", password='" + password + '\'' +
				", qx=" + qx +
				'}';
	}
}
