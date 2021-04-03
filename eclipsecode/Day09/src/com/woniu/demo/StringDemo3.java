package com.woniu.demo;

import java.util.Arrays;

public class StringDemo3 {
	public static void main(String[] args) {
		//长度，str.length()
		String str = "sjasjg ljkasd 546 asga";
		System.out.println(str.length());
		
		String s1 = "小荷才露尖尖角";
		char ch = s1.charAt(1);
		System.out.println(ch);
		
		String s2 = "早有蜻蜓立上头";
		char[] chr = s2.toCharArray();
		System.out.println(chr);
		System.out.println(Arrays.toString(chr));
		
		String s3 = "啊价格拉代购iau";
		for(int i =0;i<s3.length();i++) {
			System.out.println(s3.charAt(i));
		}
		
		char []ch2 = {'一','国','两','制'};
		String s4 = new String(ch2);
		String s5 = String.valueOf(ch2);
		System.out.println(s4);
		System.out.println(s5);
	}
	

}
