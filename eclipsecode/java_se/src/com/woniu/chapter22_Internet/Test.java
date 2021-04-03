package com.woniu.chapter22_Internet;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.URL;
import java.net.UnknownHostException;

public class Test {
	public static void main(String[] args) throws IOException {
//		//获取本机地址
//		InetAddress locAdd = InetAddress.getLocalHost();
//		System.out.println("本机地址："+locAdd.getHostAddress());
//		System.out.println("本机域名："+locAdd.getHostName());
//		//获取远程地址
//		InetAddress remAdd = InetAddress.getByName("www.mi.com");
//		System.out.println("远程域名"+remAdd.getHostName());
//		System.out.println("远程地址"+remAdd.getHostAddress());
//		//是否可达
//		System.out.println("本机是否可达."+locAdd.isReachable(5000));
		URL url = new URL("http://172.16.7.175:8080/EasyBuy/statics/images/ban1.jpg");
		HttpURLConnection urlCon = (HttpURLConnection) url.openConnection();
		System.out.println("大小："+urlCon.getContentLength());
		System.out.println("类型："+urlCon.getContentType());
		urlCon.connect();
		//输入流
		InputStream is = urlCon.getInputStream();
		//字节输出流写图片
		FileOutputStream fos = new FileOutputStream("新鲜.jpg");
		byte[] buf = new byte[1024];
		int len;
		while((len = is.read(buf))!=-1) {
			fos.write(buf, 0,len);
		}
//		System.out.println(fos);
		urlCon.disconnect();
	}

}
