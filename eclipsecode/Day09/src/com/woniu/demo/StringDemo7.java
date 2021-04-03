package com.woniu.demo;

import java.util.Arrays;

public class StringDemo7 {
	public static void main(String[] args) {
		String s1 = "baidu_huawei_tengxun_meituan_xiaomi";//_替换为,
		String rp = s1.replace("_",",");
		String rp2 = s1.replace("tengxun","woniu");
		System.out.println(rp);
		System.out.println(rp2);
		
		//split，分割
		String s2 = "17791528751#12306";
		String []split2 = s2.split("#");//#不出现在分割后的数组中
		System.out.println(Arrays.toString(split2));
		String s3 = "https://www.baidu.com/s?wd=谷歌地图";
		String []split3 = s3.split("\\?");//两个\转译？
		System.out.println(Arrays.toString(split3));
		
		
	}

}
