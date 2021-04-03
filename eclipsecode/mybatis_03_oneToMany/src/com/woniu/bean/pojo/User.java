package com.woniu.bean.pojo;

import java.sql.Timestamp;
import java.util.List;

public class User {
	private Integer id;
	private String account;
	private String password;
	private String email;
	private String avatar;
	private Integer score;
	private Timestamp regtime;
	private String status;
	private List<Address> addrs;
	private List<Orders> orders;
	
	
	public List<Orders> getOrders() {
		return orders;
	}
	public void setOrders(List<Orders> orders) {
		this.orders = orders;
	}
	public List<Address> getAddrs() {
		return addrs;
	}
	public void setAddrs(List<Address> addrs) {
		this.addrs = addrs;
	}
	public User() {
		super();
	}
	public User(Integer id, String account, String password, String email, String avatar, Integer score,
			Timestamp regtime, String status) {
		super();
		this.id = id;
		this.account = account;
		this.password = password;
		this.email = email;
		this.avatar = avatar;
		this.score = score;
		this.regtime = regtime;
		this.status = status;
	}
	public User(String account, String password, String email, String avatar, Integer score, Timestamp regtime,
			String status) {
		super();
		this.account = account;
		this.password = password;
		this.email = email;
		this.avatar = avatar;
		this.score = score;
		this.regtime = regtime;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAvatar() {
		return avatar;
	}
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
	public Integer getScore() {
		return score;
	}
	public void setScore(Integer score) {
		this.score = score;
	}
	public Timestamp getRegtime() {
		return regtime;
	}
	public void setRegtime(Timestamp regtime) {
		this.regtime = regtime;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", account=" + account + ", password=" + password + ", email=" + email + ", avatar="
				+ avatar + ", score=" + score + ", regtime=" + regtime + ", status=" + status + "]";
	}
	
	
    

}
