package com.woniu.chapter08_01doubleForLoop;

import java.util.Scanner;

public class ForDemo09_maiYiFu {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int count = 0;
		for (int i = 0; i < 5; i++) {
			System.out.println("欢迎光临第" + (i + 1) + "家专卖店");
			int count2 = 0;
			for (int j = 0; j < 3; j++) {
				count2++;
				System.out.print("要离开吗（y/n）？");
				String answer = sc.next();
				if (answer.equals("y")) {
					System.out.println("离店结账" + "\n");
					break;
				} else {
					System.out.println("买了一件衣服");
					count++;
				}
				if (count2 == 3) {
					System.out.println("3次买衣服机会已用完!\n");
				}
			}
		}
		System.out.println("总共买了" + count + "件衣服");
		sc.close();
	}

}
