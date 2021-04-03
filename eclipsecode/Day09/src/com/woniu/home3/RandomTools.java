package com.woniu.home3;

import java.util.Arrays;
import java.util.Random;
import java.util.UUID;

public class RandomTools {
	/**
	 * 1.产生4位验证码
	 * @return
	 */
	public String getRandom4Code() {
		Random rd = new Random();
		String code = "";
		for(int i = 0;i<4;i++) {
			code += rd.nextInt(10);
		}
		return code;
	}
	
	/**
	 * 2.产生一个4位随机数1000-9999
	 * @return
	 */
	public int getRandom4Number() {
		Random rd = new Random();
		return rd.nextInt(9000)+1000;
	}
	
	/**
	 * 3.产生一个6位随机验证码，字母，数字
	 * @return
	 */
	public String getRandom6Code() {
		char []ch = new char[62];
		int index = 0;
		for(char i='a';i<='z';i++) {
			ch[index++]=i;
		}
		for(char i='0';i<='9';i++) {
			ch[index++]=i;
		}
		for(char i='A';i<='Z';i++) {
			ch[index++]=i;
		}
		Random rd = new Random();
		String code = "";
		for(int i=0;i<6;i++) {
			code += ch[rd.nextInt(62)];
		}
		return code;
	}
	
	/**
	 * 4.UUID 是一个32位的随机数
	 * @return
	 */
	public String getUUID() {
		String uuid = UUID.randomUUID().toString();
		return uuid.replace("-","");
	}
	
	public static void main(String[] args) {
		RandomTools rdt = new RandomTools();
		String rd4C = rdt.getRandom4Code();
		System.out.println(rd4C);
		System.out.println(rdt.getRandom6Code());
//		for(int i =0;i<50;i++) {
//			System.out.println(rdt.getRandom6Code());
//		}
		System.out.println(rdt.getUUID());
	}

}
