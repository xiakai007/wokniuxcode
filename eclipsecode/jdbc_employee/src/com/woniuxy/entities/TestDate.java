package com.woniuxy.entities;

import java.util.Date;

public class TestDate {
	private Integer t_id;
	private String t_name;
	private Date t_date;
	public TestDate() {
		super();
	}
	public TestDate(Integer t_id, String t_name, Date t_date) {
		super();
		this.t_id = t_id;
		this.t_name = t_name;
		this.t_date = t_date;
	}
	public Integer getT_id() {
		return t_id;
	}
	public void setT_id(Integer t_id) {
		this.t_id = t_id;
	}
	public String getT_name() {
		return t_name;
	}
	public void setT_name(String t_name) {
		this.t_name = t_name;
	}
	public Date getT_date() {
		return t_date;
	}
	public void setT_date(Date t_date) {
		this.t_date = t_date;
	}
	@Override
	public String toString() {
		return "TestDate [t_id=" + t_id + ", t_name=" + t_name + ", t_date=" + t_date + "]";
	}
	


}