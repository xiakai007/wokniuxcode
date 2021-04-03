package com.woniu.demo;

public class Calculator {
	String brand = "华为huawei";
	String type = "科学型";
	public void add(int a,int b) {
		int result = a + b;
		System.out.println(a+"+"+b+"="+result);
	}
	public void sub(double a,double b) {
		double result = a - b;
		System.out.println(a+"-"+b+"="+result);
	}public void sqrt(int x) {
		if(x>=0) {
			double result = Math.sqrt(x);
			System.out.println(x+"开方后的结果为："+result);
		}else {
			System.out.println("负数无法开方！");
		}
		
	}
	public void pow(double x,double y) {
		double result = Math.pow(x, y);
		System.out.println(x+"^"+y+"="+result);
	}
	public void createRandom() {
		int result = (int)Math.ceil(Math.random()*9000+1000);
		System.out.println(result);
	}

}
