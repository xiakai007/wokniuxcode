package arrayhomework;

import java.util.Scanner;

public class HomeWork01 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int sum = 0;
		int [] score = new int [8];
		for(int i = 0;i<8;i++) {
			System.out.println("请输入第"+(i+1)+"个学生的成绩：");
			score [i] = sc.nextInt();
			sum += score[i];
		}
		System.out.println("8个学生的总分："+sum);
		System.out.println("8个学生的平均总分："+sum/8f);
		int max = score[0],min = score[0];
		for(int i =1;i<score.length;i++) {
			if(score[i]>max) {
				max = score[i];
			}
			if(score[i]<min) {
				min = score[i];
			}
		}
		System.out.println("最高分："+max);
		System.out.println("最低分："+min);
		sc.close();
	}

}
