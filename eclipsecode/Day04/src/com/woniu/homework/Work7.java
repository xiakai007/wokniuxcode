package com.woniu.homework;
import java.util.Scanner;
public class Work7 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入第一个整数：");
		int a = sc.nextInt();
		System.out.println("请输入第二个整数：");
		int b = sc.nextInt();
		if(a>=b) {
			int temp = a;
			a = b;
			b = temp;
		}
		System.out.println("a="+a+",b="+b);
		sc.close();
	}

}
