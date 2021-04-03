package com.woniu.entities;

import java.util.Date;

public class Instock {
	private Integer instock_id;
	private Integer user_id;
	private Integer goods_id;
	private String instock_code;
	private Date instock_time;
	private String instock_status;
	private String instock_rms;
	private Integer instock_count;
	public Instock() {
		super();
	}
	public Instock(Integer instock_id, Integer user_id, Integer goods_id, String instock_code, Date instock_time,
			String instock_status, String instock_rms, Integer instock_count) {
		super();
		this.instock_id = instock_id;
		this.user_id = user_id;
		this.goods_id = goods_id;
		this.instock_code = instock_code;
		this.instock_time = instock_time;
		this.instock_status = instock_status;
		this.instock_rms = instock_rms;
		this.instock_count = instock_count;
	}
	
	public Instock(Integer user_id, Integer goods_id, String instock_code, Date instock_time, String instock_status,
			String instock_rms, Integer instock_count) {
		super();
		this.user_id = user_id;
		this.goods_id = goods_id;
		this.instock_code = instock_code;
		this.instock_time = instock_time;
		this.instock_status = instock_status;
		this.instock_rms = instock_rms;
		this.instock_count = instock_count;
	}
	public Integer getInstock_id() {
		return instock_id;
	}
	public void setInstock_id(Integer instock_id) {
		this.instock_id = instock_id;
	}
	public Integer getUser_id() {
		return user_id;
	}
	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}
	public Integer getGoods_id() {
		return goods_id;
	}
	public void setGoods_id(Integer goods_id) {
		this.goods_id = goods_id;
	}
	public String getInstock_code() {
		return instock_code;
	}
	public void setInstock_code(String instock_code) {
		this.instock_code = instock_code;
	}
	public Date getInstock_time() {
		return instock_time;
	}
	public void setInstock_time(Date instock_time) {
		this.instock_time = instock_time;
	}
	public String getInstock_status() {
		return instock_status;
	}
	public void setInstock_status(String instock_status) {
		this.instock_status = instock_status;
	}
	public String getInstock_rms() {
		return instock_rms;
	}
	public void setInstock_rms(String instock_rms) {
		this.instock_rms = instock_rms;
	}
	public Integer getInstock_count() {
		return instock_count;
	}
	public void setInstock_count(Integer instock_count) {
		this.instock_count = instock_count;
	}
	@Override
	public String toString() {
		return "Instock [instock_id=" + instock_id + ", user_id=" + user_id + ", goods_id=" + goods_id
				+ ", instock_code=" + instock_code + ", instock_time=" + instock_time + ", instock_status="
				+ instock_status + ", instock_rms=" + instock_rms + ", instock_count=" + instock_count + "]";
	}
    

}
