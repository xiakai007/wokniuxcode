package com.woniu.chapter08_02twoDimensionArray;

import java.util.Arrays;

class MySort{
	
	public static void insertSort(int[] nums) {
		/*
		 * 初始数组：7654321
		 *      6,7 54327
		 *      5,6,7 4367
		 *      4,5,6,7 321
		 *      3,4,5,6,7 21
		 *      2,3,4,5,6,7 1
		 *      1,2,3,4,5,6,7 
		 *最终：         1,2,3,4,5,6,7
		 * */
		//控制排序趟数
		for(int i=1;i<nums.length;i++) {
			//要插入的数
			int key = nums[i];
			//j表示有序数中的下标位置，初始值为i-1
			int j = i-1;
			while(j>=0&&key<nums[j]) {
				nums[j+1]=nums[j];
				j--;
			}
			//跳出循环的时候，即找到最小数的下标
			nums[j+1]=key;
		}
	}
	
	/**
	 * 选择降序排列
	 * @param nums
	 */
	/*
	 * 初始数组：7654321
	 *      1,654327
	 *      1,2,54367
	 *      1,2,3,4567
	 *      1,2,3,4,567
	 *      1,2,3,4,5,67
	 *最终：         1,2,3,4,5,6,7
	 * */
	public static void selectSort(int[] nums) {
		//外层循环控制比较的趟数
		for(int i=0;i<nums.length-1;i++) {
			//存储实际最小数的下标位置，初始位置为i
			int minIndex=i;
			for(int j=i+1;j<nums.length;j++) {
				if(nums[j]<nums[minIndex]) {//升序比较
					//记录新的最小数的下标位置
					minIndex=j;
				}
			}
			//里层循环结束后minIndex即为实际最小数的位置下标
			if(minIndex!=i) {
				int temp = nums[minIndex];
				nums[minIndex]=nums[i];
				nums[i]=temp;
			}
		}
	}
	
	/**
	 * 冒泡降序排列
	 * @param nums
	 */
	
	public static void bubbleSort(int[] nums) {
		/*
		 * 初始数组：1234567
		 *      2345671
		 *      3456721
		 *      4567321
		 *      5674321
		 *      6754321
		 *      7654321
		    *  最终        7654321
		 * */
		//外层循环控制比较的趟数
		for(int i=0;i<nums.length-1;i++) {
			//内层循环变量j表示数组中的下标位置，
			for(int j=0;j<nums.length-i-1;j++) {
				if(nums[j]>nums[j+1]) {//升序排列
					int temp = nums[j];
					nums[j]=nums[j+1];
					nums[j+1]=temp;
				}
			}
		}
	}
	/**
	 * 冒泡升序排列
	 * @param nums
	 */
	public  void bubbleSort2(int[] nums) {
		for(int i=0;i<nums.length-1;i++) {
			for(int j=0;j<nums.length-i-1;j++) {
				if(nums[j]>nums[j+1]) {//升序排列
					int temp = nums[j];
					nums[j]=nums[j+1];
					nums[j+1]=temp;
				}
			}
		}
	}
}
public class Sort {
	public static void main(String[] args) {
		int[] nums= {1,23,3,49,5,63,7,-5,8,-9,10};
//		int[] nums2 = {10,9,8,7,6,5,4,3,2,-6};
		MySort.bubbleSort(nums);
		System.out.println("bubbleSort:"+Arrays.toString(nums));
//		bst.bubbleSort2(nums2);
//		System.out.println(Arrays.toString(nums2));
		MySort.selectSort(nums);
		System.out.println("selectSort:"+Arrays.toString(nums));
		MySort.insertSort(nums);
		System.out.println("insertSort:"+Arrays.toString(nums));
	}

}
