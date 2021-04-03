package com.woniu.chapter20_IO;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GoodsList {
	Goods good=null;
	List<Goods> goodsList = new ArrayList<>();
	public void getGood(File file) throws FileNotFoundException, IOException, ClassNotFoundException {
//		try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))){
//			good = (Goods)ois.readObject();
//		}
		try(BufferedReader br = new BufferedReader(new FileReader(file))){
			String str = br.readLine();
			String[] strs = str.split(",");
			while(str!=null) {
				good = new Goods(Integer.parseInt(strs[0]),strs[1],Double.parseDouble(strs[2]));
				goodsList.add(good);
			}
		}
		for(Goods good:goodsList) {
			System.out.println(good);
		}
	}
	
	public static void main(String[] args) throws FileNotFoundException, ClassNotFoundException, IOException {
		File file = new File("D:\\GoodsList.docx");
		GoodsList goodsL = new GoodsList();
		goodsL.getGood(file);
		
	}
	

}
