package com.woniu.chapter05;

import java.util.Random;
import java.util.Scanner;

public class WhileDemo05_practice {
	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);//自己做的
//		System.out.println("请输入100以内的整数：");
//		int num1 = sc.nextInt();
//		Random rand = new Random();
//		int num = rand.nextInt(100);
//		System.out.println("生成的随机数是："+num);
//		int count = 0;
//		while(num1!=num) {
//			if(num1>num) {
//				System.out.println("大了");
//			}else {
//				System.out.println("小了");
//			}
//			count++;
//			System.out.println("请输入100以内的整数：");
//			 num1 = sc.nextInt();
//		}
//		System.out.println("猜对了，总共猜了"+(count+1)+"次，游戏停止");//总共猜了count+1次
//		sc.close();
		
		//老师做的
		Random r = new Random();
		int num = r.nextInt(100);
		System.out.println(num);
		Scanner input = new Scanner(System.in);
		
		int count = 0;
		while(true) {
			count++; //累计
			System.out.println("请输入一个数");
			int temp = input.nextInt();
			if(temp > num) {
				System.out.println("大了");
			}else if(temp < num) {
				System.out.println("小了");
			}else {
				System.out.println("猜对了");
				break;
			}
		}
		System.out.println("count = " + count);
		input.close();

	}

}
