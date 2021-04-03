package com.woniu.bean.pojo;

import java.sql.Timestamp;

public class Remark {
	private Integer id;
	private Integer goodsid;
	private Integer userid;
	private Integer score;
	private String content;
	private Timestamp remarktime;
	private String status;
	public Remark() {
		super();
	}
	public Remark(Integer id, Integer goodsid, Integer userid, Integer score, String content, Timestamp remarktime,
			String status) {
		super();
		this.id = id;
		this.goodsid = goodsid;
		this.userid = userid;
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
	public Integer getGoodsid() {
		return goodsid;
	}
	public void setGoodsid(Integer goodsid) {
		this.goodsid = goodsid;
	}
	public Integer getUserid() {
		return userid;
	}
	public void setUserid(Integer userid) {
		this.userid = userid;
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
		return "Remark [id=" + id + ", goodsid=" + goodsid + ", userid=" + userid + ", score=" + score + ", content="
				+ content + ", remarktime=" + remarktime + ", status=" + status + "]";
	}
    

}
