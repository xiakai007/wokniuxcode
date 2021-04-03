package com.woniu.chapter10_02_classWithParameter;

import java.util.Arrays;

/**
 * 客户姓名排序类
 * @author xiakai
 *
 */
public class CustSort {
	
	public void showNames(String []names) {
		for(int i =0;i<names.length;i++) {
			System.out.print(names[i]+"\t");
		}
		System.out.println();
	}
	public void sortNames(String[]names) {
		Arrays.sort(names);
		for(int i =0;i<names.length;i++) {
			System.out.print(names[i]+"\t");
		}
	}
	

}
