package com.woniu.chapter22_Internet;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoThreadServer {
	public static void main(String[] args) throws IOException {
		ServerSocket server = new ServerSocket(8848);
		Socket client = null;
		boolean flag = true;
		while(flag) {
			System.out.println("服务器已启动，等待客户端连接...");
			client = server.accept();//接受客户端连接
			new Thread(new EchoThread(client)).start();//多线程执行客户端请求
		}
		server.close();
	}

}
