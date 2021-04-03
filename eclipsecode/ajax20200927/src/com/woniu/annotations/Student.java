package com.woniu.annotations;
@Sleep(id=20,name = "jack")
@Table({"stu1","stu2"})
public class Student {
	@Sleep(id=2,name = "tom")
	private Integer stuId;
	private String stuName;
	public Integer getStuId() {
		return stuId;
	}
	@Test("mySetStuId")
	public void setStuId(Integer stuId) {
		this.stuId = stuId;
	}
	public String getStuName() {
		return stuName;
	}
	public void setStuName(@Test("mySetStuName")String stuName) {
		this.stuName = stuName;
	}
	

}
