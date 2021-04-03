package com.woniu.bean.pojo;

public class Orderitem {
	private Integer id;
	private Integer orderid;
	private Integer goodsid;
	private Integer nums;
	private Double price;
	public Orderitem() {
		super();
	}
	public Orderitem(Integer id, Integer orderid, Integer goodsid, Integer nums, Double price) {
		super();
		this.id = id;
		this.orderid = orderid;
		this.goodsid = goodsid;
		this.nums = nums;
		this.price = price;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getOrderid() {
		return orderid;
	}
	public void setOrderid(Integer orderid) {
		this.orderid = orderid;
	}
	public Integer getGoodsid() {
		return goodsid;
	}
	public void setGoodsid(Integer goodsid) {
		this.goodsid = goodsid;
	}
	public Integer getNums() {
		return nums;
	}
	public void setNums(Integer nums) {
		this.nums = nums;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Orderitem [id=" + id + ", orderid=" + orderid + ", goodsid=" + goodsid + ", nums=" + nums + ", price="
				+ price + "]";
	}
    

}
