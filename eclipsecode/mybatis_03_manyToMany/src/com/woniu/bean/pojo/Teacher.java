package com.woniu.bean.pojo;

import java.util.List;

public class Teacher {
	private Integer id;
	private String tno;
	private String name;
	private String course;
	private List<Student> students;
	public Teacher() {
		super();
	}
	public Teacher(Integer id, String tno, String name, String course) {
		super();
		this.id = id;
		this.tno = tno;
		this.name = name;
		this.course = course;
	}
	public Teacher(String tno, String name, String course) {
		super();
		this.tno = tno;
		this.name = name;
		this.course = course;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTno() {
		return tno;
	}
	public void setTno(String tno) {
		this.tno = tno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	
	public List<Student> getStudents() {
		return students;
	}
	public void setStudents(List<Student> students) {
		this.students = students;
	}
	@Override
	public String toString() {
		return "Teacher [id=" + id + ", tno=" + tno + ", name=" + name + ", course=" + course + ", students=" + students
				+ "]";
	}
	
}
