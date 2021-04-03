package com.woniu.chapter10_02_classWithParameter;

import java.util.Scanner;

public class ScoreCalTest {
	public static void main(String[] args) {
		ScoreCal sca = new ScoreCal();
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入五名参赛者的成绩：");
		int []scores = new int[5];
		for (int i = 0; i < scores.length; i++) {
			scores[i] = sc.nextInt();
		}
		System.out.println("平均成绩："+sca.calAvg(scores));
		System.out.println("最高成绩："+sca.calMax(scores));
		sc.close();
	}

}
