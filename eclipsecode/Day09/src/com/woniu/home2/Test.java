package com.woniu.home2;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Test {
	public static void main(String[] args) {
		System.out.println("欢迎进入德州斗地主大奖赛！");
		System.out.println("\t 1.买一副牌");
		System.out.println("\t 2.看牌");
		System.out.println("\t 3.洗牌");
		System.out.println("\t 4.发牌");
		System.out.println("\t 0.结束游戏");
		Scanner sc = new Scanner(System.in);
		Poker poker = new Poker();
		for(;;) {
		System.out.println("请玩家选择功能：");
		int num = sc.nextInt();
		switch(num) {
		case 1:
			poker.init();
			break;
        case 2:
        	poker.showPoker();
			break;
        case 3:
        	poker.shuffle();
	        break;
        case 4:
        	poker.dispatcher();
	        break;
        case 0:
        	System.out.println("游戏结束，欢迎下次再来！");
        	System.exit(0);
	        break;
	    default:
	    	System.out.println("选择错误！！！");
	    	break;
	        	
		}
//		sc.close();
	}
	}
	
	private static void demo() {
		Poker p = new Poker();
		p.init();
		System.out.println();
		p.shuffle();
		System.out.println();
		p.dispatcher();
	}

}
