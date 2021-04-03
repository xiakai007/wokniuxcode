package com.woniu.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.woniu.daos.UsersDao;
import com.woniu.entities.Users;

public class UsersServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	String userName =req.getParameter("userName");
    	String userPwd=req.getParameter("userPwd");
    	
    	UsersDao usd = new UsersDao();
    	Users user = new Users(userName,userPwd);
    	
    	
    	
    	boolean flag=usd.isExit(user);
    	if(flag){
    		resp.sendRedirect("cs.do");
    	}else{
    		resp.sendRedirect("login.html");
    	}
    	
    }
}
