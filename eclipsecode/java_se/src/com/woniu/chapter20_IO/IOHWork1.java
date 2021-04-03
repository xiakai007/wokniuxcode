package com.woniu.chapter20_IO;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import org.junit.Test;

public class IOHWork1 {
	@Test
	public void test6() {
		File f1 = new File("D:\\aa.txt");
		File f2 = new File("D:\\acopy.txt");
		boolean flag = f1.exists();
		System.out.println(flag);
		if(!flag) {
			try {
				f1.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		try(BufferedInputStream bis = new BufferedInputStream(new FileInputStream(f1));
			BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(f2))){
			byte[] buf = new byte[8192];
			int len;
			while((len=bis.read(buf))!=-1) {
				bos.write(buf, 0, len);
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	@Test
	public void test5() {
		File f = new File("D:\\test\\my.txt");
		if(f.exists()) {
			f.delete();
			System.out.println("文件my.txt删除成功");
			String strF = f.getParent();
			File f2 = new File(strF);
			f2.delete();
			System.out.println("文件夹test删除成功");
			
		}else {
			if(f.getParentFile().exists()) {
				try {
					f.createNewFile();
					System.out.println("文件my.txt创建成功");
				}catch(IOException e){
					e.printStackTrace();
				}
			}else {
				f.getParentFile().mkdirs();
				System.out.println("文件夹test创建成功");
				try {
					f.createNewFile();
				}catch(IOException e){
					e.printStackTrace();
				}
				System.out.println("文件my.txt创建成功");
			}
		}
	}
	@Test
	public void test4() {
		//获取文件路径
		File f = new File("D:");
		ArrayList<File> list = new ArrayList<>();
		File[] fs = f.listFiles();
		for (int i = 0; i < fs.length; i++) {
			if(fs[i].isFile()) {
				list.add(fs[i]);
				if(list.get(i).getName().endsWith(".txt")) {
					System.out.println(list.get(i).getName());
				}
				
			}
		}
		
	}
	@Test
	public void test3() {
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入3个整数：");
//		String no = sc.next();
		File f = new File("D:\\hello1.txt");
		try(BufferedWriter bw = new BufferedWriter(new FileWriter(f));
				BufferedReader br = new BufferedReader(new FileReader(f))){
			for(int i=0;i<3;i++) {
				String no = sc.next();
				bw.write(no);
				bw.newLine();
			}
			bw.flush();
			String itg = null;
			while((itg=br.readLine())!=null) {
				System.out.println(itg);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		sc.close();
	}
	
	@Test
	public void test2() {
		File f1 = new File("D:\\hello.txt");
		File f2 = new File("E:\\hello1.txt");
		try(BufferedInputStream bis = new BufferedInputStream(new FileInputStream(f1));
		BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(f2))){
			byte[] buf = new byte[8192];
			int len;
			while((len=bis.read(buf))!=-1) {
				bos.write(buf, 0, len);
				bos.flush();
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	@Test
	public void test1() {
		String[] strs = new String[10];
		File f = new File("D:\\test.txt");
		try(BufferedReader br = new BufferedReader(
				new FileReader(f))){
			String str;
			int i = 0;
			while((str=br.readLine())!=null) {
				strs[i] = str;
				i++;
			}
//			System.out.println(Arrays.toString(strs));
			for(int j=0;j<strs.length;j++) {
				if(strs[j]!=null) {
					System.out.println(strs[j]);
				}
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
