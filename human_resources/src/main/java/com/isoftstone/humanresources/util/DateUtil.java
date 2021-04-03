package com.isoftstone.humanresources.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Pattern;

/**
 * 日期时间工具类
 * Created by charlin on 2017/9/3.
 */
public class DateUtil<main> {
    public static final String CHINA_DATE_FORMAT = "yyyy年MM月dd日";
    public static final String DATETIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
    public static final String DATE_FORMAT = "yyyy-MM-dd";
    public static final String TIME_FORMAT = "HH:mm:ss";


    //----------------判断-----------------------------------------------
    /**
     * 是否是润年
     * @param yearNum
     * @return
     */
    public static boolean isLeapYear(int yearNum) {
        boolean isLeep = false;
        if ((yearNum % 4 == 0) && (yearNum % 100 != 0))
            isLeep = true;
        else if (yearNum % 400 == 0)
            isLeep = true;
        else {
            isLeep = false;
        }
        return isLeep;
    }

    /**
     * 判断是否是日期
     *
     * @param date
     * @return
     */
    public static boolean isDate(String date) {
        //判断年月日的正则表达式，接受输入格式为2010-12-24，可接受平年闰年的日期
        String regex = "(([0-9]{3}[1-9]|[0-9]{2}[1-9][0-9]{1}|[0-9]{1}[1-9][0-9]{2}|[1-9][0-9]{3})-(((0[13578]|1[02])-(0[1-9]|[12][0-9]|3[01]))|((0[469]|11)-(0[1-9]|[12][0-9]|30))|(02-(0[1-9]|[1][0-9]|2[0-8]))))|((([0-9]{2})(0[48]|[2468][048]|[13579][26])|((0[48]|[2468][048]|[3579][26])00))-02-29)";
        Pattern pattern = Pattern.compile(regex);
        return pattern.matcher(date).matches();
    }

    //-------------------自动转化--------------------------------------------
    /**
     * 把字符串自动转化为时间格式
     *
     * @param dateStr
     * @return
     */
    public static Date parseDateByAuto(String dateStr) {
        if (StringUtil.isEmpty(dateStr)) {
            return null;
        }
        String format = DATE_FORMAT;
        if (dateStr.indexOf("/") > -1) {
            format = format.replace("-", "/");
        }
        if (dateStr.indexOf(":") != -1) {
            format += " HH:mm";
        }
        //存在秒
        if (dateStr.indexOf(":") != dateStr.lastIndexOf(":")) {
            format += ":ss";
        }
        return parseDate(dateStr, format);
    }

    /**
     * 自动识别格式
     * @param date
     * @return
     */
    public static String formatDateByAuto(Date date){
        String format = DATE_FORMAT;
        if( !(date instanceof java.sql.Date) && (date.getSeconds()>0||date.getMinutes()>0||date.getHours()>0)){
            format = DATETIME_FORMAT;
        }
        return formatDate(date, format);
    }

    //------------当前日期与时间 --------------------------------
    /**取当前日期*/
    public static Date getCurrDate() {return parseDate(formatDate(new Date())); }
    /**取当前时间*/
    public static Date getCurrDateTime() {return parseDate(formatDate(new Date())); }
    /**取当前日期*/
    public static String getCurrDateStr() { return formatDate(new Date());    }
    /**取当前时间*/
    public static String getCurrDateTimeStr() { return formatDate(new Date(), DATETIME_FORMAT);}
    public static String formatCurrDate() {return formatDate(new Date(),DATE_FORMAT); }
    public static String formatCurrDateTime() {return formatDate(new Date(),DATETIME_FORMAT);}
    public static String formatCurrDateToS(String strFormat) {return formatDate(new Date(), strFormat); }
    //-----------时间计算--------------------------------------------

    /**
     * 时间相减
     * @param strDateBegin
     * @param strDateEnd
     * @param iType
     * @return
     */
    public static int getDiffDate(String strDateBegin, String strDateEnd, int iType) {
        Calendar calBegin = Calendar.getInstance();
        calBegin.setTime(parseDate(strDateBegin, DATETIME_FORMAT));
        Calendar calEnd = Calendar.getInstance();
        calBegin.setTime(parseDate(strDateEnd, DATETIME_FORMAT));
        long lBegin = calBegin.getTimeInMillis();
        long lEnd = calEnd.getTimeInMillis();
        if (iType == Calendar.SECOND)
            return (int) ((lEnd - lBegin) / 1000L);
        if (iType == Calendar.MINUTE)
            return (int) ((lEnd - lBegin) / 60000L);
        if (iType == Calendar.HOUR)
            return (int) ((lEnd - lBegin) / 3600000L);
        if (iType == Calendar.DAY_OF_MONTH) {
            return (int) ((lEnd - lBegin) / 86400000L);
        }
        return -1;
    }

