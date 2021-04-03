package com.woniu.chapter07_array;

import java.util.Arrays;
import java.util.Scanner;

public class StringDemo10_insertSortP {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String []letters = {"z","b","c","e","f","p","u","a"};
//		char []letters = {'z','b','d','c','a','u','p','e'};
		System.out.println("原字符是："+Arrays.toString(letters));
		Arrays.sort(letters);
		
		String []newLetters = new String[letters.length+1];
		for(int i =0;i<letters.length;i++) {
			newLetters[i] = letters[i];
		}
		System.out.println(Arrays.toString(newLetters));
		
		System.out.print("待插入的字符是：");
		String insertL = sc.next();
		int index = letters.length-1;
		
		for(int i =0;i<letters.length-1;i++) {
			char ch1 = insertL.charAt(0);
			char ch2 = letters[i].charAt(0);
			if(ch1<ch2) {
				index = i;
				break;
			}
		}
		System.out.print("插入字符的下标是："+index+"\n");
		
		for(int i =letters.length-1;i<index;i--) {
			char ch1 = newLetters[i].charAt(0);
			char ch2 = newLetters[i-1].charAt(0);
			char temp = ch1;
			ch1 = ch2;
			ch2 = temp;
//			newLetters[i] = newLetters[i-1];
		}
		System.out.println(Arrays.toString(newLetters));
		newLetters[index] = insertL;
		
		System.out.println("插入后的字符序列是："+Arrays.toString(newLetters));
		sc.close();
	}

}
