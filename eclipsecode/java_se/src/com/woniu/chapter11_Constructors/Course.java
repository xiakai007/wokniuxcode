package com.woniu.chapter11_Constructors;

public class Course {
	//课程名称
	private String courseName;
	//课时
	private int courseTime;
	//授课老师
	private String courseTeacher;
	
	
	//属性的Getters and Setters方法
	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public int getCourseTime() {
		return courseTime;
	}

	public void setCourseTime(int courseTime) {
		this.courseTime = courseTime;
	}

	public String getCourseTeacher() {
		return courseTeacher;
	}

	public void setCourseTeacher(String courseTeacher) {
		this.courseTeacher = courseTeacher;
	}
    //无参构造器
	public Course() {
		super();
	}
    //有参构造器
	public Course(String courseName, int courseTime, String courseTeacher) {
		super();
		this.courseName = courseName;
		this.courseTime = courseTime;
		this.courseTeacher = courseTeacher;
	}
	

}
