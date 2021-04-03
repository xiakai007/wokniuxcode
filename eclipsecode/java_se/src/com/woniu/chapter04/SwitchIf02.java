package com.woniu.chapter04;

import java.util.Scanner;

public class SwitchIf02 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入消费金额：");
		double money = sc.nextDouble();
		System.out.println("是否参加优惠换购活动：");
		System.out.println("1.满50元，加2元换购百事可乐饮料1瓶");
		System.out.println("2.满100元，加3元换购500ml可乐一瓶");
		System.out.println("3.满100元，加10元换购5公斤面粉");
		System.out.println("4.满200元，加10元换购1个苏泊尔炒菜锅");
		System.out.println("5.满200元，加20元换购欧莱雅爽肤水一瓶");
		System.out.println("0.不换购");
		System.out.print("请选择：");
		double sumMoney;
//		int addMoney;
		if(!sc.hasNextDouble()) {
			System.out.println("请输入正确的数字！");
//			return;
		}
		int choose = sc.nextInt();
		if(money >= 0 && money < 50) {
			switch(choose) {
			case 0:
				System.out.println("本次消费总金额：" + money);
				System.out.println("不换购");
				break;
			default:
				System.out.println("本次消费总金额：" + money);
				System.out.println("消费金额不足，无法享受其他的加钱换购优惠活动！");
			}
		}else if(money >= 50 && money < 100) {
			switch(choose) {
			case 0:
				System.out.println("本次消费总金额：" + money);
				System.out.println("不换购");
				break;
			case 1:
//				 addMoney = 2;
//				System.out.println("本次消费总金额：" + sumMoney);
				System.out.println("成功换购：1瓶百事可乐饮料。");
				break;
			default:
				System.out.println("本次消费总金额：" + money);
				System.out.println("消费金额不足，无法享受其他的加钱换购优惠活动！");
			}
		}else if(money >= 100 && money <200) {
			switch(choose) {
			case 0:
				System.out.println("本次消费总金额：" + money);
				System.out.println("不换购");
				break;
			case 1:
//				 addMoney = 2;
//				System.out.println("本次消费总金额：" + sumMoney);
				System.out.println("成功换购：1瓶百事可乐饮料。");
				break;
			case 2:
//				 addMoney = 3;
//				System.out.println("本次消费总金额：" + sumMoney);
				System.out.println("成功换购：一瓶500ml可口可乐。");
				break;
			case 3:
				int addMoney2 =10;
				sumMoney = money + addMoney2;
				System.out.println("本次消费总金额：" + sumMoney);
				System.out.println("成功换购：5公斤面粉。");
				break;
			default:
				System.out.println("本次消费总金额：" + money);
				System.out.println("消费金额不足，无法享受其他的加钱换购优惠活动！");
			}
		}else if(money >= 200) {
			switch(choose) {
			case 0:
				System.out.println("本次消费总金额：" + money);
				System.out.println("不换购");
				break;
			case 1:
//				 addMoney = 2;
//				System.out.println("本次消费总金额：" + sumMoney);
				System.out.println("成功换购：1瓶百事可乐饮料。");
				break;
			case 2:
				int addMoney1 = 3;
				sumMoney = money + addMoney1;
				System.out.println("本次消费总金额：" + sumMoney);
				System.out.println("成功换购：一瓶500ml可口可乐。");
				break;
			case 3:
				int addMoney2 =10;
				sumMoney = money + addMoney2;
				System.out.println("本次消费总金额：" + sumMoney);
				System.out.println("成功换购：5公斤面粉。");
				break;
			case 4:
				int addMoney3 =10;
				sumMoney = money + addMoney3;
				System.out.println("本次消费总金额：" + sumMoney);
				System.out.println("成功换购：1个苏泊尔炒菜锅。");
				break;
			case 5:
				int addMoney4 =20;
				sumMoney = money + addMoney4;
				System.out.println("本次消费总金额：" + sumMoney);
				System.out.println("成功换购：一瓶欧莱雅爽肤水。");
				break;
			default:
				System.out.println("本次消费总金额：" + money);
				System.out.println("消费金额不足，无法享受其他的加钱换购优惠活动！");
			}
		}
		sc.close();
	}
}
