package com.woniu.homework;



public class Work10 {
	public static void main(String[] args) {
		
		int i = 1;
		while(i <= 4) {
			int blk = 1;
			while(blk <= 4-i) {
				System.out.print("  ");
				blk++;
			}
			int star = 1;
			while(star <= 2*i-1) {
				System.out.print("* ");
				star++;
			}
			System.out.println();
			
			
			i++;
		}
		
	}

}
