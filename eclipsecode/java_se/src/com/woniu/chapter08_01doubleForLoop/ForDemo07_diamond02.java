package com.woniu.chapter08_01doubleForLoop;

import java.util.Scanner;

public class ForDemo07_diamond02 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入空心菱形的半行数：");
		int row = sc.nextInt();
		for(int i =0;i<row;i++) {
			for(int j = 0;j<row-i-1;j++) {
				System.out.print(" ");
			}
			for(int k = 0;k<2*i+1;k++) {
//				if(i==0) {
//					System.out.print("*");
//				}else 
				if(k==0||k==2*i) {
					System.out.print("*");
				}else {
					System.out.print(" ");
				}
			}
			System.out.println();
		}
		for(int i =0;i<row-1;i++) {
			for(int j = 0;j<i+1;j++) {
				System.out.print(" ");
			}
			for(int k = 0;k<2*(row-1-i)-1;k++) {
//				if(i==row-1-1) {
//					System.out.print("*");
//				}else 
				if(k==0||k==2*(row-1-i)-2) {
					System.out.print("*");
				}else {
					System.out.print(" ");
				}
			}
			System.out.println();
		}
		
		System.out.println("请输入实心菱形的半行数：");
		int row2 = sc.nextInt();
		for(int i =0;i<row2;i++) {
			for(int j = 0;j<row2-i-1;j++) {
				System.out.print(" ");
			}
			for(int k = 0;k<2*i+1;k++) {
				System.out.print("*");
			}
			System.out.println();
		}
		for(int i =0;i<row2-1;i++) {
			for(int j = 0;j<i+1;j++) {
				System.out.print(" ");
			}
			for(int k = 0;k<2*(row2-1-i)-1;k++) {
				System.out.print("*");
			}
			System.out.println();
		}
		sc.close();
	}

}
