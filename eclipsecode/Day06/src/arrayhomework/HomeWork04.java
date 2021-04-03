package arrayhomework;

import java.util.Scanner;

public class HomeWork04 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int []a = new int[4];
		for(int i = 0;i<a.length;i++) {
			System.out.println("请输入数组中的第"+(i+1)+"个数字：");
			a[i] = sc.nextInt();
		}
		System.out.println("请输入要查找的整数：");
		int num = sc.nextInt();
		
		boolean flag = true;
		for(int i = 0;i<a.length;i++) {
			if(num != a[i]) 
				continue;
			System.out.println(i);
			flag = false;
			}
		if(flag) {
			System.out.println("没有找到该数字    "+-1);
		}
		sc.close();
		}
		
	}


