package com.woniu.chapter17_outer_inner_lambda;

public class CarTest {
	public static void main(String[] args) { 
        Car car1 = new Car("红色",2020);
        Car car2 = new Car("紫色",2021);
        System.out.println(car1);
        System.out.println(car2);
        if(car1.equals(car2)) {
        	System.out.println("这是同一辆汽车");
        }else {
        	System.out.println("这是两辆不同的汽车");
        }
   }

}
