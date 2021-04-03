package com.woniu.chapter20_IO;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.junit.Test;

public class IOWork {
	@Test
	public void test3() {
		File srcDir = new File("D:\\File1\\File1-1\\File1-1-1\\File1-1-1-1\\Test1");
		File destDir = new File("E:\\File1\\File1-1\\File1-1-1\\File1-1-1-1\\Test1");
		File1.copyDir(srcDir, destDir);
	}
	@Test
	public void test2() {
//		File f = new File("D:\\File1\\File1-1");
//		File1.deleteFile(f);
	}
	@Test
	public void test1() {
		File f = new File("F:\\GameDownload\\英雄联盟");
		System.out.println(File1.fileSize(f));
		
	}

}
class File1{
	public static long getFileSize(File file) {
		if(file ==null||!file.exists()) 
			return 0;
		if(file.isFile()) 
			return file.length();
		File[] listFiles = file.listFiles();
		long size = 0;
		for(File f:listFiles) {
			size+=getFileSize(f);
		}
			return size;
	}
	public static void deleteFile(File file) {
		if(file==null||!file.exists())
			return;
		if(file.isFile()) {
			file.delete();
			return;
		}
		File[] listFiles = file.listFiles();
		for(File f:listFiles) {
			deleteFile(f);
		}
		file.delete();
	}
	public static String fileSize(File file) {
		double size = getFileSize(file);
		if(size<=1024) {
			return "1KB";
		}else if(size<1024*1024) {
			 return size/1024+"KB";
		}else if(size<1024*1024*1024) {
			return size/1024/1024+"MB";
		}else if(size<1024*1024*1024*1024) {
			return size*1.0/1024/1024/1024+"GB";
		}
		return null;
	}
	public static void copyFile(File source,File dest) {
		//1.创建文件的字节读写流
		try(FileInputStream fis = new FileInputStream(source);
			FileOutputStream fos = new FileOutputStream(dest)){
			//2.复制，边读边写
			byte[] buf = new byte[8192];//8KB缓冲区
			int len;
			while((len = fis.read(buf))!=-1) {
				fos.write(buf, 0, len);
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static void copyDir(File srcDir,File destDir) {
		if(srcDir==null||destDir==null||!srcDir.exists()||!srcDir.isDirectory()) {
			return;
		}
		if(!destDir.exists()) {
			destDir.mkdirs();
		}
		File[] listFiles = srcDir.listFiles();
		for(File f:listFiles) {
			if(f.isFile()) {
				copyFile(f,new File(destDir,f.getName()));
			}else {
				copyDir(f,new File(destDir,f.getName()));
			}
		}
	}
	
	
	
	
	
	
	
	
	
	
}