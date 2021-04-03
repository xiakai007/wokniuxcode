package com.woniu.chapter16_Comparable_tor;

public class Goods implements Comparable<Goods> {
	private String name;
	private double price;
	
	public Goods() {
		super();
	}
	public Goods(String name, double price) {
		super();
		this.name = name;
		this.price = price;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	@Override
	public int compareTo(Goods o) {
		//指定排序规则，价格升序
		if(this.price>o.price) {
			return 1;
		}else if(this.price==o.price) {
			//价格相等时按名称顺序升序，加负号为降序
			return this.name.compareTo(o.name);
		}else {
			return -1;
		}
//		//指定排序规则，价格升序
//		return Double.compare(this.price, o.price);
//		//指定排序规则，价格降序
//		return -Double.compare(this.price, o.price);
		
	}
	@Override
	public String toString() {
		return "Goods [name=" + name + ", price=" + price + "]";
	}
	

}
