package com.wxws.sms.management;

import java.util.*;

import com.wxws.sms.data.Customer;
import com.wxws.sms.data.Goods;

public class Pay {
	/* 商品信息 */
	public Goods goods[] = new Goods[50];
	/* 会员信息 */
	public Customer customers[] = new Customer[100];

	/**
	 * 传递数据库
	 */
	public void setData(Goods[] goods, Customer[] customers) { // 如果不使用this，请把形参名改变即可
		this.goods = goods;
		this.customers = customers;
	}

	/**
	 * 计算客户的折扣数目
	 */
	public double getDiscount(int curCustNo, Customer[] customers) {
		double discount;
		int index = -1;
		for (int i = 0; i < customers.length; i++) {
			if (curCustNo == customers[i].custNo) {
				index = i;
				break;
			}
		}

		if (index == -1) {// 如果会员号不存在
			discount = -1;

		} else {

			// 判断折扣
			int curscore = customers[index].custScore;
			if (curscore < 1000) {
				discount = 0.95;
			} else if (1000 <= curscore && curscore < 2000) {
				discount = 0.9;
			} else if (2000 <= curscore && curscore < 3000) {
				discount = 0.85;
			} else if (3000 <= curscore && curscore < 4000) {
				discount = 0.8;
			} else if (4000 <= curscore && curscore < 6000) {
				discount = 0.75;
			} else if (6000 <= curscore && curscore < 8000) {
				discount = 0.7;
			} else {
				discount = 0.6;
			}
		}
		return discount;

	}

	/*
	 * 　实现购物结算以及输出购物小票
	 */
	public void calcPrice() {
		int curCustNo; // 客户号
		int goodsNo = 0; // 商品编号
		double price; // 商品价格
		String name;
		int count; // 购入数量
		String choice;
		String goodsList = ""; // 购物清单
		double total = 0; // 购物总金额
		double finalPay = 0; // 打折后需付款
		double payment; // 实际交费金额

		System.out.println("我行我素购物管理系统 > 购物结算\n\n");

		// 打印产品清单
		System.out.println("*************************************");
		System.out.println("请选择购买的商品编号：");
		for (int i = 0, p = 0; i < goods.length && null != goods[i].goodsName; i++) {
			p++;
			System.out.println(p + ": " + goods[i].goodsName + "\t");
		}
		System.out.println("*************************************\n");

		/* 进行购入结算系统 */
		Scanner input = new Scanner(System.in);
		System.out.print("\t请输入会员号：");
		curCustNo = input.nextInt();
		double discount = getDiscount(curCustNo, customers);
		if (discount == -1) {
			System.out.println("会员号输入错误。");
		} else {

			do {
				System.out.print("\t请输入商品编号："); // 数组下标+1即产品编号
				goodsNo = input.nextInt();
				System.out.print("\t请输入数目：");
				count = input.nextInt();

				// 查询单价
				price = goods[goodsNo - 1].goodsPrice;
				name = goods[goodsNo - 1].goodsName;
				total = total + price * count;

				// 连接购物清单
				goodsList = goodsList + "\n" + name + "\t" + "￥" + price
						+ "\t\t" + count + "\t\t" + "￥" + (price * count)
						+ "\t";

				System.out.print("\t是否继续（y/n）");
				choice = input.next();
			} while (choice.equals("y"));

			// 计算消费总金额
			finalPay = total * discount;

			// 打印消费清单
			System.out.println("\n");
			System.out.println("＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊消费清单＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊");
			System.out.println("物品\t\t" + "单价\t\t" + "个数\t\t" + "金额\t");
			System.out.print(goodsList);
			System.out.println("\n折扣：\t" + discount);
			System.out.println("金额总计:\t" + "￥" + finalPay);
			System.out.print("实际交费:\t￥");
			payment = input.nextDouble();
			System.out.println("找钱:\t" + "￥" + (payment - finalPay));

			// 计算获得的积分：
			int score = (int) finalPay / 100 * 3;

			// 更改会员积分
			for (int i = 0; i < customers.length; i++) {
				if (customers[i].custNo == curCustNo) {
					customers[i].custScore = customers[i].custScore + score;
					System.out.println("本次购物所获的积分是： " + score);
					break;
				}
			}
		}
		// 返回上一级菜单
		System.out.print("\n请'n'返回上一级菜单:");
		if (input.next().equals("n")) {
			Menu menu = new Menu();
			menu.setData(goods, customers);
			menu.showMainMenu();
		}

	}

}
