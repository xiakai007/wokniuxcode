package com.woniu.chapter10_02_classWithParameter;

public class StudBizTest {
	public static void main(String[] args) {
		Stud stu1 = new Stud();
		stu1.id = 10;
		stu1.name = "张三";
		stu1.gender = "男";
		stu1.age = 18;
		stu1.score = 98;
		Stud stu2 = new Stud();
		stu2.id = 20;
		stu2.name = "李四";
		stu2.gender = "女";
		stu2.age = 16;
		stu2.score = 99;
		
		StudBiz stup = new StudBiz();
		stup.addStu(stu1);
		stup.addStu(stu2);
		stup.showStus();
	}

}
