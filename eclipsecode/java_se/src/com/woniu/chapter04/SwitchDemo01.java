package com.woniu.chapter04;

public class SwitchDemo01 {
	public static void main(String[] args) {
		int rank = 4;
		switch(rank) {
		case 1:
			System.out.println("将参加麻省理工大学组织的1个月夏令营");
			break;
		case 2:
			System.out.println("将奖励惠普笔记本电脑一部");
			break;
		case 3:
			System.out.println("将奖励移动硬盘一个");
			break;
		default:
		    System.out.println("不给任何奖励");
			break;
		}
	}

}
