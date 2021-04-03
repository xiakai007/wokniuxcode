package com.woniu.chapter12_Extends_work_vhicle;

import java.util.Scanner;

public class Test {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String no,brand,type;
		int seatCount,days,rent;
		System.out.println("欢迎您来到蜗牛汽车租赁公司！");
		System.out.print("请输入要租赁的天数：");
		days = sc.nextInt();
		System.out.print("请输入要租赁的汽车类型（1、轿车  2、客车）：");
		String choice = sc.next();
		switch(choice) {
		case "1":
			System.out.print("请输入要租赁的汽车品牌（1、宝马    2、别克）:");
			brand = sc.next();
			System.out.print("请输入轿车的型号：");
			if(brand.equals("1")) {
				System.out.print("1.550i:");
			}else {
				System.out.print("2、商务舱GL8 3、林荫大道");
			}
			type = sc.next();
			no = "陕A01";
			System.out.print("分配给您的汽车牌号是:"+no);
			Car car = new Car(no,brand,type);
			rent = car.calRent(days);
			break;
		default:
			System.out.print("客车（金杯、金龙）\n请输入座位数：");
			seatCount = sc.nextInt();
			no = "陕A04";
            System.out.print("分配给您的汽车牌号是:"+no);
            Bus bus = new Bus(no,seatCount);
            rent = bus.calRent(days);
				break;
		}
		System.out.println("\n顾客您好！您需要支付的租赁费用是"+rent+"。");
		sc.close();
	}

}
