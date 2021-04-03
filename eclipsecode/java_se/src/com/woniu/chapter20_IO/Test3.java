package com.woniu.chapter20_IO;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

class MyCodes{
	int counts=0;
	public int getCounts(File file) {
		int count=0;
		try(BufferedReader br=new BufferedReader(new FileReader(file))){
			String rst=br.readLine();
			while(rst!=null) {
				if(!rst.equals("")) {
					count++;
				}
				rst=br.readLine();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return count;
	}
	public void showFile(File file) throws IOException {
		File[] fs=file.listFiles();
		for(File fi:fs) {
			if(fi.isFile()) {
				if(fi.getName().endsWith(".java")) {
					int i=getCounts(fi);
					counts +=i;
				}
			}else {
				showFile(fi);
			}
		}
	}
	public int getTotalCounts(File file) throws IOException {
		showFile(file);
		return counts;
	}
}
public class Test3 {
	public static void main(String[] args) throws IOException {
		MyCodes mcs = new MyCodes();
		File file=new File("D:\\software\\eclipse\\workspace_01");
		int count=mcs.getTotalCounts(file);
		System.out.println(file.getName()+"共有"+count+"行java代码");
	}

}
