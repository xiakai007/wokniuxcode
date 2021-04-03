package com.woniu.chapter05;
////山上有一口缸可以装50升水，现在有15升水。老和尚叫小和尚下山挑水，
//每次可以挑5升。问：小和尚要挑几次水才可以把水缸挑满？
public class Work07 {
	public static void main(String[] args) {
		int waterCap = 15;
		int i = 0;
		while(waterCap<50) {
			i++;
			waterCap +=5;
			
		}
		System.out.println(i);
		System.out.println(waterCap);
	}

}
