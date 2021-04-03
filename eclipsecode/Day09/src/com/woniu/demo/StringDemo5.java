package com.woniu.demo;

public class StringDemo5 {
	public static void main(String[] args) {
		String s1 = "上海，你好";
		String s2 = s1.substring(3);//从第3索引截取至末尾
		System.out.println(s2);
		String s3 = s1.substring(0,4);//左闭右开
		System.out.println(s3);
		
		String s4 = "eclipse.exe";
		int index = s4.lastIndexOf(".");
		String s4Name = s4.substring(0,index);//截取文件名
		System.out.println(s4Name);
		
		
	}

}
