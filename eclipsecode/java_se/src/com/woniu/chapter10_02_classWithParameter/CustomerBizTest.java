package com.woniu.chapter10_02_classWithParameter;

import java.util.Scanner;

public class CustomerBizTest {
	public static void main(String[] args) {
		CustomerBiz cb = new CustomerBiz();
		Scanner sc = new Scanner(System.in);
		do {
			System.out.print("请输入客户的姓名：");
			cb.name = sc.nextLine();
			cb.addName(cb.name);
			System.out.print("继续输入吗（y/n）：");
			String answer = sc.nextLine();
			if(answer.equals("n")) {
				break;
			}
		}while(true);
		cb.showNames();
		sc.close();
		}
	}


