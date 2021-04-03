package com.woniu.chapter10_02_classWithParameter;

public class CustSortTest {
	public static void main(String[] args) {
		CustSort cst = new CustSort();
		String []names = {"Tom","Jack","Merry","Smith","Sunny"};
		System.out.println("****排序前****");
		cst.showNames(names);
		System.out.println("****排序后****");
		cst.sortNames(names);
		
	}

}
