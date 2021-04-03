package com.woniu.chapter21_Thread;

public class Single {
	private static Single single = null;
	private Single() {
		
	}
	public static Single getInstance() {
//		if(single==null) {//非线程安全
//			single = new Single();
//		}
		if(single==null) {//线程安全且效率高
			synchronized(Single.class) {
				if(single==null) {
					single = new Single();
				}
			}
		}
		return single;
	}

}
