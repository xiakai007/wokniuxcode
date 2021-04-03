package com.woniu.homework;
import java.util.Scanner;
public class Work6 {
    public static void main(String[] args) {
    	System.out.println("请输入数字或字母");
    	Scanner sc = new Scanner(System.in);
	    char ch = sc.nextLine().charAt(0);
	    if(ch>'A' && ch<'Z') {
	    	System.out.println(ch+"是大写字母,它的小写为："+(char)(ch+32));
	    }else if(ch>'a' && ch<'z') {
	    	System.out.println(ch+"是小写字母,它的大小写为："+(char)(ch-32));
	    }else if(ch>='0' && ch<='9') {
	    	int num = ch-48;
	    	System.out.println(ch+"数字字符是小写字母,它对应数字的平方值为："+num*num);
	    }else {
	    	System.out.println("非法字符");
	    }
	    sc.close();
}
}
