package com.woniu.demo2;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateDemo {
	public static void main(String[] args) {
		//时间戳,自1970.1.1 0:0:0分开始至现在
		long time = System.currentTimeMillis();
		System.out.println(time/1000/3600/24/365);
		//检测程序耗费时间,测效率
//		Date date = new Date(2020, 7, 13,18,56,55);
		Date date = new Date();
		Calendar cal = Calendar.getInstance();
		cal.set(2021, 9, 31, 23, 56, 49);//向日历中设置时间,月份用0-11表示1-12月
		Date time2 = cal.getTime();
		System.out.println(time2);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss E");
		String formatTime2 = sdf.format(time2);
		System.out.println(formatTime2);
	}

}
