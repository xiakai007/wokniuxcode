package com.woniu.bean.pojo;

import java.sql.Timestamp;

public class Cart {
	private Integer id;
	private Integer userid;
	private Integer goodsid;
	private Double price;
	private Integer nums;
	private Timestamp addtime;
	public Cart() {
		super();
	}
	public Cart(Integer id, Integer userid, Integer goodsid, Double price, Integer nums, Timestamp addtime) {
		super();
		this.id = id;
		this.userid = userid;
		this.goodsid = goodsid;
		this.price = price;
		this.nums = nums;
		this.addtime = addtime;
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
	public Integer getGoodsid() {
		return goodsid;
	}
	public void setGoodsid(Integer goodsid) {
		this.goodsid = goodsid;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Integer getNums() {
		return nums;
	}
	public void setNums(Integer nums) {
		this.nums = nums;
	}
	public Timestamp getAddtime() {
		return addtime;
	}
	public void setAddtime(Timestamp addtime) {
		this.addtime = addtime;
	}
	@Override
	public String toString() {
		return "Cart [id=" + id + ", userid=" + userid + ", goodsid=" + goodsid + ", price=" + price + ", nums=" + nums
				+ ", addtime=" + addtime + "]";
	}
    

}
