package com.woniu.home2;

import java.util.Arrays;
import java.util.Random;

public class Poker {
	private String []colors = {"♥","♠","♦","♣"};
	private String []nums = {"A","2","3","4","5","6","7","8","9","10","J","Q","K"};
	private String []poker = new String[54];
	private MyArray player1 = new MyArray(17);
	private MyArray player2 = new MyArray(17);
	private MyArray player3 = new MyArray(17);
	private MyArray base = new MyArray(3);
	/**
	 * 1.初始化牌
	 */
	public void init() {
		int k=0;//牌索引
		for(int i=0;i<nums.length;i++) {//点数
			for(int j=0;j<colors.length;j++) {//花色
				poker[k++]=colors[j]+nums[i];
				
			}
		}
		poker[k++]="小王";
		poker[k]="大王";
		System.out.println("--------------买牌--------------");
		System.out.println(Arrays.toString(poker));
//		showPoker();
	}
	
	/**
	 * 2.看牌
	 */
	public void showPoker() {
		System.out.println("--------------看牌--------------");
		for(int i=0;i<poker.length;i++) {
			System.out.print(poker[i]+"\t");
			if((i+1)%4==0) {
				System.out.println();
			}
		}
	}
	public String[] getPoker() {
		return poker;
	}
	
	/**
	 * 3.洗牌
	 */
	public void shuffle() {
		Random rd = new Random();
		for(int i =0;i<poker.length;i++) {
			int index = rd.nextInt(54);
			String temp = poker[i];
			poker[i] = poker[index];
			poker[index] = temp;
		}
		System.out.println("--------------洗牌--------------");
		System.out.println(Arrays.toString(poker));
//		showPoker();
	}
	
	/**
	 * 4.发牌
	 */
	public void dispatcher() {
		for(int i = 0;i<poker.length;i++) {
			if(i<poker.length-3) {//判断是否是底牌
				if(i%3==0) {
					player1.add(poker[i]);
				}else if(i%3==1) {
					player2.add(poker[i]);
				}else {
					player3.add(poker[i]);
				}
				
			}else{
				base.add(poker[i]);
			}
		}
		System.out.println("--------------发牌--------------");
		System.out.println("张三手牌："+Arrays.toString(player1.getStr()));
		System.out.println("李四手牌："+Arrays.toString(player2.getStr()));
		System.out.println("王五手牌："+Arrays.toString(player3.getStr()));
		System.out.println("底牌："+Arrays.toString(base.getStr()));
	}

}
