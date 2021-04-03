package com.woniu.bean.pojo;

import java.sql.Timestamp;

public class Cart {
	private Integer id;
	private User user;
	private Goods goods;
	private Double price;
	private Integer nums;
	private Timestamp addtime;
	public Cart() {
		super();
	}
	public Cart(Integer id, User user, Goods goods, Double price, Integer nums, Timestamp addtime) {
		super();
		this.id = id;
		this.user = user;
		this.goods = goods;
		this.price = price;
		this.nums = nums;
		this.addtime = addtime;
	}
	public Cart(User user, Goods goods, Double price, Integer nums, Timestamp addtime) {
		super();
		this.user = user;
		this.goods = goods;
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
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Goods getGoods() {
		return goods;
	}
	public void setGoods(Goods goods) {
		this.goods = goods;
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
		return "Cart [id=" + id + ", user=" + user + ", goods=" + goods + ", price=" + price + ", nums=" + nums
				+ ", addtime=" + addtime + "]";
	}
	

}
