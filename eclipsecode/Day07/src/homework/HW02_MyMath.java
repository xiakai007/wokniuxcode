package homework;

import java.util.Arrays;

public class HW02_MyMath {
	public void factorial(int x) {
		if(x<0) {
			System.out.println("负数没有阶乘！");
		}else if(x==0) {
			System.out.println(x+"的阶乘结果为"+1);
		}else {
			double sum = 1;
			for(int i = 1;i<=x;i++) {
				sum *= i;
			}
			System.out.println(x+"的阶乘结果为"+sum);
		}
		
	}
	public void narcissus(int x) {
		if(x<100 || x>=1000) {
			System.out.println(false);
		}else {
			int ge = x%10;
			int shi = x/10%10;
			int bai = x/100;
			if(x == ge*ge*ge+shi*shi*shi+bai*bai*bai) {
				System.out.println(true);
			}
		}
	}
//	public void array(int []arr = new int [x]) {
//		for(int left = 0,right = arr.length-1;left<right;left++,right--) {
//			a[left] = a[left]^a[right];
//			a[right] = a[left]^a[right];
//			a[left] = a[left]^a[right];
//		}
//		System.out.println(Arrays.toString(arr));
//	}

}
