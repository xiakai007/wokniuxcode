package com.woniu.home2;

import java.util.Arrays;

public class Test {
	public static void main(String[] args) {
		MyMath math = new MyMath();
		long result = math.jieCheng(16);
		System.out.println(result);
		//1!+4!+7!+...+16!
		long sum = 0;
		for(int i = 1;i<=16;i +=3) {
			sum += math.jieCheng(i);
		}
		System.out.println("1!+4!+7!+...+16!="+sum);
		boolean flag = math.isNarcissus(372);
		System.out.println(flag?"是水仙花数":"不是水仙花数");
		//求出所有水仙花数
		for(int i = 100;i<1000;i++) {
			if(math.isNarcissus(i)) 
				System.out.println(i+"是水仙花数");
		}
		double []arr = {1,2,3,4,5,6,7,8.8,7.9};
		System.out.println(Arrays.toString(arr));
		math.inversetSort(arr);
		System.out.println(Arrays.toString(arr));
	}

}
