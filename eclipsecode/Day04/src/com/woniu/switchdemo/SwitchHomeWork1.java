package com.woniu.switchdemo;
import java.util.Scanner;
public class SwitchHomeWork1 {
//	键盘输入年份，月份，输出这个月有多少天？
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	System.out.println("请输入年份：");
    	int year = sc.nextInt();
    	System.out.println("请输入月份：");
    	int month = sc.nextInt();
    	if(year%4==0 && year%100!=0 || year%400==0) {//闰年
    		switch(month) {
    		case 1:
    		case 3:
    		case 5:
    		case 7:
    		case 8:
    		case 10:
    		case 12:
    			System.out.println(year+"年"+month+"月"+"有31天。");
    			break;
    		case 4:
    		case 6:
    		case 9:
    		case 11:
    			System.out.println(year+"年"+month+"月"+"有30天。");
    			break;
    		case 2:
    			System.out.println(year+"年"+month+"月"+"有29天。");
    			break;
    		default:
    			System.out.println("月份错误！");
    		}
    	}else {//平年
    		switch(month) {
    		case 1:
    		case 3:
    		case 5:
    		case 7:
    		case 8:
    		case 10:
    		case 12:
    			System.out.println(year+"年"+month+"月"+"有31天。");
    			break;
    		case 4:
    		case 6:
    		case 9:
    		case 11:
    			System.out.println(year+"年"+month+"月"+"有30天。");
    			break;
    		case 2:
    			System.out.println(year+"年"+month+"月"+"有28天。");
    			break;
    		default:
    			System.out.println("月份错误！");
    		}
    	}
	
}

}
