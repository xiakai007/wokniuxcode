package com.woniu.chapter03;

import java.util.Scanner;

public class Work06 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("请输入会员积分：");
		int score = sc.nextInt();
		double discount;
		if(score >= 8000) {
			discount = 0.6;
		}else if(score >= 4000 && score < 8000) {
			discount = 0.7;
		}else if(score >= 2000 && score < 4000) {
			discount = 0.8;
		}else {
			discount = 0.9;
		}
		System.out.println("该会员享受的折扣是："+discount);
		sc.close();
	}

}
