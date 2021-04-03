package com.woniu.bean.pojo;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

public class Cart {
	private Integer id;
	private Integer userid;
	private Integer goodsid;
	private BigDecimal price;
	private Integer nums;
	private Timestamp addtime;
	private Goods goods;
	private User user;
	
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
	public Cart() {
		super();
	}
	public Cart(Integer id, Integer userid, Integer goodsid, BigDecimal price, Integer nums, Timestamp addtime) {
		super();
		this.id = id;
		this.userid = userid;
		this.goodsid = goodsid;
		this.price = price;
		this.nums = nums;
		this.addtime = addtime;
	}
	public Cart(Integer userid, Integer goodsid, BigDecimal price, Integer nums, Timestamp addtime) {
		super();
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
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
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
