package com.woniu.demo;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayDemo7 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		char [] ch = new char[str.length()];
		for(int i = 0;i<str.length();i++) {
			ch[i] = str.charAt(i);
		}
		sc.close();
		System.out.println(Arrays.toString(ch));
		int []arr = {1,1,1,1,2,2,3,3,3,1,1,5,1};
		int count=0;
		for(int i = 0;i<arr.length;i++) {
			if(arr[i]==1) {
				count++;
			}
		}
		System.out.println("1出现了"+count+"次。");
	}

}
