package arrayhomework;

import java.util.Arrays;
import java.util.Scanner;

public class HomeWork07 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int []a = new int[4];
		for(int i = 0;i<a.length;i++) {
			System.out.println("请输入数组中的第"+(i+1)+"个数字：");
			a[i] = sc.nextInt();
		}
		sc.close();
		System.out.println(Arrays.toString(a));
		for(int left = 0,right = a.length-1;left<right;left++,right--) {
			a[left] = a[left]^a[right];
			a[right] = a[left]^a[right];
			a[left] = a[left]^a[right];
		}
		System.out.println(Arrays.toString(a));
	}

}
