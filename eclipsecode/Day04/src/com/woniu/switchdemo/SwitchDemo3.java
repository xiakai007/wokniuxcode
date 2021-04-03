package com.woniu.switchdemo;

public class SwitchDemo3 {
	public static void main(String[] args) {
		int i = 10;
		int y = 4;
		switch(y) {
		case 1:
			System.out.println(888);
			i++;
			break;
		case 2:
			System.out.println(222);
			i++;
		case 3:
			System.out.println(333);
			i++;
			break;
		default:
			System.out.println(666);
			i++;
		}
		System.out.println(i);
	}

}
