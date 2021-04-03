package com.woniu.chapter22_Internet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {
	public static void main(String[] args) throws IOException {
		ServerSocket server = null;//服务端对象
		server = new ServerSocket(8848);//端口号8848
		Socket client = null;//客户端对象
		PrintStream out = null;//输出流
		BufferedReader buf = null;//输入流
		
		boolean f = true;
		while(f) {//无限制接受客户端连接
			System.out.println("服务器已运行，等待客户端连接");
			client = server.accept();//接受客户端连接
			System.out.println("客户端已连接"+client.getInetAddress());
			//得到客户端的输入信息
			buf = new BufferedReader(new InputStreamReader(client.getInputStream()));
			out = new PrintStream(client.getOutputStream());
			boolean flag = true;
			while(flag) {//客户端循环操作
				String str = buf.readLine();//不间断接受客户端信息
				if(str==null||"".equals(str)||"bye".equals(str)) {
					flag = false;//客户端操作结束
				}else {
					out.println("ECHO"+str);//向客户端发送处理后的信息
				}
			}
			out.close();
			client.close();
		}
		server.close();
	}
}
