package com.woniu.chapter17_outer_inner_lambda;

public class Student extends Person {
	private int stuNo;
	
	public Student() {
		super();
	}

	public Student(String name,String gender,int age,int stuNo) {
		super(name,gender,age);
		this.stuNo = stuNo;
	}

	public int getStuNo() {
		return stuNo;
	}

	public void setStuNo(int stuNo) {
		this.stuNo = stuNo;
	}

	@Override
	public void show() {
		System.out.println("学生姓名："+this.getName()+"，学号："+stuNo
				+"号，性别："+this.getGender()+"，年龄："+this.getAge());
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		if (stuNo == other.stuNo&&getName().equals(other.getName())) {
			return true;
		}else {
			return false;
		}
			
		
	}
	

}
