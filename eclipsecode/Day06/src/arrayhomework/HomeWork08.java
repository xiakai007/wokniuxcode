package arrayhomework;

import java.util.Arrays;
import java.util.Scanner;

public class HomeWork08 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入一串字符：");
		String str = sc.nextLine();
		char []ch1 = new char[str.length()];
		char []ch2 = new char[str.length()];
		int count1 = 0,count2 = 0;
		for(int i = 0;i<str.length();i++) {
			char ch = str.charAt(i);
			if(ch>='a' && ch<='z' || ch>='A' && ch<='Z' || ch>='0' && ch<='9' || ch>='\u4E00' && ch<='\u9FEF') {
				ch1[count1]= ch;
				count1++;
			}else {
				ch2[count2]= ch;
				count2++;
			}
			
		}
		if(count1 == 0) {
			System.out.println("没有字母、数字及中文字符");
		}else {
			System.out.println(Arrays.toString(ch1));
		}
		if(count2 == 0) {
			System.out.println("没有特殊字符");
		}else {
			System.out.println(Arrays.toString(ch2));
		}
		sc.close();
	}

}
