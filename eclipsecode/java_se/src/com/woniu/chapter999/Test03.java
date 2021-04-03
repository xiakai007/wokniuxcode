package com.woniu.chapter999;

public class Test03 {
	public static void main(String[] args) { 
		 String str = new String("world"); 
		 char[] ch = new char[] {'h','e','l','l','o'}; 
		 change(str,ch); 
//		 System.out.println(str); 
		 System.out.println(String.valueOf(ch)); 
		 } 
	 public static void change(String str1, char[] arr){
		 System.out.println(str1);
		 //新建对象，将change的地址给str1
		 str1 = "change";
		 System.out.println(str1);
		 arr[0] = 'a'; 
		 arr[1] = 'b';
	     arr[2] = 'c'; 
	     arr[3] = 'd'; 
	     arr[4] = 'e'; 
	     }
}
