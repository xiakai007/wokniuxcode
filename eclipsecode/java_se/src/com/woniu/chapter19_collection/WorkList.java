package com.woniu.chapter19_collection;

import java.util.ArrayList;
import java.util.Collections;
//import java.util.Comparator;
import java.util.List;

public class WorkList {
	public static void main(String[] args) {
		List<Integer> nums = new ArrayList<>();
		nums.add(2);
		nums.add(9);
		nums.add(7);
		nums.add(16);
		nums.add(4);
		nums.add(-20);
		nums.add(13);
		System.out.println(nums);
		//反转
		Collections.reverse(nums);
		System.out.println(nums);
//		Collections.sort(nums);
//		System.out.println(nums);
		//降序
		Collections.sort(nums, (o1,o2)->o1-o2);//Lambda表达式
		System.out.println(nums);
	}

//	@Override
//	public int compareTo(Integer o) {
//		return this.compareTo(o);
//	}

}
