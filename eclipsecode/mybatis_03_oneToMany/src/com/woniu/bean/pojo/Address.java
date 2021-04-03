package com.woniu.bean.pojo;

public class Address {
	private Integer id;
	private Integer userid;
	private String accept;
	private String telphone;
	private String province;
	private String city;
	private String area;
	private String address;
	private String type;
	public Address() {
		super();
	}
	public Address(Integer userid, String accept, String telphone, String province, String city, String area,
			String address, String type) {
		super();
		this.userid = userid;
		this.accept = accept;
		this.telphone = telphone;
		this.province = province;
		this.city = city;
		this.area = area;
		this.address = address;
		this.type = type;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getUserid() {
		return userid;
	}
	public void setUserid(Integer userid) {
		this.userid = userid;
	}
	public String getAccept() {
		return accept;
	}
	public void setAccept(String accept) {
		this.accept = accept;
	}
	public String getTelphone() {
		return telphone;
	}
	public void setTelphone(String telphone) {
		this.telphone = telphone;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	@Override
	public String toString() {
		return "Address [id=" + id + ", userid=" + userid + ", accept=" + accept + ", telphone=" + telphone
				+ ", province=" + province + ", city=" + city + ", area=" + area + ", address=" + address + ", type="
				+ type + "]";
	}
	
}
