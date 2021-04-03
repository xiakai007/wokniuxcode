package com.woniu.chapter20_taxi;

import java.util.ArrayList;
import java.util.Scanner;

public class MainUI {
	static Scanner sc = new Scanner(System.in);
	public void indexUI() {
		System.out.println("欢迎租车");
		System.out.println("1.登录");
		System.out.println("2.注册");
		System.out.println("3.预约");
		System.out.println("4.退出");
		System.out.println("***********");
		System.out.println("请选择1-4：");
		String num = sc.nextLine();
		switch(num) {
		case "2":
			registerUI();
		break;
		}
	}
	public void registerUI() {
		System.out.println("欢迎注册");
		System.out.println("请输入用户名：");
		String userName = sc.next();
		String pwd = getPwd();
		boolean flag = checkUserName(userName);
	}
	public static String getPwd() {
		System.out.println("请输入密码：");
		String pwd = sc.next();
		System.out.println("请再次输入密码：");
		String repwd = sc.next();
		if(pwd.equals(repwd)) {
			return pwd;
		}else {
			System.out.println("两次密码不一致");
			return getPwd();
		}
	}
	public boolean checkUserName(String name) {
		ArrayList<User> list = CSVUtil.registerUser();
		return false;
	}

}
