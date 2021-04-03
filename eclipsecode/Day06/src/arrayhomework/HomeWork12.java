package arrayhomework;

import java.util.Scanner;

public class HomeWork12 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int []a = new int[5];
		for(int i = 0;i<a.length;i++) {
			System.out.println("请输入第"+(i+1)+"个评委的打分：");
			a[i] = sc.nextInt();
		}
		int max = a[0],min = a[0];
		for(int i = 0;i<a.length;i++) {
			if(a[i]>max) {
				max = a[i];
			}
			if(a[i]<min) {
				min = a[i];
			}
		}
		int sum = 0;
		for(int i = 0;i<a.length;i++) {
			if(a[i]==max || a[i]==min) {
				continue;
			}
			sum += a[i];
		}
		System.out.println(sum);
		float avg = sum*1f/(a.length-2);
		System.out.println(avg);
		sc.close();
	}

}
