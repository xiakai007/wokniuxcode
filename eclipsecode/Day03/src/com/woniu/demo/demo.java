package com.woniu.demo;
import java.util.Scanner;
public class demo {
   public static void main(String[] args) {
	 int num = 14;
	   if(num % 2 == 0) {
		 System.out.println(num+"是偶数");
	 }else {
		 System.out.println(num+"是奇数");
	 }
	   Scanner sc = new Scanner(System.in);
	   System.out.println("请输入一个年份：");
	   int year = sc.nextInt();
	   if(year%4==0 && year%100!=0 || year%400==0) {
		   System.out.println(year+"是闰年");
	   }else {
		   System.out.println(year+"是平年");
	   }
	   sc.close(); 
       }
	  
}
