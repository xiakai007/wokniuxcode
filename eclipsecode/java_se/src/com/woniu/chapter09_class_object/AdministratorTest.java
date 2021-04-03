package com.woniu.chapter09_class_object;

public class AdministratorTest {
	public static void main(String[] args) {
		Administrator adm = new Administrator();
		adm.name = "admin1";
		adm.passWord = "111111";
		adm.show();
		
		Administrator adm2 = new Administrator();
		adm2.name = "admin2";
		adm2.passWord = "222222";
		adm2.show();
	}

}
