package com.woniu.chapter05;

//4.为一个给定的年份找出其对应的中国生肖。
//中国的生肖基于12年一个周期，每年用一个动物代表：
//	rat（鼠）、ox（牛）、tiger（虎）、rabbit（兔）、dragon（龙）、snake（蛇）、
//    horse（马）、sheep（羊）、monkey（候）、rooster（鸡）、dog（狗）、pig（猪）。
//已知条件：2019年：猪   2019 % 12 == 3
public class Work04 {
	public static void main(String[] args) {
		int year = 2048;
		
			int rmd = year  % 12;// 求余
			switch (rmd) {
			case 3:
				System.out.println(year + "年猪年");
				break;
			case 4:
				System.out.println(year + "年鼠年");
				break;
			case 5:
				System.out.println(year + "年牛年");
				break;
			case 6:
				System.out.println(year + "年虎年");
				break;
			case 7:
				System.out.println(year + "年兔年");
				break;
			case 8:
				System.out.println(year + "年龙年");
				break;
			case 9:
				System.out.println(year + "年蛇年");
				break;
			case 10:
				System.out.println(year + "年马年");
				break;
			case 11:
				System.out.println(year + "年羊年");
				break;
			case 0:
				System.out.println(year + "年猴年");
				break;
			case 1:
				System.out.println(year + "年鸡年");
				break;
			case 2:
				System.out.println(year + "年狗年");
				break;
			default:
				System.out.println("输入错误！");
				break;
			}
		
	}

}
