package com.woniu.homework;
import java.util.Scanner;
public class Work3 {
   public static void main(String[] args) {
	   Scanner sc = new Scanner(System.in);
	   System.out.println("请输入java成绩：");
	   int java = sc.nextInt();
	   System.out.println("请输入音乐java成绩：");
	   int song = sc.nextInt();
	   if(java>98 && song>80) {
		   System.out.println("老师会奖励他");
	   }else if(java>100 && song>70) {
		   System.out.println("老师也会奖励他");
	   sc.close();
}
}
}
