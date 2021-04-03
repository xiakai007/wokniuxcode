package com.woniu.demo;

public class HomeWork3 {
	public static void main(String[] args) {
		int ScoreJava = 98;
		int ScoreSQL = 59;
		int Score3 = 60;
		int cha = ScoreJava - ScoreSQL;
		float sum = ScoreJava + ScoreSQL + Score3;
		double avg = sum*1.0/3;
		System.out.println("java课和SQL课的分数之差是："+cha);
		System.out.println("总分是："+sum);
		System.out.println("平均分是："+avg);
		
	}
}
