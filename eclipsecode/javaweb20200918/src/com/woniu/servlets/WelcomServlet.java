package com.woniu.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class WelcomServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req,HttpServletResponse resp) throws IOException{
		System.out.println("你好");
		//设置响应内容的类型及编码
		resp.setContentType("text/html;charset=utf-8");
		//通过响应对象得到输出流对象
		PrintWriter out=resp.getWriter();
		//输出内容
		out.print("我来自服务器");
		out.print("<h3><i><u>我和我的祖国</u></i></h3>");
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}

}
