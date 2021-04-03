package com.woniu.home;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {
	/**
	 * 1.日期类型转换为字符串
	 * @param time
	 * @return
	 */
	public String format(Date time) {
		return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(time);
	}
	public Date getDate(int year,int month,int date,int hourOfDay,int minute,int second) {
		Calendar cld = Calendar.getInstance();
		cld.set(year, month-1, date, hourOfDay, minute, second);
		return cld.getTime();
	}
	public Date getDate(int year,int month,int date) {
		return getDate(year,month,date,0,0,0);
	}
	public Date getTime(int hourOfDay,int minute,int second) {
		return getDate(1970,0,01,hourOfDay,minute,second);
	}
	public static void main(String[] args) {
		DateUtil util = new DateUtil();
		Date dt = util.getDate(2020, 10, 25,12,55,54);
		String format = util.format(dt);
		System.out.println(format);
		
	}

}
