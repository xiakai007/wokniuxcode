package com.woniu.chapter11_String;

public class String03_split {
	public static void main(String[] args) {
		System.out.println("***原歌词格式***\n长亭外 古道边 芳草碧连天 晚风拂 柳笛声残 夕阳山外山");
		String str = "长亭外 古道边 芳草碧连天 晚风拂 柳笛声残 夕阳山外山";
		String strs[]= str.split(" ");
		System.out.println("***拆分后歌词格式***");
		for (int i = 0; i < strs.length; i++) {
			System.out.println(strs[i]);
		}
		
	}
}
