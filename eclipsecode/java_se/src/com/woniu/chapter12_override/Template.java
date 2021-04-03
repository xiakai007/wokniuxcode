package com.woniu.chapter12_override;

public abstract class Template {
	public final void getTime() {
		long start = System.currentTimeMillis();
		code();
		long end = System.currentTimeMillis();
		System.out.println(end - start);
	}
	public abstract void code();
	class CodeST extends Template {
		@Override
		public void code() {
			String str = "";
			for(int i=0;i<50000;i++) {
				str +=i;
			}
			System.out.println(str);
		}

	}
	class CodeSB extends Template {
		@Override
		public void code() {
			StringBuffer sb = new StringBuffer("");
			for(int i=0;i<50000;i++) {
				sb.append(i);
				
			}
		}

	}
}
