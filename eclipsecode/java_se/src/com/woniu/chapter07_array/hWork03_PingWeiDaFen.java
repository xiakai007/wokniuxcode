package com.woniu.chapter07_array;

import java.util.Arrays;
import java.util.Scanner;

public class hWork03_PingWeiDaFen {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int []scores = new int[10];
		//获取数组
		for(int i = 0;i<scores.length;i++) {
			System.out.print("请输入第"+(i+1)+"个评委的评分：");
			scores[i] = sc.nextInt();
		}
		//升序排序
		for(int i = 0;i<scores.length;i++) {
			for(int j = 0;j<scores.length-1-i;j++) {
				if(scores[j]>scores[j+1]) {//升序
					int temp = scores[j];
					scores[j] = scores[j+1];
					scores[j+1] = temp;
				}
			}
		}
		System.out.println(Arrays.toString(scores));
		//获取最高分和最低分
//		int scoresMax = scores[scores.length-1];
//		int scoresMin = scores[0];
//		for(int i= 0;i<scores.length;i++) {
//			if(scores[i]>scoresMax) {
//				scoresMax = scores[i];
//			}
//			if(scores[i]<scoresMin) {
//				scoresMin = scores[i];
//			}
//		}
		//获取平均分
		double sum = 0;
//		for(int i = 0;i<scores.length;i++) {
//			if(i==0||i==(scores.length-1)) {
//				continue;
//			}
//			sum += scores[i];
//		}
		for(int i = 1;i<scores.length-1;i++) {
			sum += scores[i];
		}
		System.out.println(sum);
		System.out.println("该选手的平均分是："+sum/(scores.length-2));
		sc.close();
	}

}
