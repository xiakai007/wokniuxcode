package com.woniu.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.woniu.daos.UsersDao;
import com.woniu.entities.Users;

public class RegisterUserServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	UsersDao usd = new UsersDao();
    	req.setCharacterEncoding("utf-8");
    	String userName=req.getParameter("newUserName");
    	String userPwd1=req.getParameter("newUserPwd1");
    	Users user = new Users(userName,userPwd1);
    	boolean flag=usd.checkUserName(user);
    	if(flag){
    		usd.addUser(user);
    		resp.setContentType("text/html;charset=utf-8");
    		PrintWriter out=resp.getWriter();
    		out.print("新增一名用户成功");
    	}else{
    		resp.setContentType("text/html;charset=utf-8");
    		PrintWriter out=resp.getWriter();
    		out.print("JAVA-用户名已存在！");
    	}
    	
    	
    }
}
