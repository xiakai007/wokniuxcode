package com.woniu.chapter18_Date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.TemporalAccessor;
import java.util.Date;

public class Test01 {
	public static void main(String[] args) throws ParseException {
		//1.构造器Date()
        Date date = new Date();
        System.out.println(date);
        System.out.println(date.getTime());//date.getTime()获取毫秒数
        //根据毫秒数创建日期
        Date date2 = new Date(2597888353431l);
        System.out.println(date2);
        //java.sql.Date,防止冲突，进行全路径创建
        java.sql.Date date3 = new java.sql.Date(9597888353431l);
        System.out.println(date3);
        //util.date转换为sql.date
        java.sql.Date date4 = new java.sql.Date(
        		new Date().getTime());
        System.out.println(date4);
        System.out.println("---------1---------");
        //格式化对象，使用默认格式
        SimpleDateFormat sdf = new SimpleDateFormat();
        //格式化：日期>文本
        Date date5 = new Date();
        String strDate = sdf.format(date5);
        System.out.println(strDate);
        //格式化对象，指定格式
        SimpleDateFormat sdf2 = new SimpleDateFormat
        		("yyyy-MM-dd HH:mm:ss");
        //格式化
        String strDate2 = sdf2.format(new Date());
        System.out.println(strDate2);
        //解析
        String source = "2420-08-20 10:17:31";
        Date date6 = sdf2.parse(source);
        System.out.println(date6);
        System.out.println("---------2---------");
        //LocalDate本地日期-LocalTime本地时间-LocalDateTime本地时间和日期（最常用之一）
        //实例化，静态方法，now()
        LocalDate date7 = LocalDate.now();
        System.out.println(date7);
        LocalTime time = LocalTime.now();
        System.out.println(time);
        LocalDateTime dateTime = LocalDateTime.now();
        System.out.println(dateTime);
        //getXxx属性
        System.out.println(dateTime.getMonth());
        System.out.println(dateTime.getMonthValue());
        //withXxx属性
        LocalDateTime month = dateTime.withDayOfMonth(12);
        System.out.println("新："+month);
        System.out.println("原："+dateTime);
        //plus,加时间
        LocalDateTime plusMonths = dateTime.plusMonths(4);
        System.out.println("新："+plusMonths);
        System.out.println("原："+dateTime);
        //minus,减时间
        LocalDateTime minusHours = dateTime.minusHours(7);
        System.out.println("新："+minusHours);
        System.out.println("原："+dateTime);
        System.out.println("---------3---------");
        //瞬时instant
        Instant instant = Instant.now();
        System.out.println(instant);//英国格林威治时间，本初子午线时间
        //atOffset设置偏移量
        OffsetDateTime atOffset = instant.atOffset(ZoneOffset.ofHours(8));
        System.out.println(atOffset);
        //3.距离1970年的毫秒数
        long milli = instant.toEpochMilli();
        System.out.println(milli);
        System.out.println("---------预定义格式化、解析---------");
        //预定义格式化
        DateTimeFormatter dtf = DateTimeFormatter.ISO_DATE_TIME;
        LocalDateTime now = LocalDateTime.now();
        String format = dtf.format(now);
        System.out.println(format);
        //预定义格式化解析
        TemporalAccessor parse = dtf.parse("2020-08-20T14:17:42.531");
        System.out.println(parse);
        System.out.println("---------本地格式化、解析---------");
        //本地格式化
        DateTimeFormatter dtf2 = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.LONG);
        String format2 = dtf2.format(now);
        System.out.println(format2);
        //本地格式化解析
        TemporalAccessor parse3 = dtf2.parse("2020年8月20日 下午02时23分35秒");
        System.out.println(parse3);
        System.out.println("---------自定义格式化、解析---------");
        //自定义格式化、解析
        DateTimeFormatter ofPattern = DateTimeFormatter.
        		ofPattern("yyyy-MM-dd hh:mm:ss");
        //格式化
        String format1 = ofPattern.format(now);
        System.out.println(format1);
        //自定义格式化解析
        TemporalAccessor parse2 = ofPattern.parse("2020-08-20 02:11:22");
        System.out.println(parse2);
        
	}

}
