package com.woniu.chapter11_String;

import java.util.Scanner;

public class GoodsTest {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Goods goods = new Goods();
		System.out.print("请输入用户名：");
		String name = sc.next();
		System.out.print("请输入密码：");
		String pwd = sc.next();
		if(goods.verify(name, pwd)) {
			System.out.println("登录成功!");
			goods.show();
			System.out.print("请输入您批发的商品编号：");
			int goodNo = sc.nextInt();
			System.out.print("请输入批发数量：");
			int amount = sc.nextInt();
			goods.calPrice(goodNo, amount);
		}else {
			System.out.println("登录失败");
		}
		sc.close();
	}

}
