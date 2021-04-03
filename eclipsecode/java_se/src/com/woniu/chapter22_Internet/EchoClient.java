package com.woniu.chapter22_Internet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class EchoClient {
	public static void main(String[] args) throws UnknownHostException, IOException {
		Socket client = new Socket("localhost",8848);//客户端Socket对象，端口号8848
		//接受服务端处理后的信息
		BufferedReader br = new BufferedReader(new InputStreamReader(client.getInputStream()));
		//输出流，向服务端发送信息
		PrintStream out = new PrintStream(client.getOutputStream());
		//从键盘接收数据
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		boolean flag = true;
		while(flag) {
			System.out.println("请输入信息（输入bye结束）...");
			String str = input.readLine();
			out.println(str);
			if("bye".equals(str)) {
				flag = false;
			}else {
				String echo = br.readLine();
				System.out.println(echo);
			}
		}
		client.close();// 关闭Socket
		br.close();// 关闭输入流
		out.close();
	}

}
