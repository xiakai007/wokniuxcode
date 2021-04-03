package com.woniu.chapter02;

import java.util.Scanner;

public class Work8 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("STB的成绩是：");
		int stb = sc.nextInt();
		System.out.print("Java的成绩是：");
		int java = sc.nextInt();
		System.out.print("SQL的成绩是：");
		int sql = sc.nextInt();
		System.out.println("--------------------");
		System.out.println("STB\tJava\tSQL");
		System.out.println(stb+"\t"+java+"\t"+sql);
		System.out.println("--------------------");
		int dif = java-sql;
		float avg= (stb+java+sql)/3;
		System.out.println("Java和SQL的成绩差："+dif);
		System.out.println("3门课的平均分是："+avg);
		sc.close();
	}

}
