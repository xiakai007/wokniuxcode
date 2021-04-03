package com.woniu.chapter05;

//2.判断给定的某个年份是否是闰年,闰年的判断规则如下：
//（1）若某个年份能被4整除但不能被100整除，则是闰年。
//（2）若某个年份能被400整除，则也是闰年。   
public class Work02 {
	public static void main(String[] args) {
		int year = 2022;
		if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
			System.out.println(year + "是闰年");
		} else {
			System.out.println(year + "是平年");
		}
	}

}
