package com.woniu.home;

public class Demo1 {
	public static void main(String[] args) {
		String s1 = "2018101011101010";
		int count1 = 0;
		for(int i = 0;i<s1.length();i++){
			if('1'==s1.charAt(i)) {
				count1++;
			}
		}
		System.out.println(count1);
		
		int count2 = 0;
		char []charArray = s1.toCharArray();
		for(int i = 0;i<s1.length();i++){
			if('1'==charArray[i]) {
				count2++;
			}
		}
		System.out.println(count2);
		
		//使用indexOf
		int count3 = 0;//次数不确定，使用while
		int start = 0;
		while(s1.indexOf("1",start)!=-1) {
			count3++;
			start = s1.indexOf("1",start)+1;
		}
		System.out.println(count3);
		
		
	}

}
