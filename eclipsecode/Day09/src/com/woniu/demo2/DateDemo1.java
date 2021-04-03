package com.woniu.demo2;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateDemo1 {
	public static void main(String[] args) {
		Date date = new Date();
		System.out.println(date);
		//日期格式化工具
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss E");
		String time =  sdf.format(date);
		System.out.println(time);
		
		String time2 = "2020/12/12 12:12:12";
		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		try {
			Date parseDate = sdf2.parse(time2);
			System.out.println(parseDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			System.out.println("日期解析错误");
		}
	}

}
