package com.woniu.chapter06_ForLoop;
//2、山上有一口缸可以装50升水，现在有15升水。
//老和尚叫小和尚下山挑水，每次可以挑5升。问：小和
//尚要挑几次水才可以把水缸挑满？通过编程解决这个问
//题。
public class hWork02 {
	public static void main(String[] args) {
		int l = 15;
		int k = 0;
		while(l<50) {
			k++;
			l +=5;
			
		}
		System.out.println(k);//挑水次数
	}

}
