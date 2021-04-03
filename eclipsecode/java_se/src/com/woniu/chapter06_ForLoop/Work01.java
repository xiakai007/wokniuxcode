package com.woniu.chapter06_ForLoop;
//1.求1~10之间的所有偶数和,用continue
public class Work01 {
	public static void main(String[] args) {
		int sum = 0;
		for(int i = 1;i<=10;i++) {
			if(i%2!=0) {
				continue;
			}
			sum +=i;
		}
		System.out.println("1~10之间的所有偶数和为:"+sum);
	}
}
