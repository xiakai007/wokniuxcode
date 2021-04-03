package com.woniu.chapter04;

import java.util.Scanner;

public class SwitchIf03 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入消费金额：");
		if(!sc.hasNextDouble()) {
			System.out.println("请输入正确的数字！");
//			return;//停止运行
		}
		double money = sc.nextDouble();
		double extra = 0;//换购金额
		int choice = 0;
		boolean flag = false;
		System.out.println("是否参加优惠换购活动：");
		System.out.println("1.满50元，加2元换购百事可乐饮料1瓶");
		System.out.println("2.满100元，加3元换购500ml可乐一瓶");
		System.out.println("3.满100元，加10元换购5公斤面粉");
		System.out.println("4.满200元，加10元换购1个苏泊尔炒菜锅");
		System.out.println("5.满200元，加20元换购欧莱雅爽肤水一瓶");
		System.out.println("0.不换购");
		System.out.print("请选择：");
		 choice = sc.nextInt();
		switch(choice){
		case 1:
			if(money>=50) {
				extra = 2;
				flag = true;
			}
			break;
		case 2:
			if(money>=100) {
				extra = 3;
				flag = true;
			}
			break;
		case 3:
			if(money>=100) {
				extra = 10;
				flag = true;
			}
			break;
		case 4:
			if(money>=200) {
				extra = 10;
				flag = true;
			}
			break;
		case 5:
			if(money>=200) {
				extra = 20;
				flag = true;
			}
			break;
		case 0:
				extra = 0;
			break;
		default:
			break;
		}
		//结账
		double total = money + extra;
		System.out.println("本次消费总金额：" + total);
		if(flag) {
			if(choice == 1){
				System.out.println("成功换购：百事可乐饮料1瓶。");
			}else if(choice ==2 ){
				System.out.println("成功换购：500ml可乐一瓶。");
			}else if(choice == 3){
				System.out.println("成功换购：5公斤面粉。");
			}else if(choice == 4){
				System.out.println("成功换购：1个苏泊尔炒菜锅。");
			}else if(choice == 5){
				System.out.println("成功换购：欧莱雅爽肤水一瓶。");
			}
		}else {
			System.out.println("无换购项目！");

	    }
		sc.close();
	}
}
