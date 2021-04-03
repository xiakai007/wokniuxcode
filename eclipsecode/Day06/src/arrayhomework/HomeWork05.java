package arrayhomework;

import java.util.Scanner;

public class HomeWork05 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int []a = new int[5];
		for(int i = 0;i<a.length;i++) {
			System.out.println("请输入数组中的第"+(i+1)+"个数字：");
			a[i] = sc.nextInt();
		}
		int max = a[0],min = a[0];
		for(int i = 1;i<a.length;i++) {
			if(a[i]>max) {
				max = a[i];
			}
			if(a[i]<min) {
				min = a[i];
			}
		}
		sc.close();
		System.out.println(max);
		System.out.println(min);
	}

}
