package com.wxws.sms.management;

import java.util.Scanner;

public class Verify {
	public boolean verif(String userName,String passWord) {
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入用户名：");
		String name = sc.next();
		System.out.println("请输入密码：");
		String pwd = sc.next();
		if(name.equals(userName)&&pwd.equals(passWord)) {
			return true;
		}else {
			return false;
		}
		
	}

}
