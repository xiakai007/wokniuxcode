package com.woniu.chapter11_Constructors;

public class CourseTest {
	public static void main(String[] args) {
		Course cse1 = new Course("C语言", 25, "张三");
		System.out.println("课程1："+cse1.getCourseName()+
				"，课时："+cse1.getCourseTime()+"课时，授课老师："+
				cse1.getCourseTeacher());
		
		Course cse2 = new Course("java编程", 26, "李四");
		System.out.println("课程2："+cse2.getCourseName()+
				"，课时："+cse2.getCourseTime()+"课时，授课老师："+
				cse2.getCourseTeacher());
		
		Course cse3 = new Course("php网络编程", 12, "王麻子");
		System.out.println("课程3："+cse3.getCourseName()+
				"，课时："+cse3.getCourseTime()+"课时，授课老师："+
				cse3.getCourseTeacher());
		
		Course cse4 = new Course("c++", 34, "李一");
		System.out.println("课程4："+cse4.getCourseName()+
				"，课时："+cse4.getCourseTime()+"课时，授课老师："+
				cse4.getCourseTeacher());
		
		Course cse5 = new Course("数据结构", 58, "王六");
		System.out.println("课程5："+cse5.getCourseName()+
				"，课时："+cse5.getCourseTime()+"课时，授课老师："+
				cse5.getCourseTeacher());
		
	}

}
