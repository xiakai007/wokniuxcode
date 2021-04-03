package com.woniu.chapter22_Internet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientDemo2 {
	public static void main(String[] args) throws UnknownHostException, IOException {
		Socket client = new Socket("localhost",1888);
		try(BufferedReader br = new BufferedReader(new InputStreamReader(client.getInputStream()))){
			String res = br.readLine();
			System.out.println(res);
		}
//		InputStream in = client.getInputStream();
//		byte[] buf = new byte[1024];
//		int len;
//		while((len=in.read(buf))!=-1) {
//			System.out.println(new String(buf,0,len));
//		}
//		in.close();
		client.close();
	}

}
