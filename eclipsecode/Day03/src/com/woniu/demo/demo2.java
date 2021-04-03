package com.woniu.demo;
import java.util.Scanner;
public class demo2 {
   public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	System.out.println("请输入分数：");
	   int score = sc.nextInt();
	if(score>=90 && score<=100) {
		System.out.println(score+"A等级");
	}else if(score>=80 && score<90) {
		System.out.println(score+"B等级");
	}else if(score>=70 && score<80) {
		System.out.println(score+"C等级");
	}else if(score>=60 && score<70) {
		System.out.println(score+"D等级");
	}else if(score>=0 && score<60) {
		System.out.println(score+"E等级");
	}else {
		System.out.println(score+"不是百分制分数");
	}
	sc.close();
}
}
