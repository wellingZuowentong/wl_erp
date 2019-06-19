package com.weiling.wl_erp.bean;

public class User {
	private Integer id;
	private String username;
	private String password;
	private Integer qx;
	public User() {
		// TODO Auto-generated constructor stub
	}

	public User(Integer id, String username, String password, Integer qx) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.qx = qx;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
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
				", username='" + username + '\'' +
				", password='" + password + '\'' +
				", qx=" + qx +
				'}';
	}
}
