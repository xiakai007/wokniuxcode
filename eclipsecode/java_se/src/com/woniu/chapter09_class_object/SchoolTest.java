package com.woniu.chapter09_class_object;

public class SchoolTest {
	public static void main(String[] args) {
		//创建对象
		School sch1 = new School();
		//属性赋值
		sch1.schName = "西安校区";
		sch1.stuNum = 201;
		sch1.claNum = 20;
		//调用方法
		sch1.show();
		
		School sch2 = new School();
		sch2.schName = "成都校区";
		sch2.stuNum = 502;
		sch2.claNum = 40;
		sch2.show();

	}

}
