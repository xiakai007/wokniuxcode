package com.isoftstone.humanresources.domain.recruit;

import java.io.Serializable;

/**
 * <p>Description: [招聘管理系统人员信息表model]</p>
 * Created on 2020年03月09日
 * @author  <a href="mailto: chunwangi@isoftstone.com">wangchun</a>
 * @version 1.0 
 * Copyright (c) 2020年
 */
public class UserModel implements Serializable {

	private static final long serialVersionUID = 1L;

	private String username;
	private String realname;
	private String status;
	private String email;
	private String inbusinessline;
	private String area;
	private String cu;
	private String lastLgoinTime;
	private String userRole;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getRealname() {
		return realname;
	}

	public void setRealname(String realname) {
		this.realname = realname;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getInbusinessline() {
		return inbusinessline;
	}

	public void setInbusinessline(String inbusinessline) {
		this.inbusinessline = inbusinessline;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getCu() {
		return cu;
	}

	public void setCu(String cu) {
		this.cu = cu;
	}

	public String getLastLgoinTime() {
		return lastLgoinTime;
	}

	public void setLastLgoinTime(String lastLgoinTime) {
		this.lastLgoinTime = lastLgoinTime;
	}

	public String getUserRole() {
		return userRole;
	}

	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}
}
