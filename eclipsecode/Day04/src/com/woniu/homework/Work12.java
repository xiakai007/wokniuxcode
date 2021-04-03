package com.woniu.homework;
//等腰三角形
public class Work12 {
	public static void main(String[] args) {
		int i = 1;
		while(i<=4) {
			int blk = 1;
			while(blk<=4-i) {
				System.out.print("  ");
				blk++;
			}
			int j = 1;
			while(j<=2*i-1) {
				System.out.print("* ");
				j++;
			}
			System.out.println();
			i++;
		}
	}

}
