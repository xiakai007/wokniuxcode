package com.woniu.chapter11_String;

import java.util.Scanner;

public class String05_counts {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Count count = new Count();
		System.out.print("请输入一个字符串：");
		String words = sc.next();
		System.out.print("请输入要查找的字符：");
		String word = sc.next();
		System.out.println("“"+words+"”"+"包含"+
		count.counter(words, word)+"个"+
				"“"+word+"”。");
		sc.close();
	}

}
