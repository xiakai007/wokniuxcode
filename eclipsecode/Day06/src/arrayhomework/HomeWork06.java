package arrayhomework;

import java.util.Arrays;
import java.util.Scanner;

public class HomeWork06 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int []a = new int[4];
		for(int i = 0;i<a.length;i++) {
			System.out.println("请输入数组中的第"+(i+1)+"个数字：");
			a[i] = sc.nextInt();
		}
		sc.close();
		System.out.println(Arrays.toString(a));
		for(int i = 0;i<a.length-1;i++) {
			for(int j = 0;j<a.length-1-i;j++) {
				if(a[j]<a[j+1]) {
//					a[j] = a[j]^a[j+1];
//					a[j+1] = a[j]^a[j+1];
//					a[j] = a[j]^a[j+1];
					int temp = a[j];
					a[j] = a[j+1];
					a[j+1] = temp;
				}
			}
		}
		System.out.println(Arrays.toString(a));
	}

}
