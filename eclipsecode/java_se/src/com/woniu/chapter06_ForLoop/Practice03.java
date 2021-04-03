package com.woniu.chapter06_ForLoop;
//4.实现判断一个4位整数，统计出此整数里面包含多少个偶数，多
//少个奇数？
public class Practice03 {
	public static void main(String[] args) {
		int num = 1234666;
		int count1 = 0,count2 = 0;
		for(int i = 0;i<7;i++) {
			int rmd = num%10;//取余
			if(rmd%2==0) {
				count1++;//偶数个数
			}else {
				count2++;//奇数个数
			}
			num/=10;//去掉num最后一位数
		}
		System.out.println("偶数有"+count1+"个，奇数有"+count2+"个");
	}

}
