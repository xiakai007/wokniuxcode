package com.woniu.chapter10_02_classWithParameter;

public class CustaPa {
	Custa[] custs = new Custa[30];

	public void addCust(Custa cust) {
		for (int i = 0; i < custs.length; i++) {
			if (custs[i] == null) {
				custs[i] = cust;
				break;
			}
		}
	}

	public void showCusts() {
		System.out.println("客户信息：");
		System.out.println("会员号\t姓名\t性别\t年龄\t是否会员");
		for (int i = 0; i < custs.length; i++) {
			if (custs[i] != null) {
				custs[i].showInfo();
			}
		}
	}

}
