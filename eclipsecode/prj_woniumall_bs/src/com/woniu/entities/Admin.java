package com.woniu.entities;

import java.sql.Timestamp;

public class Admin {
	private Integer id;
	private String account;
	private String password;
	private String role;
	private Timestamp lastlogintime;
	private String lastloginip;
	private String status;
	public Admin() {
		super();
	}
	
	public Admin(String account, String password) {
		super();
		this.account = account;
		this.password = password;
	}

	public Admin(Integer id, String account, String password, String role, Timestamp lastlogintime, String lastloginip,
			String status) {
		super();
		this.id = id;
		this.account = account;
		this.password = password;
		this.role = role;
		this.lastlogintime = lastlogintime;
		this.lastloginip = lastloginip;
		this.status = status;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public Timestamp getLastlogintime() {
		return lastlogintime;
	}
	public void setLastlogintime(Timestamp lastlogintime) {
		this.lastlogintime = lastlogintime;
	}
	public String getLastloginip() {
		return lastloginip;
	}
	public void setLastloginip(String lastloginip) {
		this.lastloginip = lastloginip;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Admin [id=" + id + ", account=" + account + ", password=" + password + ", role=" + role
				+ ", lastlogintime=" + lastlogintime + ", lastloginip=" + lastloginip + ", status=" + status + "]";
	}
	

}
