package com.woniu.chapter11_String;

public class Register {
	public boolean verify(String name,String pwd1,String pwd2) {
	    if(name.length()<3||pwd1.length()<6) {
			System.out.println("用户名长度不能小于3或密码长度不能小于6！");
			return true;
		}else if(!pwd1.equals(pwd2)) {
			System.out.println("两次输入的密码不相同！");
			return true;
		}
		System.out.println("注册成功！请牢记用户名和密码。");
		return false;
	}

}
