package com.woniu.servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.woniu.daos.UsersDao;
import com.woniu.entities.Users;

public class UsersServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	String userName=req.getParameter("userName");
    	String userPwd=req.getParameter("userPwd");
    	UsersDao usersDao = new UsersDao();
    	Users user = new Users(userName,userPwd);
    	boolean flag;
		try {
			flag = usersDao.isExit(user);
			if(flag){
	    		resp.sendRedirect("index.jsp");
	    	}else{
	    		resp.sendRedirect("login.html");
	    	}
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	
    }
}
