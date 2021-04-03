package com.woniu.chapter06_ForLoop;

import java.util.Scanner;

public class Practice05 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int count1 = 0;
		int count2 = 0;
		int num = 0;
		
		 do{
			System.out.println("请输入一个整数：");
			 num = sc.nextInt();
			if(num>0) {
				count1++;//正数个数
			}else if(num<0){
				count2++;//负数个数
			}
			else {
				System.out.println("程序结束");
//				break;//通过break跳出循环
				
			}
		}while(num!=0);
		System.out.println("正数有"+count1+"个，负数有"+count2+"个");
		sc.close();
	}

}
