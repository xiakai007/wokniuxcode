package com.woniu.chapter03;

public class IfDemo03 {
	public static void main(String[] args) {
		int x = 1;
		int y = 1;
		// & 逻辑与，两边都执行
		/**
		 * x++ == 2有两个操作：先执行==,判断1 == 2；在执行++，x的值变为2；
		 * ++y == 2有两个操作：先执行++,y的值变为2；在判断2 == 2；
		 * if(false & ture)
		 * if(false)
		 */
		if (x++ == 2 & ++y == 2) {
			x = 7;//不执行
		}
		System.out.println("x=" + x + ",y=" + y);//x=2,y=2
		// && 短路逻辑与，事件1为假时事件2不执行
				/**
				 * x++ == 2有两个操作：先执行==,判断1 == 2；在执行++，x的值变为2；
				 * ++y == 2有两个操作：++ 和 ==；
				 * if(false &&) ++y被短路，不执行
				 * if(false)
				 */
				if (x++ == 3 && ++y == 3) {
					x = 7;//不执行
				}
		System.out.println("x=" + x + ",y=" + y);//x=3,y=2
		// | 逻辑或，事件1、事件2都执行
		// || 短路逻辑或，事件1为真时事件2不执行
	}

}
