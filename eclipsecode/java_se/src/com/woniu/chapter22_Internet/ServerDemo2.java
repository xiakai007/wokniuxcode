package com.woniu.chapter22_Internet;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerDemo2 {
	public static void main(String[] args) throws IOException {
		ServerSocket server = new ServerSocket(1888);
		System.out.println("服务器启动");
		Socket client = server.accept();
//		OutputStream out = client.getOutputStream();
//		OutputStreamWriter osw = new OutputStreamWriter(out);
		try(BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()))){
			bw.write("陕西西安");
		}
		server.close();
	}

}
