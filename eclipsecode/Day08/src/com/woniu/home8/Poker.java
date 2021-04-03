package com.woniu.home8;

import java.util.Arrays;
import java.util.Random;

public class Poker {
	private String []colors = {"♥","♠","♦","♣"};
	private String []nums = {"A","2","3","4","5","6","7","8","9","10","J","Q","K"};
	private String []poker = new String[54];
	public void init() {
		int k = 0;
		for(int i=0;i<nums.length;i++) {
			for(int j=0;j<colors.length;j++) {
				poker[k]=colors[j]+nums[i];
				k++;
			}
		}
		poker[k++]="小王";
		poker[k++]="大王";
		show();
	}
	public void show() {
		for(int i=0;i<poker.length;i++) {
			System.out.print(poker[i]+"\t");
			if((i+1)%4==0) {
				System.out.println();
			}
			
		}
	}
	public static void main(String[] args) {
		Poker p = new Poker();
		p.init();
//		p.show();
		System.out.println();
		System.out.println(Arrays.toString(p.poker));
	}

}


