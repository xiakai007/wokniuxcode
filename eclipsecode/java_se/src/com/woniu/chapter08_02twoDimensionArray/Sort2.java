package com.woniu.chapter08_02twoDimensionArray;

import java.util.Arrays;

class MySort2{
	public static void insertSort(int[] nums) {
		for(int i=1;i<nums.length;i++) {
			int temp=nums[i];
			int j=i-1;
			while(j>=0&&nums[j]<temp) {
				nums[j+1]=nums[j];
				j--;
			}
			nums[j+1] = temp;
		}
	}
	public static void selectSort(int[] nums) {
		for(int i=0;i<nums.length-1;i++) {
			int Index=i;
			for(int j=i+1;j<nums.length;j++) {
				if(nums[j]>nums[Index]) {
					Index=j;
				}
			}
			if(Index!=i) {
				int temp=nums[Index];
				nums[Index]=nums[i];
				nums[i]=temp;
			}
		}
	}
	public static void bubbleSort(int[] nums) {
		for(int i=0;i<nums.length-1;i++) {
			for(int j=0;j<nums.length-1-i;j++) {
				if(nums[j]<nums[j+1]) {
					int temp = nums[j];
					nums[j]=nums[j+1];
					nums[j+1]=temp;
				}
			}
		}
	}
}
public class Sort2 {
	public static void main(String[] args) {
		int[] nums= {1,23,3,49,5,63,7,-5,8,-9,10};
		System.out.println("-------nums:"+Arrays.toString(nums));
		MySort2.bubbleSort(nums);
		System.out.println("bubbleSort-:"+Arrays.toString(nums));
		MySort2.selectSort(nums);
		System.out.println("selectSort-:"+Arrays.toString(nums));
		MySort2.insertSort(nums);
		System.out.println("insertSort-:"+Arrays.toString(nums));
	}

}
