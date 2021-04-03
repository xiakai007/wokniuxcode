package com.wxws.sms.management;

import com.wxws.sms.data.*;

public class Pay {
	public Goods []goods = new Goods[50];
	public Customer []customers = new Customer[100];
	
	public void setData(Goods []goods,Customer []customers) {
		this.goods = goods;
		this.customers = customers;
	}
	
	public double getDiscount() {
		double discount=0;
		return discount;
	}
	
	public void calPrice() {
		
	}

}
