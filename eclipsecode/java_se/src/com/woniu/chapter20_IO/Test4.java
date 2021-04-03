package com.woniu.chapter20_IO;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

class MyPra2{
	int sumCounts=0;
	public int getCount(File file) {
		int count=0;
		try(BufferedReader br=new BufferedReader(new FileReader(file))) {
			String str=br.readLine();
			while(str!=null) {
				if(!str.equals("")) {
					count++;
				}
				str=br.readLine();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return count;
	}
	public void showFiles(File file) {
		File[] fs=file.listFiles();
		for(File fi:fs) {
			if(fi.isFile()) {
				if(fi.getName().endsWith(".java")) {
					int count=getCount(fi);
					sumCounts +=count;
				}
			}else {
				showFiles(fi);
			}
		}
		
	}
	public void getTotalCounts(File file) {
		showFiles(file);
		System.out.println(sumCounts);
	}
}
public class Test4 {
	public static void main(String[] args) {
		MyPra2 mp2 = new MyPra2();
		File file=new File("D:\\software\\eclipse");
		mp2.getTotalCounts(file);
		
	}

}
