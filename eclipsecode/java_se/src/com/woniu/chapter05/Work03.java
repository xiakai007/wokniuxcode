package com.woniu.chapter05;

//3.根据指定月份，打印该月份所属的季节。
//3,4,5 春季 6,7,8 夏季  9,10,11 秋季 12, 1, 2 冬季
public class Work03 {
	public static void main(String[] args) {
		int month = 12;
		switch (month) {
		case 1:
		case 2:
		case 12:
			System.out.println(month + "是冬季");
			break;
		case 3:
		case 4:
		case 5:
			System.out.println(month + "是春季");
			break;
		case 6:
		case 7:
		case 8:
			System.out.println(month + "是夏季");
			break;
		case 9:
		case 10:
		case 11:
			System.out.println(month + "是秋季");
			break;
		default:
			System.out.println("月份格式错误！");
		}
	}

}
