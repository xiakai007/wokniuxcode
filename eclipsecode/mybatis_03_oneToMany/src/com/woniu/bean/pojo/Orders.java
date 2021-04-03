package com.woniu.bean.pojo;

import java.sql.Timestamp;

public class Orders {
	private Integer id;
	private String orderno;
	private Integer userid;
	private Timestamp ordertime;
	private String accept;
	private String telphone;
	private String address;
	private Double money;
	private String paytype;
	private Timestamp paytime;
	private String status;
	public Orders() {
		super();
	}
	public Orders(Integer id, String orderno, Integer userid, Timestamp ordertime, String accept, String telphone,
			String address, Double money, String paytype, Timestamp paytime, String status) {
		super();
		this.id = id;
		this.orderno = orderno;
		this.userid = userid;
		this.ordertime = ordertime;
		this.accept = accept;
		this.telphone = telphone;
		this.address = address;
		this.money = money;
		this.paytype = paytype;
		this.paytime = paytime;
		this.status = status;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getOrderno() {
		return orderno;
	}
	public void setOrderno(String orderno) {
		this.orderno = orderno;
	}
	public Integer getUserid() {
		return userid;
	}
	public void setUserid(Integer userid) {
		this.userid = userid;
	}
	public Timestamp getOrdertime() {
		return ordertime;
	}
	public void setOrdertime(Timestamp ordertime) {
		this.ordertime = ordertime;
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Double getMoney() {
		return money;
	}
	public void setMoney(Double money) {
		this.money = money;
	}
	public String getPaytype() {
		return paytype;
	}
	public void setPaytype(String paytype) {
		this.paytype = paytype;
	}
	public Timestamp getPaytime() {
		return paytime;
	}
	public void setPaytime(Timestamp paytime) {
		this.paytime = paytime;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Orders [id=" + id + ", orderno=" + orderno + ", userid=" + userid + ", ordertime=" + ordertime
				+ ", accept=" + accept + ", telphone=" + telphone + ", address=" + address + ", money=" + money
				+ ", paytype=" + paytype + ", paytime=" + paytime + ", status=" + status + "]";
	}
    

}
