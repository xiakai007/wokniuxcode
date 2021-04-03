package com.wxws.sms.management;

import com.wxws.sms.data.*;

public class CustManagement {
	/* 商品信息 */
	public Goods goods[] = new Goods[50];
	/* 会员信息 */
	public Customer customers[] = new Customer[100];
	
	public void setData(Goods[] goods, Customer[] customers) { // 如果不使用this，请把形参名改变即可
		this.goods = goods;
		this.customers = customers;
	}
	/**
	 * 返回上一级菜单
	 */
	public void returnLastMenu() {
		
	}
	/**
	 * 添加客户信息
	 */
	public void add() {
		
	}
	/**
	 * 修改客户信息
	 */
	public void modify() {
		
	}
	/**
	 * 查询客户信息
	 */
	public void search() {
		
	}
	/**
	 * 显示所有客户信息
	 */
	public void show() {
		
	}

}
