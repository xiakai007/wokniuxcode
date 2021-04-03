package com.woniu.demo;

public class StringDemo6 {
	public static void main(String[] args) {
		String s1 = "baidu_ha_you";
		String s2 = "你好我好大家好，才是真的好。你好啊，真的好吗";
		int indexA = s1.indexOf('a');//某字符第一次出现的索引位置
		int indexB = s2.indexOf("你好");
		int indexC = s2.indexOf("你好",1);
		System.out.println(indexA);
		System.out.println(indexB);
		System.out.println(indexC);
		
		int lastIndexD = s1.lastIndexOf("_");//某字符最后一次出现的索引位置
		System.out.println(lastIndexD);
		
		//小写变大写
		String s3 = "agahdshGALHGA";
		String upC = s3.toUpperCase();
		String lC = s3.toLowerCase();
		System.out.println(upC);
		System.out.println(lC);
		
		//去掉两端空格，
		String userName = " akhgah   ";
		userName = userName.trim();
		System.out.println(userName);
		
		
		
	}

}
