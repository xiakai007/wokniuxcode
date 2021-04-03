package com.woniu.chapter22_Internet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
/**
 * 读取客户端发来的信息
 * @author xiakai
 *
 */
public class ServerDemo {
	public static void main(String[] args) throws IOException {
		//创建服务端对象server
		ServerSocket server = new ServerSocket(8888);
		System.out.println("服务器已启动，读取客户端信息：");
		//获取服务端的对应的客户端镜像
		Socket client = server.accept();
//		//创建输入流-方式一
//		try(InputStream in = client.getInputStream()){
//			byte[] buf = new byte[1024];
//			int len;
//			while((len = in.read(buf))!=-1) {
//				System.out.println(new String(buf,0,len));
//			}
//		}
		//创建输入流-方式二
		InputStream in = client.getInputStream();
		//使用转换流将字节输入流转为字符输入流
		InputStreamReader isr = new InputStreamReader(in);
		try(BufferedReader br = new BufferedReader(isr)){
			String str = br.readLine();
			System.out.println(str);
		}
		
		server.close();
		client.close();
	}

}
