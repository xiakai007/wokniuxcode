package com.woniu.chapter10_02_classWithParameter;

public class StudBiz {
	Stud[] stus = new Stud[30];
	/**
	 * 增加学生姓名
	 * @param stu 一个学生
	 */
	public void addStu(Stud stu) {
		for(int i = 0;i<stus.length;i++) {
			if(stus[i]==null) {
				stus[i] = stu;
				break;
			}
		}
	}
	/**
	 * 展示学生列表信息
	 */
	public void showStus() {
		System.out.println("本班学生列表：");
		System.out.println("学号\t姓名\t性别\t年龄\t成绩");
		for(int i= 0;i<stus.length;i++) {
			if(stus[i]!=null) {
				stus[i].showInfo();
			}
		}
	}

}
