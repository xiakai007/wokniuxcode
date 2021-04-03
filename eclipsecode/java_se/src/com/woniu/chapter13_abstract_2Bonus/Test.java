package com.woniu.chapter13_abstract_2Bonus;

public class Test {
	public static void main(String[] args) {
		Manager mng = new Manager("张三",1001,12652.9);
//		Staff sta2 = new Staff();
		Staff sta = new Staff("李四",2002,6542.8);
		Finance calB = new Finance();
		calB.calBonus(mng);
		calB.calBonus(sta);
		System.out.println(Employee.show());
	}
	
	
	

}
