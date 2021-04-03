package com.woniu.entities;

import java.io.Serializable;

public class Customers implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer cust_id;
	private String cust_name;
	public Customers() {
		super();
	}
	public Customers(Integer cust_id, String cust_name) {
		super();
		this.cust_id = cust_id;
		this.cust_name = cust_name;
	}
	public Integer getCust_id() {
		return cust_id;
	}
	public void setCust_id(Integer cust_id) {
		this.cust_id = cust_id;
	}
	public String getCust_name() {
		return cust_name;
	}
	public void setCust_name(String cust_name) {
		this.cust_name = cust_name;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "Customers [cust_id=" + cust_id + ", cust_name=" + cust_name + "]";
	}
	

}
