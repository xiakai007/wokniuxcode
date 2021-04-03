package com.woniu.chapter22_Internet;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;
/**
 * 从客户端想服务端发信息
 * @author xiakai
 *
 */
public class ClientDemo {
	public static void main(String[] args) throws UnknownHostException, IOException {
		//创建客户端Socket对象client
		Socket client = new Socket("localhost",8888);
//		//创建输出流-方式一
//		try(OutputStream out = client.getOutputStream()) {
//			out.write("abc".getBytes());
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		//创建输出流-方式二
		OutputStream out = client.getOutputStream();
		//使用转换流将字节输出流转为字符输出流
		OutputStreamWriter osw = new OutputStreamWriter(out);
		try(BufferedWriter bw = new BufferedWriter(osw)){
			bw.write("中华民族的伟大复兴");
		}
		
		
		client.close();
	}

}
