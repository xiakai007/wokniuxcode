package com.woniu.chapter07_array;

import java.util.Arrays;
import java.util.Scanner;

public class StringDemo09_insertSort02 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//原数组排序
		int[] num = { 99, 85, 82, 63, 60, 79, 12, 108,-12,3,-7};
		Arrays.sort(num);
		//创建新数组并复制
		int []newNum = new int[num.length+1];
		for(int i =0;i<num.length;i++) {
			newNum[i] = num[i];
		}
		//获取插入数
		System.out.println("请输入新增成绩：");
		int insertN = sc.nextInt();
		//获取插入下标
		int index = newNum.length-1;
		for(int i = 0;i<newNum.length;i++) {
			if(insertN<newNum[i]) {
				index = i;
				break;
			}
		}
		System.out.println("插入成绩的下标是："+index);
		//插入该成绩
		for(int i =newNum.length-1;i>index;i--) {
			newNum[i] = newNum[i-1];
		}
		newNum[index] = insertN;
		System.out.println("插入后的成绩是：\n"+Arrays.toString(newNum));
		sc.close();
	}

}
