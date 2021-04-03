package com.woniu.entities;

import com.woniu.annotations.Column;

public class MySupplier {
	@Column("supp_id")
	private Integer suppId;
	@Column("supp_code")
	private String suppCode;
	@Column("supp_name")
	private String suppName;
	@Column("supp_phone")
	private String suppPhone;
	public MySupplier() {
		super();
	}
	public MySupplier(Integer suppId, String suppCode, String suppName, String suppPhone) {
		super();
		this.suppId = suppId;
		this.suppCode = suppCode;
		this.suppName = suppName;
		this.suppPhone = suppPhone;
	}
	public Integer getSuppId() {
		return suppId;
	}
	public void setSuppId(Integer suppId) {
		this.suppId = suppId;
	}
	public String getSuppCode() {
		return suppCode;
	}
	public void setSuppCode(String suppCode) {
		this.suppCode = suppCode;
	}
	public String getSuppName() {
		return suppName;
	}
	public void setSuppName(String suppName) {
		this.suppName = suppName;
	}
	public String getSuppPhone() {
		return suppPhone;
	}
	public void setSuppPhone(String suppPhone) {
		this.suppPhone = suppPhone;
	}
	@Override
	public String toString() {
		return "MySupplier [suppId=" + suppId + ", suppCode=" + suppCode + ", suppName=" + suppName + ", suppPhone="
				+ suppPhone + "]";
	}
	
    

}
