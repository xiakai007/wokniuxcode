package arrayhomework;

import java.util.Arrays;
import java.util.Scanner;

public class HomeWork09 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入一段文字：");
		String str = sc.nextLine();
		char []ch = new char[str.length()];
		for(int i = 0;i<str.length();i++) {
			ch[i] = str.charAt(i);
		}
		System.out.println(Arrays.toString(ch));
		int count = 0;
		System.out.println("请输入需要查找的字符：");
		String str2 = sc.nextLine();
		char ch2 = str2.charAt(0);
		for(int i = 0;i<ch.length;i++) {
			if(ch[i]==ch2) {
				count++;
			}
		}
		sc.close();
		System.out.println(count);
	}

}
