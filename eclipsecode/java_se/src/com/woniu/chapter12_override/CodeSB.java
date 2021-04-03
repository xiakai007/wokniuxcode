package com.woniu.chapter12_override;

public class CodeSB extends Template {
	@Override
	public void code() {
		StringBuffer sb = new StringBuffer("");
		for(int i=0;i<50000;i++) {
			sb.append(i);
			
		}
	}

}
