package com.woniu.demo;

public class StringDemo4 {
	public static void main(String[] args) {
		String s1 = "上海，你好";
		boolean flag = s1.startsWith("上海");//判断是否以上海开头
		System.out.println(flag);
		
		String []names = {"张三","李四","王五","张一","张二"};
		for(int i =0;i<names.length;i++) {
			if(names[i].startsWith("张")) {
				System.out.println(names[i]);
			}
		}
		
		String s2 = "今日作业.txt";
		System.out.println(s2.endsWith(".txt"));//判断是否以.txt结尾
		
		String []fileList = {"今日作业.txt","今日新闻.doc","今日新.jpg","今新闻.docx","今新闻.xls","朝闻天下.doc"};
		for(int i=0;i<fileList.length;i++) {
			if(fileList[i].endsWith(".doc")||fileList[i].endsWith(".docx")) {
				System.out.println(fileList[i]);
			}
		}
	}

}
