package com.woniu.chapter12_Extends_workT_vhicle;

import java.util.Scanner;

public class Test {
	public static void main(String[] args) {
		String no,brand,mtype,type;
		int seatCount,days,rent;
		
		Scanner sc = new Scanner(System.in);
		System.out.println("欢迎您来到汽车租赁公司!");
        System.out.print("请输入要租赁的天数：");
        days = sc.nextInt();
        System.out.print("请输入要租赁的汽车类型（1：轿车   2、客车）：");
        mtype = sc.next();
        if("1".equals(mtype)) {
        	System.out.print("请输入要租赁的汽车品牌（1、宝马    2、别克）:");
            brand = sc.next();
            System.out.print("请输入轿车的型号：");
            if("1".equals(brand)) {
            	System.out.print("1、550i:");
            }else {
            	System.out.print("2、商务舱GL8 3、林荫大道");
            }
            type = sc.next();
            no = "陕A03";
            System.out.print("分配给您的汽车牌号是:"+no);
            Car car = new Car(no,brand,type);
            rent = car.calRent(days);
        	
        }else {
//        	System.out.print("请输入要租赁的客车品牌（1.金杯、2.金龙）:");
//            brand = sc.next();
            System.out.print("客车品牌（金杯、金龙）\n请输入客车的座位数：");
            seatCount = sc.nextInt();
            no = "陕A04";
            System.out.print("分配给您的汽车牌号是:"+no);
            Bus bus = new Bus(no,seatCount);//brand,
            rent = bus.calRent(days);
        }
		System.out.println("\n顾客您好！您需要支付的租赁费用是"+rent+"。");
		sc.close();
	}

}
