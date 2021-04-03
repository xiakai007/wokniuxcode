package com.woniu.entities;

public class Prov {
	private Integer prov_id;
	private String prov_name;
	public Prov() {
		super();
	}
	public Prov(Integer prov_id, String prov_name) {
		super();
		this.prov_id = prov_id;
		this.prov_name = prov_name;
	}
	public Integer getProv_id() {
		return prov_id;
	}
	public void setProv_id(Integer prov_id) {
		this.prov_id = prov_id;
	}
	public String getProv_name() {
		return prov_name;
	}
	public void setProv_name(String prov_name) {
		this.prov_name = prov_name;
	}
	@Override
	public String toString() {
		return "Prov [prov_id=" + prov_id + ", prov_name=" + prov_name + "]";
	}
    

}
