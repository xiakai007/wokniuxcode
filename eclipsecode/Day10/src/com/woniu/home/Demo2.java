package com.woniu.home;

import java.util.Arrays;
import java.util.Scanner;

public class Demo2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("请连续输入数字：（使用逗号分隔）");
		String str = sc.nextLine();//1,2,3,4,5,6
		String []str2 = str.split(",");//123456
		try {
			int max = Integer.parseInt(str2[0]);
			for(int i = 1;i<str2.length;i++) {
				int temp = Integer.parseInt(str2[i]);
				if(temp>max) {
					max = temp;
				}
			}
			System.out.println(Arrays.toString(str2)+"中的最大值为"+max);
//			break;
		}catch(NumberFormatException a) {
//			k.printStackTrace();//打印异常在栈中的轨迹，异常报错信息
			System.out.println("输入有误，请重新输入！");
		}
		sc.close();
	}

}
