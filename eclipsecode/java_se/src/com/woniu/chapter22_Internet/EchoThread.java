package com.woniu.chapter22_Internet;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

public class EchoThread implements Runnable {
	private Socket client = null;
	
	public EchoThread(Socket client) {
		super();
		this.client = client;
	}

	@Override
	public void run() {
		PrintStream out = null;//输出流
		BufferedReader buf = null;//接受客户端的信息，输入流
		
		boolean f = true;
		try {
			while(f) {//无限制接受客户端连接
				//得到客户端的输入信息
				buf = new BufferedReader(new InputStreamReader(client.getInputStream()));
				// 实例化客户端输出流
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
//				out.close();// 关闭输出流
//				client.close();// 关闭客户端
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
