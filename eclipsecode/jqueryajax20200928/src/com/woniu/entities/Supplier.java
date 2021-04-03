package com.woniu.entities;

public class Supplier {
	private Integer supp_id;
	private String supp_code;
	private String supp_name;
	private String supp_phone;
	public Supplier() {
		super();
	}
	public Supplier(Integer supp_id, String supp_code, String supp_name, String supp_phone) {
		super();
		this.supp_id = supp_id;
		this.supp_code = supp_code;
		this.supp_name = supp_name;
		this.supp_phone = supp_phone;
	}
	
	public Supplier(String supp_code, String supp_name) {
		super();
		this.supp_code = supp_code;
		this.supp_name = supp_name;
	}
	public Supplier(String supp_code, String supp_name, String supp_phone) {
		super();
		this.supp_code = supp_code;
		this.supp_name = supp_name;
		this.supp_phone = supp_phone;
	}
	public Integer getSupp_id() {
		return supp_id;
	}
	public void setSupp_id(Integer supp_id) {
		this.supp_id = supp_id;
	}
	public String getSupp_code() {
		return supp_code;
	}
	public void setSupp_code(String supp_code) {
		this.supp_code = supp_code;
	}
	public String getSupp_name() {
		return supp_name;
	}
	public void setSupp_name(String supp_name) {
		this.supp_name = supp_name;
	}
	public String getSupp_phone() {
		return supp_phone;
	}
	public void setSupp_phone(String supp_phone) {
		this.supp_phone = supp_phone;
	}
	@Override
	public String toString() {
		return "Supplier [supp_id=" + supp_id + ", supp_code=" + supp_code + ", supp_name=" + supp_name
				+ ", supp_phone=" + supp_phone + "]";
	}
    

}
