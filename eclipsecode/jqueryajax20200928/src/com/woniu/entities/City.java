package com.woniu.entities;

public class City {
	private Integer city_id;
	private String city_name;
	private Integer prov_id;
	public City() {
		super();
	}
	
	public City(Integer city_id, String city_name) {
		super();
		this.city_id = city_id;
		this.city_name = city_name;
	}

	public City(Integer city_id, String city_name, Integer prov_id) {
		super();
		this.city_id = city_id;
		this.city_name = city_name;
		this.prov_id = prov_id;
	}
	public Integer getCity_id() {
		return city_id;
	}
	public void setCity_id(Integer city_id) {
		this.city_id = city_id;
	}
	public String getCity_name() {
		return city_name;
	}
	public void setCity_name(String city_name) {
		this.city_name = city_name;
	}
	public Integer getProv_id() {
		return prov_id;
	}
	public void setProv_id(Integer prov_id) {
		this.prov_id = prov_id;
	}
	@Override
	public String toString() {
		return "City [city_id=" + city_id + ", city_name=" + city_name + ", prov_id=" + prov_id + "]";
	}
    

}
