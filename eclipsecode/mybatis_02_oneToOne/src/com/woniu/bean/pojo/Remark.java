package com.woniu.bean.pojo;

import java.sql.Timestamp;

public class Remark {
	private Integer id;
	private Goods goods;
	private User user;
	private Integer score;
	private String content;
	private Timestamp remarktime;
	private String status;
	public Remark() {
		super();
	}
	public Remark(Integer id, Goods goods, User user, Integer score, String content, Timestamp remarktime,
			String status) {
		super();
		this.id = id;
		this.goods = goods;
		this.user = user;
		this.score = score;
		this.content = content;
		this.remarktime = remarktime;
		this.status = status;
	}
	public Remark(Goods goods, User user, Integer score, String content, Timestamp remarktime, String status) {
		super();
		this.goods = goods;
		this.user = user;
		this.score = score;
		this.content = content;
		this.remarktime = remarktime;
		this.status = status;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Goods getGoods() {
		return goods;
	}
	public void setGoods(Goods goods) {
		this.goods = goods;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Integer getScore() {
		return score;
	}
	public void setScore(Integer score) {
		this.score = score;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Timestamp getRemarktime() {
		return remarktime;
	}
	public void setRemarktime(Timestamp remarktime) {
		this.remarktime = remarktime;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Remark [id=" + id + ", goods=" + goods + ", user=" + user + ", score=" + score + ", content=" + content
				+ ", remarktime=" + remarktime + ", status=" + status + "]";
	}
	

}
