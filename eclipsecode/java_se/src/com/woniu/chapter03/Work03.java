package com.woniu.chapter03;

import java.util.Scanner;

public class Work03 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入您的银行存款（万元）：");
		double deposit = sc.nextDouble();
		if(deposit >= 500) {
			System.out.println("请购买凯迪拉克");
		}else if(deposit >= 100 && deposit < 500) {
			System.out.println("请购买帕萨特");
		}
		else if(deposit >= 50 && deposit < 100) {
			System.out.println("请购买依兰特");
		}
		else if(deposit >= 10 && deposit < 50) {
			System.out.println("请购买奥托");
		}
		else {
			System.out.println("请购买捷安特");
		}
		sc.close();
	}

}
