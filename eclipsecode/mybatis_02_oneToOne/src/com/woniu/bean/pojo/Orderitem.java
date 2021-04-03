package com.woniu.bean.pojo;

public class Orderitem {
	private Integer id;
	private Orders orders;
	private Goods goods;
	private Integer nums;
	private Double price;
	public Orderitem() {
		super();
	}
	public Orderitem(Integer id, Orders orders, Goods goods, Integer nums, Double price) {
		super();
		this.id = id;
		this.orders = orders;
		this.goods = goods;
		this.nums = nums;
		this.price = price;
	}
	public Orderitem(Orders orders, Goods goods, Integer nums, Double price) {
		super();
		this.orders = orders;
		this.goods = goods;
		this.nums = nums;
		this.price = price;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Orders getOrders() {
		return orders;
	}
	public void setOrders(Orders orders) {
		this.orders = orders;
	}
	public Goods getGoods() {
		return goods;
	}
	public void setGoods(Goods goods) {
		this.goods = goods;
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
		return "Orderitem [id=" + id + ", orders=" + orders + ", goods=" + goods + ", nums=" + nums + ", price=" + price
				+ "]";
	}
	
}
