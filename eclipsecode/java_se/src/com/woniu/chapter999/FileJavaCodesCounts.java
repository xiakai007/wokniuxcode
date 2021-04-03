package com.woniu.chapter999;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

class Codes{
	public  int counts;
	public  int getCounts(File file) {
		int count=0;
		try(BufferedReader br = new BufferedReader(new FileReader(file))){
			String str = br.readLine();
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
	public  void show(File file) {
		File[] fs = file.listFiles();
		for(File f:fs) {
			if(f.isFile()) {
				if(f.getName().endsWith(".java")) {
					int i = getCounts(f);
					counts +=i;
				}
			}else {
				show(f);
			}
		}
	}
	public  int getAllCount(File file) {
		show(file);
		return counts;
	}
}
public class FileJavaCodesCounts {
	public static void main(String[] args) {
		Codes codes = new Codes();
		File file = new File("D:\\software\\eclipse\\workspace_01");
		int counts = codes.getAllCount(file);
		System.out.println(counts);
	}

}
