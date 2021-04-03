package com.woniu.chapter02;

import java.util.Scanner;

public class Practice03 {
	public static void main(String[] args) {
		//定义价格
		int tshirtP = 245;
		int shoeP = 570;
		int racketP = 320;
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入折扣：");
        //获取折扣
		float discount = sc.nextFloat();
		float discTshirtP = tshirtP * discount;
		float discShoeP = shoeP * discount;
		float discRacketP = racketP * discount;
		System.out.println(discTshirtP);
		System.out.println(discShoeP);
		System.out.println(discRacketP);
		//判断是否折后价是否小于100
		boolean flag1 = discTshirtP < 100;
		boolean flag2 = discShoeP < 100;
		boolean flag3 = discRacketP < 100;
		System.out.println("T恤折扣价格低于100吗？"+flag1);
		System.out.println("网球鞋折扣价格低于100吗？"+flag2);
		System.out.println("网球拍折扣价格低于100吗？"+flag3);
		sc.close();
	}

}
