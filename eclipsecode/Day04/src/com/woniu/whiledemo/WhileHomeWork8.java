package com.woniu.whiledemo;
import java.util.Scanner;
public class WhileHomeWork8 {
	public static void main(String[] args) {
		int i = 1 ;
		float avg =0;
		int sum = 0;
		Scanner sc = new Scanner(System.in);
		while(i<=5) {
			System.out.println("请输入第"+i+"门课的成绩：");
			int score = sc.nextInt();
			sum += score;
			i++;
		}
		sc.close();
		avg = sum*1.0f/5;
		System.out.println(sum);
		System.out.println(avg);
		sc.close();
	}

}
