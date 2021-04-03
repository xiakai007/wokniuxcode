package com.woniu.entities;

public class Users {
	private Integer user_id;
	private String user_name;
	private String user_pwd;
	private String user_role;
	private String user_status;
	public Users() {
		super();
	}
	public Users(Integer user_id, String user_name, String user_pwd, String user_role, String user_status) {
		super();
		this.user_id = user_id;
		this.user_name = user_name;
		this.user_pwd = user_pwd;
		this.user_role = user_role;
		this.user_status = user_status;
	}
	
	public Users(Integer user_id, String user_name) {
		super();
		this.user_id = user_id;
		this.user_name = user_name;
	}
	public Users(String user_name, String user_pwd) {
		super();
		this.user_name = user_name;
		this.user_pwd = user_pwd;
	}
	public Integer getUser_id() {
		return user_id;
	}
	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getUser_pwd() {
		return user_pwd;
	}
	public void setUser_pwd(String user_pwd) {
		this.user_pwd = user_pwd;
	}
	public String getUser_role() {
		return user_role;
	}
	public void setUser_role(String user_role) {
		this.user_role = user_role;
	}
	public String getUser_status() {
		return user_status;
	}
	public void setUser_status(String user_status) {
		this.user_status = user_status;
	}
	@Override
	public String toString() {
		return "Users [user_id=" + user_id + ", user_name=" + user_name + ", user_pwd=" + user_pwd + ", user_role="
				+ user_role + ", user_status=" + user_status + "]";
	}
	


}
