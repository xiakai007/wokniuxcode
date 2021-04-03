package com.woniu.chapter10_01_classWithNoParameter;

import java.util.Scanner;

public class ScoreCalTest {
	public static void main(String[] args) {
		ScoreCal sca = new ScoreCal();
		Scanner sc = new Scanner(System.in);
		System.out.print("请输入Java成绩：");
		sca.java = sc.nextInt();
		System.out.print("请输入c#成绩：");
		sca.c = sc.nextInt();
		System.out.print("请输入DB成绩：");
		sca.db = sc.nextInt();
		
		sca.showCalTotal();
		sca.showCalAvg();
		sc.close();
		
	}

}
