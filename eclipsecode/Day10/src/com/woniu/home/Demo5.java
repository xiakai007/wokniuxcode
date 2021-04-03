package com.woniu.home;

import java.util.Arrays;
import java.util.Scanner;

public class Demo5 {
	public static void main(String[] args) {
		String str = "枪战占领上甘岭";
		boolean flag = str.contains("枪战");
		System.out.println(flag);
		
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入言论：");
		String str2 = sc.nextLine();
		String []sensitive = {"色情","傻逼","枪战","军火","恐怖"};
		for(int i =0;i<sensitive.length;i++) {
			if(str2.contains(sensitive[i])) {
				str2=str2.replace(sensitive[i], "***");
			}
		}
		System.out.println(str2);
		sc.close();
		
	}

}
