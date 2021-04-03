package com.woniu.homework;
import java.util.Scanner;
public class Work1 {
	public static void main(String []args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入分数：");
		int score = sc.nextInt();
		if(score>=98) {
			System.out.println("张浩就能获得一个MP4作为奖励");
		}else {System.out.println("再接再厉");
	}
		sc.close();
	}
}
