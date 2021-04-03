package com.woniu.bean.pojo;

import java.sql.Timestamp;

public class User {
	private Integer userId;
	private String userAccount;
	private String userPassword;
	private String userEmail;
	private String userAvatar;
	private Integer userScore;
	private Timestamp userRegtime;
	private String userStatus;
	public User() {
		super();
	}
	public User(Integer userId, String userAccount, String userPassword, String userEmail, String userAvatar,
			Integer userScore, Timestamp userRegtime, String userStatus) {
		super();
		this.userId = userId;
		this.userAccount = userAccount;
		this.userPassword = userPassword;
		this.userEmail = userEmail;
		this.userAvatar = userAvatar;
		this.userScore = userScore;
		this.userRegtime = userRegtime;
		this.userStatus = userStatus;
	}
	public User(String userAccount, String userPassword, String userEmail, String userAvatar, Integer userScore,
			Timestamp userRegtime, String userStatus) {
		super();
		this.userAccount = userAccount;
		this.userPassword = userPassword;
		this.userEmail = userEmail;
		this.userAvatar = userAvatar;
		this.userScore = userScore;
		this.userRegtime = userRegtime;
		this.userStatus = userStatus;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getUserAccount() {
		return userAccount;
	}
	public void setUserAccount(String userAccount) {
		this.userAccount = userAccount;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getUserAvatar() {
		return userAvatar;
	}
	public void setUserAvatar(String userAvatar) {
		this.userAvatar = userAvatar;
	}
	public Integer getUserScore() {
		return userScore;
	}
	public void setUserScore(Integer userScore) {
		this.userScore = userScore;
	}
	public Timestamp getUserRegtime() {
		return userRegtime;
	}
	public void setUserRegtime(Timestamp userRegtime) {
		this.userRegtime = userRegtime;
	}
	public String getUserStatus() {
		return userStatus;
	}
	public void setUserStatus(String userStatus) {
		this.userStatus = userStatus;
	}
	@Override
	public String toString() {
		return "User [userId=" + userId + ", userAccount=" + userAccount + ", userPassword=" + userPassword
				+ ", userEmail=" + userEmail + ", userAvatar=" + userAvatar + ", userScore=" + userScore
				+ ", userRegtime=" + userRegtime + ", userStatus=" + userStatus + "]";
	}
	
    

}
