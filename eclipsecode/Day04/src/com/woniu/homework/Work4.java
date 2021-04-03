package com.woniu.homework;
import java.util.Scanner;
public class Work4 {
	public static void main(String[] args) {
		float money = 200;
		float discount = 1;
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入：");
		char vip = sc.nextLine().charAt(0);
		if(vip =='n') {
			discount = money>100?0.9F:1;
			System.out.println("购买原价"+money+"元，打"+discount*10+"折，折后价位："+money*discount+"元");
		}else {
			System.out.println("请输入会员积分：");
			int score = sc.nextInt();
			if(score>=8000) {
				discount = 0.6F;
			}else if(score>=4000 && score<8000) {
				discount = 0.7F;
			}else if(score>=2000 && score<4000) {
				discount = 0.8F;
			}else if(score>=0 && score<2000) {
				discount = 0.9F;
			}else {
				System.out.println("不能为负");
				sc.close();
				return;
			}
			System.out.println("会员积分："+score+"，可以享受"+discount*10+"折优惠，折后价位："+
			(int)(money*discount)+"元");
		}
		sc.close();
	}
}
