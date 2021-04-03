package com.woniu.chapter10_02_classWithParameter;

public class CustaPaTest {
	public static void main(String[] args) {
		Custa custb1 = new Custa();
		custb1.mberID = 1001;
		custb1.name = "王一";
		custb1.age = 30;
		custb1.gender = "男";
		custb1.flagMemb = false;
		Custa custb2 = new Custa();
		custb2.mberID = 1002;
		custb2.name = "关羽";
		custb2.age = 36;
		custb2.gender = "女";
		custb2.flagMemb = true;
		CustaPa cusP = new CustaPa();
		cusP.addCust(custb1);
		cusP.addCust(custb2);
		cusP.showCusts();
	}

}
