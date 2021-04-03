package com.isoftstone.humanresources.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class CsvReadUtil {

	   public static List<List<Object>> readCsv(InputStream in) throws IOException {
			BufferedReader br = null;
				br = new BufferedReader(new InputStreamReader(in,"utf-16le"));
			String line = "";
			List<List<Object>> allString = new ArrayList<>();
			int lineSize = 0;
			try {
				
				while (!StringUtil.isEmpty(line = br.readLine())) // 读取到的内容给line变量
				{
					lineSize++;
					if(lineSize == 1){
						continue;
					}
					List<Object> li = new ArrayList<>();
					String lsp[] = line.split(",",-1);
					for (int i = 0; i < lsp.length; i++) {
						li.add(getCellValue(lsp[i]));
					}
					allString.add(li);
				}
			} catch (IOException e) {
			}finally {
					br.close();
			}
			return allString;
	        
	    }
	   
	   /**
	     * 描述：对表格中数值进行格式化
	     * @param cell
	     * @return
	     */
	    public static  Object getCellValue(String cell){
	        Object value = null;
	        if(null == cell){
	        	return "";
	        }
	        value = cell;
	        return value;
	    }
	   
}
