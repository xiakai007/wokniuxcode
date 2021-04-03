package com.woniu.chapter17_outer_inner_lambda;

import java.util.Arrays;
import java.util.Comparator;
import java.util.TreeSet;
import java.util.function.Consumer;

public class Test02_Lambda {
	public static void main(String[] args) {
		//匿名内部类
		Runnable run = new Runnable() {
			@Override
			public void run() {
				System.out.println("run--------");
			}
		};
		new Thread(run).start();
		//匿名内部类转Lambda方式
		Runnable run2 = ()->System.out.println("run2--------");
		new Thread(run2).start();
		
		//匿名内部类-集合
		TreeSet<String>set = new TreeSet<>(new
		Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return o2.length()-o1.length();
			}
		});
		System.out.println(set);
		//匿名内部类转换为Lambda：两个或以上的参数，多条执行语句，可以有返回值
		TreeSet<String>set2 = new TreeSet<>((o1,o2)->
		{
			return o2.length()-o1.length();
		});
		System.out.println(set2);
		
		//Lambda需要一个参数，无返回值
		//Consumer<String>con = (String str)->System.out.println(str);
		Consumer<String>con = str->System.out.println(str);
		con.accept("张三");
		//Lambda需要两个或以上参数，多条语句，有返回值
		Comparator<String>com = (o1,o2)->{
			System.out.println("执行函数");
			return o1.length()-o2.length();
		};
		String []strs = {"g","e","v","a","z"};
		System.out.println(Arrays.toString(strs));
		Arrays.sort(strs, com);
		Arrays.sort(strs, (o1,o2)->{
			System.out.println("执行函数");
			return -o1.compareTo(o2);//降序
		});
		System.out.println(Arrays.toString(strs));
		
		//当Lambda体只有一条语句时，return与大括号都可以省略
		Comparator<Integer>com2 = (o1,o2)->Integer.compare(o1, o2);//升序
		Integer []nums = {3,8,12,2,65,-32,24,-6};
		System.out.println(Arrays.toString(nums));
		Arrays.sort(nums, com2);
		System.out.println(Arrays.toString(nums));
	}

}
