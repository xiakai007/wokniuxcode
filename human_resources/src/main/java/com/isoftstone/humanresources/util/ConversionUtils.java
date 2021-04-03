package com.isoftstone.humanresources.util;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Pattern;

import org.apache.poi.hssf.usermodel.HSSFDateUtil;

public class ConversionUtils {

	/*
	 * 是否为浮点数？double或float类型。
	 * 
	 * @param str 传入的字符串。
	 * 
	 * @return 是浮点数返回true,否则返回false。
	 */
	public static boolean isDoubleOrFloat(String str) {
		Pattern pattern = Pattern.compile("^[-\\+]?[.\\d]*$");
		return pattern.matcher(str).matches();
	}

	/**
	 * 判断邮箱格式
	 * 
	 * @param str
	 * @return
	 */
	public static boolean checkEmil(String str) {
		boolean flag = false;
		if (str.matches("\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*")) {
			flag = true;
		}
		return flag;
	}

	/**
	 * 判断日期格式字符串
	 * 
	 * @param str
	 * @return
	 */
	public static boolean checkDate(String str,String dataFormatter) {
		DateFormat format = new SimpleDateFormat(dataFormatter);
		boolean flag = false;
		try {
			format.parse(str);
			flag = true;
		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}

	/**
	 * 得到日期字符串
	 * 
	 * @param str
	 * @return
	 */
	public static String dateChange(String str,String dataformatter) {
		String time = null;
		try {
			if(StringUtil.isEmpty(str)){
				str = "";
			}
			if(checkDate(str,dataformatter)){
				time = str;
				return time;
			}
			SimpleDateFormat sdf = new SimpleDateFormat(dataformatter);
			Date date = HSSFDateUtil.getJavaDate(Double.parseDouble(str));
			time = sdf.format(date);
		} catch (Exception e) {
			time = "";
		}
		return time;
	}

	/**
	 * 通过邮箱字符串获取用户名
	 * 
	 * @param email
	 * @return
	 */
	public static String getName(String email) {
		String name = null;
		String[] names = email.split("@");
		name = names[0];
		return name;
	}

	/**
	 * 获取当前时间字符串
	 * 
	 * @return
	 */
	public static String getDate(String str) {
		String strDate = null;

		// 获得当前时间
		Date getDate;
		try {
			getDate = new SimpleDateFormat(CommonConstant.DATAFOMATTERDAY).parse(str);
			strDate = new SimpleDateFormat(CommonConstant.DATAFORMATTER).format(getDate);
		} catch (ParseException e) {
			strDate = e.toString();
		}

		// 日期转化成字符串
		return strDate;
	}

	/**
	 * 获取当前时间字符串
	 *
	 * @return
	 */
	public static String getMonthDate(String str) {
		String strDate = null;

		// 获得当前时间
		Date getDate;
		try {
			getDate = new SimpleDateFormat(CommonConstant.DATAFORMATTERMONTH).parse(str);
			strDate = new SimpleDateFormat(CommonConstant.DATAFORMATTERMONTH).format(getDate);
		} catch (ParseException e) {
			strDate = e.toString();
		}

		// 日期转化成字符串
		return strDate;
	}
	
	/**
	 * 将字符串型的数字转化成double型
	 * @param str
	 * @return
	 */
	public static double getDouble(String str){
		double dou = 0.00;
		try {
			dou = Double.parseDouble(str);
		} catch (Exception e) {
			dou = 0.00;
		}
		return dou;
	}

	/**
	 * 去掉double型小数点后的数字
	 * @param str
	 * @return
	 */
	public static Integer trimPoint(String str){
		Integer result = 0;
		try {
			String str1 = str.substring(0, str.indexOf(".")<0?str.length():str.indexOf("."));
			result = Integer.parseInt(str1);
			
		} catch (Exception e) {
			result = 0;
		}
		return result;
	}

	public static String getRandomNum(){
		Date date = new Date();
		String strDate = new SimpleDateFormat(CommonConstant.DATAFORMATTER_ALL).format(date);
		return strDate;
	}
	/*public static String pointChage(String str){
		String time;
		time = str.replace(".", "-");
		return time;
	}
	
	public static String getYear(String str){
		String year;
		year = str.substring(0,str.indexOf("-")<0?str.length():str.indexOf("-"));
		return year;
	}*/
	/*public static void main(String[] args) {
		
		System.out.println(getRandomNum());
		System.out.println("======================================================");
	}*/

	public static BigDecimal getBigDecimal(Object value) {
		BigDecimal ret = null;
		if (value != null) {
			if (value instanceof BigDecimal) {
				ret = (BigDecimal) value;
			} else if (value instanceof String) {
				ret = new BigDecimal((String) value);
			} else if (value instanceof BigInteger) {
				ret = new BigDecimal((BigInteger) value);
			} else if (value instanceof Number) {
				ret = new BigDecimal(((Number) value).doubleValue());
			} else {
				throw new ClassCastException("Not possible to coerce [" + value + "] from class " + value.getClass() + " into a BigDecimal.");
			}
		}
		return ret;
	}
}
