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
		System.out.println("���");
		//������Ӧ���ݵ����ͼ�����
		resp.setContentType("text/html;charset=utf-8");
		//ͨ����Ӧ����õ����������
		PrintWriter out=resp.getWriter();
		//�������
		out.print("�����Է�����");
		out.print("<h3><i><u>�Һ��ҵ����</u></i></h3>");
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}

}
