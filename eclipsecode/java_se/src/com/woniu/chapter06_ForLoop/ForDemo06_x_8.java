package com.woniu.chapter06_ForLoop;

public class ForDemo06_x_8 {
	public static void main(String[] args) {
		int i,j,x = 0;
		for(i=0;i<2;i++) {
			x++;
			for(j=0;j<=3;j++) {
				if(j%2==0)continue;
				x++;
			}
			x++;
		}
		System.out.println(x);//8
	}

}
