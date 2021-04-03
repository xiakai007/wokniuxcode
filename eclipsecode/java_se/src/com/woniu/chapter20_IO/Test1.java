package com.woniu.chapter20_IO;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
class Copy{
	public static void copyDir(File srcDir,File destDir) {
		if(!srcDir.exists()||!srcDir.isDirectory()||srcDir==null||destDir==null) {
			return;
		}
		if(!destDir.exists()) {
			destDir.mkdirs();
		}
		File[] listFiles = srcDir.listFiles();
		for(File file:listFiles) {
			if(file.isFile()) {
				copyFile(file,new File(destDir,file.getName()));
			}else {
				copyDir(file,new File(destDir,file.getName()));
			}
		}
	}

	public static void copyFile(File source, File dest) {
		try(BufferedInputStream bis = new BufferedInputStream(new FileInputStream(source));
				BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(dest))){
			byte[] buf = new byte[1024];
			int len;
			while((len = bis.read(buf))!=-1) {
				bos.write(buf, 0, len);
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
public class Test1 {
	public static void main(String[] args) {
		
	}

}
