package com.woniu.demo;

public class ArrayDemo4 {
	public static void main(String[] args) {
		int [] arr = {1,2,3,4,5,6,7,8,9,10};
		for(int i = 0;i< arr.length;i++) {
			System.out.print(arr[i]+" ");
		}
		System.out.println();
		int [] brr = {-45,98,5,3,-7,109,65,6};
		int max = brr[0],min = brr[0];
		for(int i = 1;i< brr.length;i++) {
			if(brr[i]>max)
				max = brr[i];
			if(brr[i]<min)
				min = brr[i];
		}
		System.out.println(max);
		System.out.println(min);
		
	}

}
