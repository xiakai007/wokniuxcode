package com.woniu.bean.pojo;

import java.util.List;

public class Student {
	private Integer id;
	private String sno;
	private String name;
	private List<Teacher> teachers;
	public Student() {
		super();
	}
	public Student(Integer id, String sno, String name) {
		super();
		this.id = id;
		this.sno = sno;
		this.name = name;
	}
	public Student(String sno, String name) {
		super();
		this.sno = sno;
		this.name = name;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getSno() {
		return sno;
	}
	public void setSno(String sno) {
		this.sno = sno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public List<Teacher> getTeachers() {
		return teachers;
	}
	public void setTeachers(List<Teacher> teachers) {
		this.teachers = teachers;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", sno=" + sno + ", name=" + name + ", teachers=" + teachers + "]";
	}
	
}
