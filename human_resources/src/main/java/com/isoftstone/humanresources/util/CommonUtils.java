package com.isoftstone.humanresources.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.lang.management.ManagementFactory;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.management.MBeanServer;
import javax.management.MBeanServerFactory;
import javax.management.ObjectName;

import org.apache.xmlbeans.impl.piccolo.io.FileFormatException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.isoftstone.humanresources.controller.UserController;
import com.sun.management.OperatingSystemMXBean;

/**
 * 公共类
 * 
 * @author WLREN
 *
 */
public class CommonUtils
{
	private final static Logger logger = LoggerFactory.getLogger(UserController.class);

	private final static BigDecimal hundred = new BigDecimal(100);

	public static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmssss");

	/**
	 * 将时间转换为int秒数
	 * 
	 * @param date
	 * @return
	 */
	public static int getTimeInMillis(Date date)
	{
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return Integer.valueOf("" + calendar.getTimeInMillis() / 1000);
	}

	/**
	 * 将当前日期转换为int秒数
	 * @return
	 */
	public static int getDateInMillis()
	{
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		cal.set(Calendar.HOUR, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		return (int) (cal.getTimeInMillis() / 1000);
	}

	/**
	 * 将时间格式字符串转换为long秒数
	 * 
	 * @param dateStr
	 * @param formater
	 * @return
	 */
	public static long getTimeInMillis(String dateStr, String formater)
	{
		if ((formater == null) || (formater.trim().equals("")))
		{
			formater = CommonConstant.DATAFORMATTER_FULL;
		}
		Date date = stringToDate(dateStr, formater);

		if (date == null)
		{
			return 0L;
		}
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return calendar.getTimeInMillis() / 1000L;
	}

	/**
	 * 将时间字符串转换为date对象
	 * 
	 * @param dateStr
	 * @param formater
	 * @return
	 */
	public static Date stringToDate(String dateStr, String formater)
	{
		Date date = null;
		if ((formater == null) || ("".equals(formater.trim())))
		{
			formater = CommonConstant.DATAFORMATTER_FULL;
		}
		SimpleDateFormat format = new SimpleDateFormat(formater);
		if (!isNotBlank(dateStr))
		{
			return date;
		}
		try
		{
			date = format.parse(dateStr);
		}
		catch (ParseException e)
		{
			e.printStackTrace();
		}
		return date;
	}

	/**
	 * 将时间格式转为时间字符串
	 * 
	 * @param date
	 * @param formatStr
	 * @return
	 */
	public static String dateToString(Date date, String formatStr)
	{
		if ((formatStr == null) || ("".equals(formatStr.trim())))
		{
			formatStr = CommonConstant.DATAFORMATTER_FULL;
		}
		return getDateStrCompact(date, formatStr);
	}

	/**
	 * 将时间格式转为时间字符串
	 * 
	 * @param date
	 * @param formater
	 * @return
	 */
	private static String getDateStrCompact(Date date, String formater)
	{
		if (date == null)
		{
			return "";
		}
		SimpleDateFormat format = new SimpleDateFormat(formater);
		String str = format.format(date);
		return str;
	}

	/**
	 * 获取当前天的0点数
	 * 
	 * @return
	 */
	public static Date getTodayStartTime()
	{
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		cal.set(Calendar.HOUR, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		return cal.getTime();
	}

	/**
	 * long 型转时间
	 * 
	 * @param dateForInt
	 * @param formatStr
	 * @return
	 */
	public static String convertIntToDateStr(long dateForInt, String formatStr)
	{
		if (dateForInt == 0L)
		{
			return "";
		}
		Date d = new Date(dateForInt * 1000L);
		if ((formatStr == null) || ("".equals(formatStr.trim())))
		{
			formatStr = "yyyy-MM-dd";
		}
		SimpleDateFormat sdf = new SimpleDateFormat(formatStr);
		return sdf.format(d);
	}

	/**
	 * 字符串是否为空
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isNotBlank(String str)
	{
		boolean isBlank = true;
		if ((str == null) || ("".equals(str.trim())))
		{
			isBlank = false;
		}
		return isBlank;
	}


	/**
	 * Double 小数转百分比
	 * 
	 * @param rate
	 * @return
	 */
	public static String convertToPercentage(double rate)
	{
		NumberFormat nf = NumberFormat.getPercentInstance();

		nf.setMinimumFractionDigits(2);

		nf.setRoundingMode(RoundingMode.HALF_UP);
		String percent = nf.format(rate);
		return percent;
	}

	/**
	 * 除法公式 a/b
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
	public static String division(Double a, Double b)
	{
		if (a.compareTo(0d) == 0 || b.compareTo(0d) == 0)
		{
			return "0.00";
		}
		return convertDoubleToStr(a / b * 100);
	}

	/**
	 * 格式化小数
	 * 
	 * @param rate
	 * @return
	 */
	public static String convertDoubleToStr(double rate)
	{
		DecimalFormat df = new DecimalFormat("#0.00");
		return df.format(rate);

	}

	/**
	 * 将对象转换为double
	 * 
	 * @param str
	 * @return
	 */
	public static double convertToDouble(Object str)
	{
		int defalut = 0;
		if ((str == null) || ("".equals(str.toString().trim())))
		{
			return defalut;
		}
		return Double.parseDouble(str.toString());
	}

	/**
	 * Object转String
	 * 
	 * @param str
	 * @return
	 */
	public static String convertToString(Object str)
	{
		String defalut = "";
		if ((str == null) || ("".equals(str.toString().trim())))
		{
			return defalut;
		}
		return str.toString();
	}

	/**
	 * Object转int
	 * 
	 * @param str
	 * @return
	 */
	public static int convertToInt(Object str)
	{
		int defalut = 0;
		if ((str == null) || ("".equals(str.toString().trim())))
		{
			return defalut;
		}
		return Integer.parseInt(str.toString());
	}

	/**
	 * Object转long
	 * 
	 * @param str
	 * @return
	 */
	public static long convertToLong(Object str)
	{
		long defalut = 0;
		if ((str == null) || ("".equals(str.toString().trim())))
		{
			return defalut;
		}
		return Long.parseLong(str.toString());
	}


	/**
	 * 获取当前月份
	 * 
	 * @return string
	 */
	public static String getCurrentMonth()
	{
		Calendar cal = Calendar.getInstance();
		int month = cal.get(Calendar.MONTH) + 1;
		return month + CommonConstant.MONTH;
	}

	/**
	 * 获取上月月份
	 * 
	 * @return string
	 */
	public static String getUpMonth()
	{
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.MONTH, cal.get(Calendar.MONTH) - 1);
		
		return new SimpleDateFormat("MM月").format(cal.getTime());
		
	}



	/**
	 * 获取每月最后一天的秒数
	 * 
	 * @return
	 */
	public static int getLastDayForMouth()
	{
		Calendar c = Calendar.getInstance();
		c.add(Calendar.MONTH, 0);
		// 设置为1号,当前日期既为本月第一天
		c.set(Calendar.DAY_OF_MONTH, c.getActualMaximum(Calendar.DAY_OF_MONTH));
		c.set(Calendar.HOUR_OF_DAY, 23);
		c.set(Calendar.MINUTE, 59);
		c.set(Calendar.SECOND, 59);
		SimpleDateFormat format = new SimpleDateFormat(CommonConstant.DATAFORMATTER_FULL);
		String last = format.format(c.getTime());

		return (int) getTimeInMillis(last, CommonConstant.DATAFORMATTER_FULL);
	}

	/**
	 * 检查传入文件类型
	 * 
	 * @param filePath
	 * @throws FileNotFoundException
	 * @throws FileFormatException
	 * @return
	 */
	public static boolean preReadCheck(String filePath)
	{
		logger.debug("start to preReadCheck");
		// 常规
		File file = new File(filePath);
		if (!file.exists())
		{
			logger.error("file not find. --> " + filePath);
			return false;
		}

		if (!(filePath.endsWith(CommonConstant.EXTENSION_XLS) || filePath.endsWith(CommonConstant.EXTENSION_XLSX)))
		{
			logger.error("file not excel type. --> " + filePath);
			return false;
		}
		logger.debug("start to preReadCheck");
		return true;
	}


	/**
	 * 将当前时间转换为int秒数
	 * @return
	 */
	public static int getTimeInMillis()
	{
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		return (int) (cal.getTimeInMillis() / 1000);
	}



	/**
	 * 根据传入的时间，获取到改时间的当月最后一天
	 * 
	 * 
	 * @param time
	 * @return
	 */
	public static int toChangeLastDayForEveryMonth(int time)
	{
		int year = Integer.parseInt(CommonUtils.convertIntToDateStr(time, "yyyy"));
		int month = Integer.parseInt(CommonUtils.convertIntToDateStr(time, "MM"));
		int day = 0;

		if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0))
		{
			if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12)
			{
				day = 31;
			}
			else if (month == 2)
			{
				day = 29;
			}
			else
			{
				day = 30;
			}
		}
		else
		{
			if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12)
			{
				day = 31;
			}
			else if (month == 2)
			{
				day = 28;
			}
			else
			{
				day = 30;
			}
		}
		if (month >= 10)
		{
			return (int) CommonUtils.getTimeInMillis(year + "年" + month + "月" + day + "日", "yyyy年MM月dd日");
		}
		return (int) CommonUtils.getTimeInMillis(year + "年0" + month + "月" + day + "日", "yyyy年MM月dd日");
	}

	/**
	 * 根据传入的时间，获取到当月的第一天的时间
	 * 
	 * @param time
	 * @return
	 */
	public static int toChangeFirstDayForEveryMonth(int time)
	{
		return (int) CommonUtils.getTimeInMillis(CommonUtils.convertIntToDateStr(time, "yyyy-MM") + "-01",
		        "yyyy-MM-dd");
	}


	/**
	 * 获取当前时间往前推12个月的所有月份
	 * 
	 * 
	 * @return
	 */
	public static List<String> getAllYearAndMonth(boolean isChinese)
	{
		int now = getDateInMillis();
		int year = Integer.parseInt(convertIntToDateStr(now, "yyyy"));
		int month = Integer.parseInt(convertIntToDateStr(now, "MM"));
		List<String> allList = new ArrayList<>();
		sumYearAndMonth(year, month, allList, isChinese);
		Collections.sort(allList);
		return allList;
	}

	private static void sumYearAndMonth(int year, int month, List<String> allList, boolean isChinese)
	{
		for (int i = month; i > 0; i--)
		{
			if (isChinese)
			{
				if (month >= 10)
				{
					allList.add(year + "年" + month + "月");
				}
				else
				{
					allList.add(year + "年0" + month + "月");
				}
			}
			else
			{
				if (month >= 10)
				{
					allList.add(year + "-" + month);
				}
				else
				{
					allList.add(year + "-0" + month);
				}
			}

			month--;
			if (allList.size() == 12)
			{
				break;
			}
			if (month == 0)
			{
				sumYearAndMonth(year - 1, 12, allList, isChinese);
			}
		}
	}

	/**
	 * 获取一个时间的当月第一天和最后一天时间点
	 * 
	 * 
	 * @param time
	 * @return
	 */
	public static Map<String, Integer> getMonthFirstAndLastDayTime(String time)
	{
		Map<String, Integer> map = new HashMap<>();
		int startDayTime = (int) getTimeInMillis(time + "01日", "yyyy年MM月dd日");
		int lastTDayime = toChangeLastDayForEveryMonth((int) getTimeInMillis(time, "yyyy年MM月"));
		map.put("startDayTime", Integer.valueOf(startDayTime));
		map.put("lastDayTime", Integer.valueOf(lastTDayime + 24 * 60 * 60 - 1));
		return map;
	}

	/**
	 * attence
	 * 获取一个时间的当月第一天和最后一天时间点
	 * 
	 * 
	 * @param time
	 * @return
	 */
	public static Map<String, Integer> getMonthFirstAndLastDayTimeForAttence(String time)
	{
		Map<String, Integer> map = new HashMap<>();
		int startDayTime = (int) getTimeInMillis(time + "-01", "yyyy-MM-dd");
		int lastTDayime = toChangeLastDayForEveryMonth((int) getTimeInMillis(time, "yyyy-MM"));
		map.put("startDayTime", Integer.valueOf(startDayTime));
		map.put("lastDayTime", Integer.valueOf(lastTDayime + 24 * 60 * 60 - 1));
		return map;
	}

	/**
	 * 获取一年的第一天时间和当个月的最后一天
	 * 
	 * 
	 * @param time
	 * @return
	 */
	public static Map<String, Integer> getYearFirstAndLastDayTime(String time)
	{
		Map<String, Integer> map = new HashMap<>();
		int startDayTime = getYearFirstDayTime(time);
		int lastTDayime = toChangeLastDayForEveryMonth((int) getTimeInMillis(time, "yyyy年MM月"));
		map.put("startDayTime", Integer.valueOf(startDayTime));
		map.put("lastDayTime", Integer.valueOf(lastTDayime + 24 * 60 * 60 - 1));
		return map;
	}

	private static int getYearFirstDayTime(String time)
	{
		String year = time.substring(0, 4);
		return (int) CommonUtils.getTimeInMillis(year + "-01-01", "yyyy-MM-dd");
	}





	/**
	 * 根据传入的flag，返回一个初始时间
	 * 
	 * @param flag
	 * @return
	 */
	public static Map<String, Integer> getStartTimeAndEndTimeByFlag(String flag)
	{
		Map<String, Integer> map = new HashMap<>();
		int startDayTime = 0;
		int lastTDayime = 0;
		String year = convertIntToDateStr(getDateInMillis(), "yyyy");
		if (flag.indexOf("月") == -1)
		{
			switch (flag)
			{
			case "Q1":
				startDayTime = (int) getTimeInMillis(year + "-01-01", "yyyy-MM-dd");
				lastTDayime = toChangeLastDayForEveryMonth((int) getTimeInMillis(year + "-03", "yyyy-MM"));
				break;
			case "Q2":
				startDayTime = (int) getTimeInMillis(year + "-04-01", "yyyy-MM-dd");
				lastTDayime = toChangeLastDayForEveryMonth((int) getTimeInMillis(year + "-06", "yyyy-MM"));
				break;
			case "Q3":
				startDayTime = (int) getTimeInMillis(year + "-07-01", "yyyy-MM-dd");
				lastTDayime = toChangeLastDayForEveryMonth((int) getTimeInMillis(year + "-09", "yyyy-MM"));
				break;
			case "Q4":
				startDayTime = (int) getTimeInMillis(year + "-10-01", "yyyy-MM-dd");
				lastTDayime = toChangeLastDayForEveryMonth((int) getTimeInMillis(year + "-12", "yyyy-MM"));
				break;
			case "H1":
				startDayTime = (int) getTimeInMillis(year + "-01-01", "yyyy-MM-dd");
				lastTDayime = toChangeLastDayForEveryMonth((int) getTimeInMillis(year + "-06", "yyyy-MM"));
				break;
			case "H2":
				startDayTime = (int) getTimeInMillis(year + "-07-01", "yyyy-MM-dd");
				lastTDayime = toChangeLastDayForEveryMonth((int) getTimeInMillis(year + "-12", "yyyy-MM"));
				break;
			case "全年":
				startDayTime = (int) getTimeInMillis(year + "-01-01", "yyyy-MM-dd");
				lastTDayime = toChangeLastDayForEveryMonth((int) getTimeInMillis(year + "-12", "yyyy-MM"));
				break;
			}
		}
		else
		{
			flag = flag.replace("月", "");
			startDayTime = (int) getTimeInMillis(year + "-" + flag + "-01", "yyyy-MM-dd");
			lastTDayime = toChangeLastDayForEveryMonth((int) getTimeInMillis(year + "-" + flag, "yyyy-MM"));
		}
		map.put("startDayTime", Integer.valueOf(startDayTime));
		map.put("lastDayTime", Integer.valueOf(lastTDayime + 24 * 60 * 60 - 1));
		return map;
	}

	public static String decimalToPercenString(BigDecimal decimal)
	{
		return decimal.multiply(new BigDecimal(100)).toString() + "%";
	}

	/**
	 * 根据传入等级，返回等级标志
	 * 
	 * @param leave
	 * @return
	 */
	public static String returnLevelFlag(int leave)
	{
		String flag = "-1Level";
		switch (leave)
		{
		case 2:
			flag = "level2";
			break;
		case 3:
			flag = "level3";
			break;
		case 4:
			flag = "level4";
			break;
		}
		return flag;
	}

	/**
	 * @param num
	 * @return
	 */
	public static String returnBigDecimal(String num)
	{
		if (num.isEmpty() || "".equals(num) || "-".equals(num))
		{
			num = "0";
		}
		return num;
	}

	/**
	 * 判断被除数==0
	 * 
	 * @param decimal
	 * @param decimal1
	 * @return
	 */
	public static BigDecimal decimal1IsZero(BigDecimal decimal, BigDecimal decimal1)
	{
		if (decimal1 == null || decimal1.compareTo(BigDecimal.ZERO) == 0)
		{
			return BigDecimal.ZERO;
		}
		else
		{
			return decimal.divide(decimal1, 4, BigDecimal.ROUND_HALF_UP);
		}
	}

	/**
	 * 设置百分比的显示值
	 * 
	 * @param decimal
	 * @return
	 */
	public static BigDecimal setDecimalPercent(BigDecimal decimal)
	{
		return decimal.multiply(hundred).setScale(2, BigDecimal.ROUND_HALF_UP);
	}

	/**
	 * 根据传入的年月获得上个月的年月
	 * 
	 * @param importDate
	 * @return
	 */
	public static String[] getYearAndMonth(String importDate)
	{
		String[] array = new String[2];

		try
		{
			Date date = CommonConstant.DATE_MONTH_FORMAT.parse(importDate);

			Calendar calendar = Calendar.getInstance();
			calendar.setTime(date);
			calendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH) - 1);

			String yearMoth = CommonConstant.DATE_MONTH_FORMAT.format(calendar.getTime());

			array = yearMoth.split("-");

		}
		catch (ParseException e)
		{
			logger.error("date parse error" + e);
		}

		return array;
	}

	
	/**
	 * 根据传入的年月获得上个月的年月
	 * 
	 * @param month
	 * @return
	 */
	public static String getLastMonth(String month)
	{

		String time = "";
		try
		{
			Date date = CommonConstant.DATE_MONTH_FORMAT.parse(month);
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(date);
			calendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH) - 1);
			time = CommonConstant.DATE_MONTH_FORMAT.format(calendar.getTime());
		}
		catch (ParseException e)
		{
			logger.error("date parse error" + e);
		}
		return time;
	}

	public static String getQuarterStrByMonth(String month)
	{
		if ("01".equals(month) || "02".equals(month) || "03".equals(month))
		{
			return "Q1";
		}
		else if ("04".equals(month) || "05".equals(month) || "06".equals(month))
		{
			return "Q2";
		}
		else if ("07".equals(month) || "08".equals(month) || "09".equals(month))
		{
			return "Q3";
		}
		else
		{
			return "Q4";
		}
	}

	/**
	 * 根据传入的年月获得前三个月的年月
	 * 
	 * @param importDate
	 * @return
	 */
	public static String[] getUpMonthByNum(String importDate, int num)
	{
		String[] array = new String[2];

		try
		{
			Date date = CommonConstant.DATE_MONTH_FORMAT.parse(importDate);

			Calendar calendar = Calendar.getInstance();
			calendar.setTime(date);
			calendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH) - num);

			String yearMoth = CommonConstant.DATE_MONTH_FORMAT.format(calendar.getTime());

			array = yearMoth.split("-");

		}
		catch (ParseException e)
		{
			logger.error("date parse error" + e);
		}

		return array;
	}
	
	/**
	 * 根据传入的年月获得前几个月的年份月份
	 * 
	 * @param importDate
	 * @return
	 */
	public static String[] getUpMonthByNum(String importDate, int num,SimpleDateFormat format)
	{
		String[] array = new String[2];

		try
		{
			Date date = format.parse(importDate);

			Calendar calendar = Calendar.getInstance();
			calendar.setTime(date);
			calendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH) - num);

			String yearMoth = format.format(calendar.getTime());

			array = yearMoth.split("-");

		}
		catch (ParseException e)
		{
			logger.error("date parse error" + e);
		}

		return array;
	}


	/**
	 * double型向上取整
	 * 
	 * @param doubles
	 * @return
	 */
	public static int getIntForDoubleCeil(Double doubles)
	{
		return (int) Math.ceil(doubles);
	}

	/**
	 * 获得当前时间的时间戳字符串
	 * 
	 * @param date
	 * @return
	 */
	public static String getTimeStr(Date date)
	{
		return dateFormat.format(date);
	}

	/**
	 * BigDecimal 精确乘法
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
	public static BigDecimal multiply(BigDecimal a, BigDecimal b)
	{
		return a.multiply(b);
	}

	/**
	 * 获得两个时间之间的间隔天赋
	 * 
	 * @param startDate
	 *            比较的时间
	 * @param currentDate
	 *            当前时间
	 * @return
	 * @throws ParseException
	 */
	public static int getBetweenDate(String startDate, String currentDate) throws ParseException
	{

		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

		Date srart = dateFormat.parse(startDate);

		Date current = dateFormat.parse(currentDate);

		Calendar calendar = Calendar.getInstance();

		calendar.setTime(srart);

		int day1 = calendar.get(Calendar.DAY_OF_YEAR);

		calendar.setTime(current);

		int day2 = calendar.get(Calendar.DAY_OF_YEAR);

		return day1 - day2;

	}

	public static String formatMoney(String s, int len)
	{
		if (s == null || s.length() < 1)
		{
			return "";
		}
		NumberFormat formater = null;
		double num = Double.parseDouble(s);
		if (len == 0)
		{
			formater = new DecimalFormat("###,###");

		}
		else
		{
			StringBuffer buff = new StringBuffer();
			buff.append("###,###.");
			for (int i = 0; i < len; i++)
			{
				buff.append("#");
			}
			formater = new DecimalFormat(buff.toString());
		}
		String result = formater.format(num);
		if (result.indexOf(".") == -1)
		{
			result = result + ".00";
		}

		return result;
	}

	public static String replaceHtml(String html, boolean flag)
	{
		if (flag)
		{
			return html.replace("<", "&lt;").replace(">", "&gt;");
		}
		else
		{
			return html.replace("&lt;", "<").replace("&gt;", ">");
		}
	}

	/**
	 * 获取传入时间的最后一天
	 * 
	 * @param monthDay
	 * @return
	 */
	public static String getDateLastDay(String monthDay)
	{
		// 创建 Calendar 对象
		Calendar calendar = Calendar.getInstance();
		// 设置传入的时间格式
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM");
		Date date = null;
		// 指定一个日期
		try
		{
			date = dateFormat.parse(monthDay);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		// 对 calendar 设置为 date 所定的日期
		calendar.setTime(date);
		calendar.set(Calendar.DATE, 1);
		calendar.roll(Calendar.DATE, -1);
		return (new SimpleDateFormat("yyyy-MM-dd")).format(calendar.getTime());
	}




	/**
	 * 获得本周的开始日志和结束日期
	 * 
	 * @return
	 */
	public static String[] getWeekStartAndEnd(Date date)
	{
		String[] returnArray = new String[3];

		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Calendar calendar = Calendar.getInstance();

		calendar.setTime(date);
		calendar.setFirstDayOfWeek(Calendar.MONDAY);

		returnArray[0] = dateFormat.format(calendar.getTime());

		calendar.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
		returnArray[1] = dateFormat.format(calendar.getTime());

		calendar.set(Calendar.DAY_OF_WEEK, Calendar.FRIDAY);
		returnArray[2] = dateFormat.format(calendar.getTime());

		return returnArray;
	}

	static public List<String> getAllMonthToNow()
	{
		Calendar cal = Calendar.getInstance();
		int month = cal.get(Calendar.MONTH) + 1;
		List<String> monthList = new ArrayList<>();
		for (int i = month; i >= 1; i--)
		{
			if (i >= 10)
			{
				monthList.add(i + "月");
			}
			else
			{
				monthList.add("0" + i + "月");
			}
		}
		Collections.reverse(monthList);
		return monthList;
	}

	/**
	 * Object转int
	 * 
	 * @param str
	 * @return
	 */
	public static BigDecimal convertToBigDecimal(Object str)
	{
		if ((str == null) || ("".equals(str.toString().trim())))
		{
			return BigDecimal.ZERO;
		}
		return new BigDecimal(str.toString());
	}

	/**
	 * 邮件内容发送模板
	 * @param mailHeader
	 * @return
	 */
	public static String createEmailTempl(String mailHeader, String mailContent, String mailTable)
	{
		StringBuffer buffer = new StringBuffer();
		buffer.append("<div class='top_title'><font>HW 综合业务管理平台通知</font></div><br/>");
		buffer.append("<font class='top_content'>");
		buffer.append(mailHeader);
		buffer.append("</font><br/>");
		buffer.append("&nbsp;&nbsp;");
		buffer.append("<font class='top_content'>");
		buffer.append(mailContent);
		buffer.append("</font>");
		buffer.append(mailTable);
		buffer.append("<div style='text-align: left'>");
		buffer.append("<br/>");
		buffer.append(
		        "<font class='bottom_content'>访问链接:</font><a href='https://10.60.84.160:8443/gts_cn'><font class='bottom_content'>https://10.60.84.160:8443/gts_cn</font></a>");
		buffer.append("</div>");
		buffer.append("<div style='text-align: right'>");
		buffer.append("<font class='bottom_content'>HW 综合业务管理平台</font>");
		buffer.append("<br/>");
		buffer.append("<font class='top_content'>日期:&nbsp;");
		buffer.append(CommonUtils.convertIntToDateStr(getDateInMillis(), "yyyy-MM-dd"));
		buffer.append("</font>");
		buffer.append("</div>");
		return buffer.toString();
	}

	private static final int CPUTIME = 500;
	private static final int PERCENT = 100;
	private static final int FAULTLENGTH = 10;

	@SuppressWarnings("restriction")
	public static String getMemery()
	{
		OperatingSystemMXBean osmxb = (OperatingSystemMXBean) ManagementFactory.getOperatingSystemMXBean();
		// 总的物理内存+虚拟内存
		long totalvirtualMemory = osmxb.getTotalSwapSpaceSize();
		// 剩余的物理内存
		long freePhysicalMemorySize = osmxb.getFreePhysicalMemorySize();
		Double compare = (Double) (1 - freePhysicalMemorySize * 1.0 / totalvirtualMemory) * 100;
		String str = "内存已使用:" + compare.intValue() + "%";
		return str;
	}

	public static List<String> getDisk()
	{
		// 操作系统
		List<String> list = new ArrayList<String>();
		for (char c = 'A'; c <= 'Z'; c++)
		{
			String dirName = c + ":/";
			File win = new File(dirName);
			if (win.exists())
			{
				long total = (long) win.getTotalSpace();
				long free = (long) win.getFreeSpace();
				Double compare = (Double) (1 - free * 1.0 / total) * 100;
				String str = c + ":盘  已使用 " + compare.intValue() + "%";
				list.add(str);
			}
		}
		return list;
	}

	public static String getCpuRatioForWindows()
	{
		try
		{
			String procCmd = System.getenv("windir")
			        + "\\system32\\wbem\\wmic.exe process get Caption,CommandLine,KernelModeTime,ReadOperationCount,ThreadCount,UserModeTime,WriteOperationCount";
			// 取进程信息
			long[] c0 = readCpu(Runtime.getRuntime().exec(procCmd));
			Thread.sleep(CPUTIME);
			long[] c1 = readCpu(Runtime.getRuntime().exec(procCmd));
			if (c0 != null && c1 != null)
			{
				long idletime = c1[0] - c0[0];
				long busytime = c1[1] - c0[1];
				return "CPU使用率:" + Double.valueOf(PERCENT * (busytime) * 1.0 / (busytime + idletime)).intValue() + "%";
			}
			else
			{
				return "CPU使用率:" + 0 + "%";
			}
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
			return "CPU使用率:" + 0 + "%";
		}
	}

	private static long[] readCpu(final Process proc)
	{
		long[] retn = new long[2];
		try
		{
			proc.getOutputStream().close();
			InputStreamReader ir = new InputStreamReader(proc.getInputStream());
			LineNumberReader input = new LineNumberReader(ir);
			String line = input.readLine();
			if (line == null || line.length() < FAULTLENGTH)
			{
				return null;
			}
			int capidx = line.indexOf("Caption");
			int cmdidx = line.indexOf("CommandLine");
			int rocidx = line.indexOf("ReadOperationCount");
			int umtidx = line.indexOf("UserModeTime");
			int kmtidx = line.indexOf("KernelModeTime");
			int wocidx = line.indexOf("WriteOperationCount");
			long idletime = 0;
			long kneltime = 0;
			long usertime = 0;
			while ((line = input.readLine()) != null)
			{
				if (line.length() < wocidx)
				{
					continue;
				}
				// 字段出现顺序：Caption,CommandLine,KernelModeTime,ReadOperationCount,
				// ThreadCount,UserModeTime,WriteOperation
				String caption = substring(line, capidx, cmdidx - 1).trim();
				String cmd = substring(line, cmdidx, kmtidx - 1).trim();
				if (cmd.indexOf("wmic.exe") >= 0)
				{
					continue;
				}
				String s1 = substring(line, kmtidx, rocidx - 1).trim().replace(" ", "");
				String s2 = substring(line, umtidx, wocidx - 1).trim().replace(" ", "");
				if (caption.equals("System Idle Process") || caption.equals("System"))
				{
					if (s1.length() > 0) idletime += Long.valueOf(s1).longValue();
					if (s2.length() > 0) idletime += Long.valueOf(s2).longValue();
					continue;
				}
				if (s1.length() > 0) kneltime += Long.valueOf(s1).longValue();
				if (s2.length() > 0) usertime += Long.valueOf(s2).longValue();
			}
			retn[0] = idletime;
			retn[1] = kneltime + usertime;
			return retn;
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
		}
		finally
		{
			try
			{
				proc.getInputStream().close();
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
		}
		return null;
	}

	private static String substring(String src, int start_idx, int end_idx)
	{
		byte[] b = src.getBytes();
		String tgt = "";
		for (int i = start_idx; i <= end_idx; i++)
		{
			tgt += (char) b[i];
		}
		return tgt;
	}

	public static String getNowComputerIp()
	{
		String hostAddress = "";
		try
		{
			InetAddress address = InetAddress.getLocalHost();
			hostAddress = address.getHostAddress();
		}
		catch (UnknownHostException e)
		{
			e.printStackTrace();
			
		}
		return hostAddress;
	}

	public static String getPort()
	{
		String port = "";
		
		MBeanServer mBeanServer = null;
		List<MBeanServer> mBeanServers = MBeanServerFactory.findMBeanServer(null);
		if (mBeanServers.size() > 0)
		{
			for (MBeanServer _mBeanServer : mBeanServers)
			{
				mBeanServer = _mBeanServer;
				break;
			}
		}
		if (mBeanServer == null)
		{
			return port;
		}
		Set<ObjectName> objectNames = null;
		try
		{

			objectNames = mBeanServer.queryNames(new ObjectName("Catalina:type=Connector,*"), null);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		if (objectNames == null || objectNames.size() <= 0)
		{
			return port;
		}
		try
		{
			for (ObjectName objectName : objectNames)
			{
				String protocol = (String) mBeanServer.getAttribute(objectName, "protocol");
				if (protocol.equals("HTTP/1.1"))
				{
					int portNum = (Integer) mBeanServer.getAttribute(objectName, "port");
					
					port = portNum+"";
					
					break ;
				}

			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return port;
	}


}