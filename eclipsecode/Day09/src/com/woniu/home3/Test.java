package com.woniu.home3;

import java.util.Random;
import java.util.Scanner;

public class Test {
	public static void main(String[] args) {
		System.out.println("-----猜拳------");
		System.out.println("1.剪刀");
		System.out.println("2.石头");
		System.out.println("3.布");
		Random rd = new Random();
		int cp = rd.nextInt(3)+1;
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入您的猜拳选项：");
		int pl = sc.nextInt();
		System.out.println("电脑出的猜拳是："+cp);
		if(pl ==1 && cp ==3 ||pl ==2 && cp ==1 ||pl ==3 && cp ==2) {
			System.out.println("恭喜您获胜！");
		}else if(pl ==1 && cp ==2 ||pl ==2 && cp ==3 ||pl ==3 && cp ==1) {
			System.out.println("很遗憾，您输了");
		}else if(cp == pl) {
			System.out.println("你们是平局!");
		}
		sc.close();
	}

}
