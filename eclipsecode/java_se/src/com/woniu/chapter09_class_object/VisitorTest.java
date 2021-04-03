package com.woniu.chapter09_class_object;

import java.util.Scanner;

public class VisitorTest {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Visitor visitor = new Visitor();
		do {
			System.out.print("请输入姓名：");
			visitor.name = sc.next();
			if(visitor.name.equals("n")) {
				break;
			}
			System.out.print("请输入年龄：");
			visitor.age = sc.nextInt();
			visitor.show();
		}while(true);
		System.out.println("程序结束");
		sc.close();
	}

}
