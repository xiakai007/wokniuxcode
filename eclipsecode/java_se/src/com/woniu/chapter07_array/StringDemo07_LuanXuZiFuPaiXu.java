package com.woniu.chapter07_array;

import java.util.Arrays;

public class StringDemo07_LuanXuZiFuPaiXu {
	public static void main(String[] args) {
		String []letters = {"a","c","u","b","e","p","f","z"};
		System.out.print("原字符序列：");
		for(int i =0;i<letters.length;i++) {
			System.out.print(letters[i]+" ");
		}
		
		Arrays.sort(letters);
		System.out.print("\n升序排序后：");
		for(int i =0;i<letters.length;i++) {
			System.out.print(letters[i]+" ");
		}
		
		System.out.print("\n降序输出为：");
		for(int i =letters.length-1;i>=0;i--) {
			System.out.print(letters[i]+" ");
		}
	}

}
