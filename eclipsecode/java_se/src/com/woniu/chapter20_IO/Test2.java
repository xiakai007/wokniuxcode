package com.woniu.chapter20_IO;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

class MyPra1{
	public void showRows(File file) {
		int count=0;
		try(BufferedReader br=new BufferedReader(new FileReader(file))) {
			String words=br.readLine();
			while(words!=null) {
				if(!words.equals("")) {
					count++;
				}
				words=br.readLine();
			}
			System.out.println(file.getName()+"¹²ÓÐ"+count+"ÐÐ");
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
}
public class Test2 {
	public static void main(String[] args) {
		File file=new File("D:\\software\\eclipse\\workspace_01\\java_chess\\src\\com\\woniu\\chess\\ui\\MainApp.java");
		MyPra1 mp1 = new MyPra1();
		mp1.showRows(file);
	}

}
