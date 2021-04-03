package com.woniu.chapter12_override;

public class CodeST extends Template {
	@Override
	public void code() {
		String str = "";
		for(int i=0;i<50000;i++) {
			str +=i;
		}
		System.out.println(str);
	}

}