    /**
     * 添加天数或月份或年得到新的时间
     *
     * @param strDate
     * @param count
     * @param dayType Calendar.YEAR
     * @return
     */
    public static String getAddDateTime(String strDate, int count, int dayType) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(parseDate(strDate));
        cal.add(dayType, count);
        SimpleDateFormat sdf = null;
        if ((dayType == Calendar.YEAR) || (dayType == Calendar.MONTH) || (dayType == Calendar.DAY_OF_MONTH))
            sdf = new SimpleDateFormat(DATE_FORMAT);
        else
            sdf = new SimpleDateFormat(DATETIME_FORMAT);
        return sdf.format(cal.getTime());
    }

    /**
     * 日期增加天数
     * @param date
     * @param iCount
     * @return
     */
    public static Date getAddDate(Date date, int iCount) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DAY_OF_MONTH, iCount);
        return cal.getTime();
    }

    /**
     * 比较日期
     *
     * @param dateStr1
     * @param dateStr2
     * @return
     */
    public static int compareDate(String dateStr1, String dateStr2) {
        Date date1 = parseDate(dateStr1);
        Date date2 = parseDate(dateStr2);
        if (date1.getTime() > date2.getTime())
            return -1;
        else if (date1.getTime() < date2.getTime())
            return 1;
        else
            return 0;
    }

    public static int compareDate(Date date1, Date date2) {
        if (date1.getTime() > date2.getTime())
            return -1;
        else if (date1.getTime() < date2.getTime())
            return 1;
        else
            return 0;
    }

    /**
     * 时间差
     *
     * @param startDate
     * @param endDate
     * @return
     */
    public static int getDiffDays(Date startDate, Date endDate) {
        int days = 0;
        if (startDate.after(endDate)) {
            Date temp = startDate;
            startDate = endDate;
            endDate = temp;
        }
        days = (int) (endDate.getTime() - startDate.getTime()) / 1000 * 60 * 60 * 24;
        return days;
    }

    /**
     * 当前日期的后几天
     *
     * @param date
     * @param n
     * @return
     */
    public static Date getAfterDay(Date date, int n) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.DATE, n);
        return c.getTime();
    }

    //---------获取时间天数----------------------------------------------

    /**
     * 获取当前月的最后一天
     *
     * @param dateStr
     * @return
     */
    public static String getMonthEnd(String dateStr) {
        //当前第一天
        Date date = parseDate(getMonthBegin(dateStr));
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.MONTH, 1);
        c.add(Calendar.DAY_OF_YEAR, -1);
        return formatDate(c.getTime());
    }

    public static String getMonthEnd(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.set(Calendar.DATE, c.getActualMaximum(Calendar.DATE));
        return formatDate(c.getTime());
    }

    /**
     * 获得当前日期的月份第一天
     *
     * @param dateStr
     * @return
     */
    public static String getMonthBegin(String dateStr) {
        Date date = parseDate(dateStr);
        return formatDate(date, "yyyy-MM") + 01;
    }

    public static String getMonthBegin(Date date) {
        return formatDate(date, "yyyy-MM") + 01;
    }

    //--------------格式化日期-----------------------------------------

    /**
     * 格式化日期为字符串
     *
     * @param date
     * @param format
     * @return
     */
    public static String formatDate(Date date, String format) {
        return new SimpleDateFormat(format).format(date);
    }

    public static String formatDate(Date date) {
        return formatDate(date, DATE_FORMAT);
    }

    public static String formateChinaDate(Date date) {
        return formatDate(date, CHINA_DATE_FORMAT);
    }

    public static String formateDateTime(Date date) {
        return formatDate(date, DATETIME_FORMAT);
    }

    public static String formateTime(Date date) {
        return formatDate(date, TIME_FORMAT);
    }


    //-----------------格式化字符串为日期--------------------------------------
    /**
     * 格式化字符串为日期
     *
     * @param date
     * @param format
     * @return
     */
    public static Date parseDate(String date, String format) {
        try {
            return new SimpleDateFormat(format).parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Date parseDate(String date) { return parseDate(date, DATE_FORMAT);}
    public static Date parseChinaDate(String date) {
        return parseDate(date, CHINA_DATE_FORMAT);
    }
    public static Date parseDateTime(String date) {
        return parseDate(date, DATETIME_FORMAT);
    }
    public static Date parseTime(String date) {
        return parseDate(date, TIME_FORMAT);
    }




    //---获取年月日时分秒----------------------------------------------------

    /**
     * 获取年份
     *
     * @param date
     * @return
     */
    public static int getYear(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        return c.get(Calendar.YEAR);
    }

    /**
     * 获取月份
     *
     * @param date
     * @return
     */
    public static int getMonth(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        return c.get(Calendar.MONTH) + 1;
    }

    /**
     * 获取日
     *
     * @param date
     * @return
     */
    public static int getDay(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        return c.get(Calendar.DAY_OF_MONTH);
    }

    /**
     * 获取星期
     *
     * @param date
     * @return
     */
    public static int getWeek(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        return c.get(Calendar.DAY_OF_WEEK);
    }

    /**
     * 获取时间
     *
     * @param date
     * @return
     */
    public static int getHour(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        return c.get(Calendar.HOUR_OF_DAY);
    }

    /**
     * 获取分种
     *
     * @param date
     * @return
     */
    public static int getMinute(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        return c.get(Calendar.MINUTE);
    }

    /**
     * 获取秒
     *
     * @param date
     * @return
     */
    public static int getSecond(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        return c.get(Calendar.SECOND);
    }

    //--------------获取星期几---------------------------------------------------
    /**
     * 获取星期几
     *
     * @param strDate
     * @return
     */
    public static String getWeekDayName(String strDate) {
        String[] mName = {"日", "一", "二", "三", "四", "五", "六"};
        Date date = parseDate(strDate);
        int week = getWeek(date);
        return "星期" + mName[week];
    }

    public static String getWeekDayName(Date date) {
        String[] mName = {"日", "一", "二", "三", "四", "五", "六"};
        int week = getWeek(date);
        return "星期" + mName[week];
    }

    /**
     * 一年中的星期几
     * @return
     */
    public static int getWeekNumOfYear(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.WEEK_OF_YEAR);
    }
    public static int getWeekNumOfYear(String date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(parseDate(date, DATE_FORMAT));
        return calendar.get(Calendar.WEEK_OF_YEAR);
    }

    /**
     * 获取本周星期一的日期
     * @param yearNum
     * @param weekNum
     * @return
     * @throws ParseException
     */
    public static String getYearWeekFirstDay(int yearNum, int weekNum)  {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, yearNum);
        cal.set(Calendar.WEEK_OF_YEAR, weekNum);
        cal.set(Calendar.DAY_OF_WEEK, 2);
        String tempYear = Integer.toString(yearNum);
        String tempMonth = Integer.toString(cal.get(Calendar.MONTH) + 1);
        String tempDay = Integer.toString(cal.get(Calendar.DAY_OF_MONTH)-1);
        return tempYear + "-" + tempMonth + "-" + tempDay;
    }

    /**
     *  获取本周星期天的日期
     * @param yearNum
     * @param weekNum
     * @return
     * @throws ParseException
     */
    public static String getYearWeekEndDay(int yearNum, int weekNum)  {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, yearNum);
        cal.set(Calendar.WEEK_OF_YEAR, weekNum + 1);
        cal.set(Calendar.DAY_OF_WEEK, 1);

        String tempYear = Integer.toString(yearNum);
        String tempMonth = Integer.toString(cal.get(Calendar.MONTH) + 1);
        String tempDay = Integer.toString(cal.get(Calendar.DAY_OF_MONTH)-1);
        return tempYear + "-" + tempMonth + "-" + tempDay;
    }

    //--------------获取天数---------------------------------------------------
    /**
     * 获取某年某月的第一天
     * @param yearNum
     * @param monthNum
     * @return
     */
    public static Date getYearMonthFirstDay(int yearNum, int monthNum) {
        Calendar cal = Calendar.getInstance();
        cal.set(yearNum, monthNum - 1, 1, 0, 0, 0);
        cal.set(14, 0);
        return cal.getTime();
    }

    /**
     * 获取某年下个月的第一天
     * @param yearNum
     * @param monthNum
     * @return
     */
    public static Date getNextYearMonthFirstDay(int yearNum, int monthNum) {
        Calendar cal = Calendar.getInstance();
        cal.set(yearNum, monthNum, 1, 0, 0, 0);
        cal.set(14, 0);
        return cal.getTime();
    }

    /**
     * 获取某年某月的最后一天
     * @param yearNum
     * @param monthNum
     * @return
     */
    public static Date getYearMonthEndDay(int yearNum, int monthNum) {
        Calendar cal = Calendar.getInstance();
        cal.set(yearNum, monthNum, 0, 0, 0, 0);
        cal.set(14, 0);
        return cal.getTime();
    }

    /**
     * 获取某月的第一天
     * @param date
     * @return
     */
    public static Date getYearMonthFirstDay(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(5, 1);
        cal.set(11, 0);
        cal.set(12, 0);
        cal.set(13, 0);
        cal.set(14, 0);
        return cal.getTime();
    }

    /**
     * 获取下一年的第一天
     * @param date
     * @return
     */
    public static Date getNextYearMonthFirstDay(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(2, 1);
        cal.set(5, 1);
        cal.set(11, 0);
        cal.set(12, 0);
        cal.set(13, 0);
        cal.set(14, 0);
        return cal.getTime();
    }

    /**
     * 获取当前月的最后一天
     * @param date
     * @return
     */
    public static Date getYearMonthEndDay(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(5, cal.getActualMaximum(5));
        cal.set(11, 0);
        cal.set(12, 0);
        cal.set(13, 0);
        cal.set(14, 0);
        return cal.getTime();
    }

    /**
     * 获取当年的第一天
     * @param yearNum
     * @return
     */
    public static Date getYearFirstDay(int yearNum) {
        Calendar cal = Calendar.getInstance();
        cal.set(yearNum, 0, 1, 0, 0, 0);
        cal.set(14, 0);
        return cal.getTime();
    }

    /**
     * 获取下一年的第一天
     * @param yearNum
     * @return
     */
    public static Date getNextYearFirstDay(int yearNum) {
        Calendar cal = Calendar.getInstance();
        cal.set(yearNum, 12, 1, 0, 0, 0);
        cal.set(14, 0);
        return cal.getTime();
    }

    /**
     * 获取当年的最后一天
     * @param yearNum
     * @return
     */
    public static Date getYearEndDay(int yearNum) {
        Calendar cal = Calendar.getInstance();
        cal.set(yearNum, 12, 0, 0, 0, 0);
        cal.set(14, 0);
        return cal.getTime();
    }

    /**
     * 获取当前星期
     * @param strDate
     * @param weekNum
     * @return
     */
    public static String getWeek(String strDate, int weekNum) {
        Calendar c = Calendar.getInstance();
        c.setTime(parseDate(strDate));
        if (weekNum == 1)
            c.set(7, 2);
        else if (weekNum == 2)
            c.set(7, 3);
        else if (weekNum == 3)
            c.set(7, 4);
        else if (weekNum == 4)
            c.set(7, 5);
        else if (weekNum == 5)
            c.set(7, 6);
        else if (weekNum == 6)
            c.set(7, 7);
        else if (weekNum == 0)
            c.set(7, 1);
        return formatDate(c.getTime());
    }

    public static Date getWeek(Date date, int weekNum) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        if (weekNum == 1)
            c.set(7, 2);
        else if (weekNum == 2)
            c.set(7, 3);
        else if (weekNum == 3)
            c.set(7, 4);
        else if (weekNum == 4)
            c.set(7, 5);
        else if (weekNum == 5)
            c.set(7, 6);
        else if (weekNum == 6)
            c.set(7, 7);
        else if (weekNum == 0)
            c.set(7, 1);
        return c.getTime();
    }

    /**
     * 下个月日期
     * @param date
     * @return
     */
    public static Date getNextMonday(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        do
            c.add(Calendar.DAY_OF_MONTH, 1);
        while (c.get(Calendar.DAY_OF_WEEK) != 2);
        return c.getTime();
    }

    /**
     * 获得某一日期的前一天
     *
     */
    public static Date getPreviousDate(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DATE, -1);

        calendar.set(Calendar.HOUR, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.MILLISECOND, 0);

        return getSqlDate(calendar.getTime());
    }

    /**
     * 获得某年某月最后一天的日期
     *
     */
    public static Date getLastDayOfMonth(int year, int month) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, month);
        calendar.set(Calendar.DATE, 1);
        return getPreviousDate(getSqlDate(calendar.getTime()));
    }

    /**
     * 获取一个月的天数
     * @param year
     * @param month
     * @return
     */
    public static int getDaysInMonth(int year, int month) {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, year);
        cal.set(Calendar.MONTH, month - 1);// Java月份才0开始算
        return cal.getActualMaximum(Calendar.DATE);
    }


    //----------------根据用户生日计算年龄-------------------------------------------------
    /**
     * 根据用户生日计算年龄
     */
    public static int getAgeByBirthday(Date birthday) {
        Calendar cal = Calendar.getInstance();
        if (cal.before(birthday)) {
            throw new IllegalArgumentException("The birthDay is before Now.It's unbelievable!");
        }
        int yearNow = cal.get(Calendar.YEAR);
        int monthNow = cal.get(Calendar.MONTH) + 1;
        int dayOfMonthNow = cal.get(Calendar.DAY_OF_MONTH);
        cal.setTime(birthday);
        int yearBirth = cal.get(Calendar.YEAR);
        int monthBirth = cal.get(Calendar.MONTH) + 1;
        int dayOfMonthBirth = cal.get(Calendar.DAY_OF_MONTH);
        int age = yearNow - yearBirth;
        if (monthNow <= monthBirth) {
            if (monthNow == monthBirth) {
                if (dayOfMonthNow < dayOfMonthBirth) {
                    age--;
                }
            } else {
                age--;
            }
        }
        return age;
    }

    /**
     * 由java.util.Date到java.sql.Date的类型转换
     *
     */
    public static Date getSqlDate(java.util.Date date) {
        return new Date(date.getTime());
    }

    /**
     * 根据生日计算年龄
     * @param birthday
     * @return
     */
    private static int getAgeByBirth(Date birthday) {
        int age = 0;
        try {
            Calendar now = Calendar.getInstance();
            now.setTime(new Date());// 当前时间

            Calendar birth = Calendar.getInstance();
            birth.setTime(birthday);

            if (birth.after(now)) {//如果传入的时间，在当前时间的后面，返回0岁
                age = 0;
            } else {
                age = now.get(Calendar.YEAR) - birth.get(Calendar.YEAR);
                if (now.get(Calendar.DAY_OF_YEAR) > birth.get(Calendar.DAY_OF_YEAR)) {
                    age += 1;
                }
            }
            return age;
        } catch (Exception e) {//兼容性更强,异常后返回数据
            return 0;
        }
    }

    public static int getTimeInMillis(Date date)
    {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return Integer.valueOf("" + calendar.getTimeInMillis() / 1000);
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
            formater =  "yyyy-MM-dd HH:mm:ss";
        }
        SimpleDateFormat format = new SimpleDateFormat(formater);
        if (StringUtil.isEmpty(dateStr))
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

    public static Date getDate(int days) {
        Calendar c = Calendar.getInstance();
        c.set(1900, 0, 1);
        c.add(Calendar.DATE, days - 2);
        return c.getTime();
    }

    /**
     * @param nowDate   要比较的时间
     * @param startDate   开始时间
     * @param endDate   结束时间
     * @return   true在时间段内，false不在时间段内
     * @throws Exception
     */
    public static boolean hourMinuteBetween(String nowDate, String startDate, String endDate) throws Exception {

        SimpleDateFormat format = new SimpleDateFormat("HH:mm");

        Date now = format.parse(nowDate);
        Date start = format.parse(startDate);
        Date end = format.parse(endDate);

        long nowTime = now.getTime();
        long startTime = start.getTime();
        long endTime = end.getTime();

        return nowTime >= startTime && nowTime <= endTime;
    }


    /**
     *  判断时间是否大于1个小时以上
     * @param timestr
     * @return
     */
    public static boolean greaterDownhour(String timestr){
        DateFormat df = new SimpleDateFormat("HH:mm");//创建日期转换对象HH:mm:ss为时分秒，年月日为yyyy-MM-dd
        try {
            Date dt1 = df.parse(timestr);//将字符串转换为date类型
            Date dt2 = df.parse("17:30");
            if (dt1.getTime() - dt2.getTime() > 0  )//比较时间大小,如果dt1大于dt2
            {
                return true ;
            }
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return false;
    }

    /**
     *  判断时间是否大于1个小时以上
     * @param time1str
     * @param time2str
     * @return
     */
    public static boolean greater1hour(String time1str, String time2str){
        DateFormat df = new SimpleDateFormat("HH:mm");//创建日期转换对象HH:mm:ss为时分秒，年月日为yyyy-MM-dd
        try {
            Date dt1 = df.parse(time1str);//将字符串转换为date类型
            Date dt2 = df.parse(time2str);
            if (dt1.getTime() - dt2.getTime()>3600000 ||dt1.getTime() - dt2.getTime()<-3600000 )//比较时间大小,如果dt1大于dt2
            {
                return true ;
            }
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return false;
    }



    public static void main(String[] args)
    {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println(formatDate(getDate( 44076),"yyyy-MM-dd"));
    }

}
