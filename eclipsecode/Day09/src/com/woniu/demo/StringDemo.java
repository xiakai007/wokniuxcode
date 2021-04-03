package com.woniu.demo;

import java.util.Arrays;

public class StringDemo {
	public static void main(String[] args) {
		//字符串I love you → you love I
		String str = "I love you";
		String []split = str.split(" ");
		System.out.println(Arrays.toString(split));
		for(int i=split.length-1;i>=0;i--) {
			System.out.print(split[i]+" ");
		}
		//分割 split(regx)
		
		
	}

}
