package com.woniu.chapter999;

import java.io.File;

class Delete{
	public static void deleteAll(File file) {
		if(file.isFile()) {
			file.delete();
		}else {
			File[] subfs = file.listFiles();
			if(subfs.length>0) {
				for(File f:subfs) {
					deleteAll(f);
				}
			}else {
				file.delete();
			}
		}
	}
}
public class DeleteFile {

}
