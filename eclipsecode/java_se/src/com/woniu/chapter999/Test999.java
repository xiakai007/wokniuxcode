package com.woniu.chapter999;

import java.util.Scanner;

public class Test999 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = "陕西省西安市人民政府";
		for (int i = str.length()-1; i >=0; i--) {
			char ch = str.charAt(i);
			System.out.print(ch);
		}
		System.out.println();
		sc.close();
		new A(new B());// B  A  AB
	}
}
