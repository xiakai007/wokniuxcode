package com.woniu.chapter20_IO;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class IOWork2 {
	public static void main(String[] args) {
		ArrayList<Student> listStu = new ArrayList<>();
		listStu.add(new Student("1001","张三","男",20));
		listStu.add(new Student("1002","李四","男",30));
		listStu.add(new Student("1003","王五","男",40));
		listStu.add(new Student("1004","赵六","男",50));
		listStu.add(new Student("1005","鬼8","男",60));
		listStu.add(new Student("1006","毛9","男",20));
		try(BufferedWriter bw = new BufferedWriter(new FileWriter("D:\\student.csv"))) {
			String title = "学号\t姓名\t性别\t年龄";
			bw.write(title);
			bw.newLine();
			for(Student stu:listStu) {
				bw.write(stu.getNo()+","+stu.getName()+","+stu.getGender()+","+stu.getAge());
				bw.newLine();
				
			}
			System.out.println("数据写出成功");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
class Student{
	String no;
	String name;
	String gender;
	int age;
	public Student(String no, String name, String gender, int age) {
		super();
		this.no = no;
		this.name = name;
		this.gender = gender;
		this.age = age;
	}
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	
}