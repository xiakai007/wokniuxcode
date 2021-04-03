package arrayhomework;

import java.util.Arrays;
import java.util.Scanner;

public class HomeWork03 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int []a = new int[10];
		for(int i = 0;i<10;i++) {
			System.out.println("请输入a数组中的第"+(i+1)+"个数字：");
			a[i] = sc.nextInt();
		}
		sc.close();
		int []b = new int[a.length];
		for(int i = 0;i<a.length;i++) {
			b[i] = a[i];
		}
		System.out.println("b数组为："+Arrays.toString(b));
	}

}
