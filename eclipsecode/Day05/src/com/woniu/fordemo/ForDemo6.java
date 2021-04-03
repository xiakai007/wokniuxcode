package com.woniu.fordemo;

public class ForDemo6 {
	public static void main(String[] args) {
		String str = "wELCOME TO sHANGHAI";
		String str2 = "";
		for(int i = 0;i<str.length();i++) {
			char ch = str.charAt(i);
			if(ch>='a' && ch<='z') {
				ch = (char)(ch-32);
			}else if(ch>='A' && ch<='Z') {
				ch = (char)(ch+32);
			}else {
				ch = ' ';
			}
			str2 += ch;
		}
		System.out.print(str2);
	}

}
