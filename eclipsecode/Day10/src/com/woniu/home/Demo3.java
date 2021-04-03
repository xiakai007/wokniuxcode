package com.woniu.home;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Demo3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.println("请输入日期XX月XX日XX年");
			String time = sc.next();
			SimpleDateFormat sdf1 = new SimpleDateFormat("MM月dd日yyyy年");
			try {
				Date date = sdf1.parse(time);
				SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy年MM月dd日");
				String formatDate = sdf2.format(date);
				System.out.println(formatDate);
				break;
			}catch (ParseException e) {
				System.out.println("错误");
			}
		}
		sc.close();
		
		
	}

}
