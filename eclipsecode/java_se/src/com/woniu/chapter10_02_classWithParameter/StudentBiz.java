package com.woniu.chapter10_02_classWithParameter;

/**
 * 学生管理类
 * 
 * @author XiaKai
 *
 */
public class StudentBiz {
	// 创建数组保存学生姓名
	String[] names = new String[50];

	/**
	 * 添加学生姓名
	 * 
	 * @param name
	 */
	public void addName(String name) {
		for (int i = 0; i < names.length; i++) {
			if (names[i] == null) {
				names[i] = name;
				break;
			}
		}
	}

	/**
	 * 展示学生列表
	 */
	public void showNames() {
		System.out.println("*********************");
		System.out.println("\t学生姓名列表：");
		System.out.println("*********************");
		for (int i = 0; i < names.length; i++) {
			if (names[i] != null) {
				System.out.print(names[i] + "\t");
			}
		}
	}

	/**
	 * 查找并替换某学生姓名
	 * 
	 * @param oldName
	 * @param newName
	 * @return 是否找到
	 */
	public boolean editName(String oldName, String newName) {
		boolean flag = false;
		for (int i = 0; i < names.length; i++) {
			if (names[i] == null) {
				break;
			}
			if (names[i].equals(oldName)) {
				names[i] = newName;
				flag = true;
			}
		}
		return flag;
	}

	/**
	 * 指定区间查找某个学生姓名
	 * 
	 * @param start
	 * @param end
	 * @param name
	 * @return 是否查找成功
	 */
	public boolean searchName(int start, int end, String name) {
		for (int i = start - 1; i < end; i++) {
			if (names[i] == null) {
				break;
			}
			if (names[i].equals(name)) {
				return true;
			}
		}
		return false;
	}

}
