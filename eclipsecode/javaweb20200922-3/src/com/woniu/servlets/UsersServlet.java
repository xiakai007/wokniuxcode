package com.woniu.servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletContext;
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
    	String userName=req.getParameter("userName");
    	String userPwd=req.getParameter("userPwd");
    	UsersDao usersDao = new UsersDao();
    	Users user = new Users(userName,userPwd);
    	
		try {
			Users loginUser = usersDao.isExit(user);
			if(loginUser!=null){
				HttpSession session=req.getSession();
				session.setAttribute("loginUser", loginUser);
				
				ServletContext app=req.getServletContext();
				Integer count=0;//¼ÆÊýÆ÷
				if(app.getAttribute("online")!=null){
					count=(Integer)app.getAttribute("online");
				}
				count++;
				app.setAttribute("online", count);
				
	    		resp.sendRedirect("index.jsp");
	    	}else{
	    		resp.sendRedirect("login.html");
	    	}
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	
    }
}
