package com.woniu.fordemo;
import java.util.Scanner;
public class ForDemo5 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入内容：");
		String str = sc.nextLine();
		int letter = 0,number = 0,blank = 0,chinese = 0,others = 0;
		for(int i = 0;i<str.length();i++) {
			char ch = str.charAt(i);
			if(ch>='a' && ch<='z' || ch>='A' && ch<='Z') {//字母
				letter++;
			}else if(ch>='0' && ch<='9') {//数字
				number++;
			}else if(ch==' ') {//空格
				blank++;
			}else if(ch>='\u4E00' && ch<='\u9AF5') {//汉字
				chinese++;
			}else {//其他
				others++;
			}
			
		}
		System.out.println("字母"+letter);
		System.out.println("数字"+number);
		System.out.println("空格"+blank);
		System.out.println("汉字"+chinese);
		System.out.println("其他"+others);
		sc.close();
	}
	

}
