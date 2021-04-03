package com.woniu.servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
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
				Integer count=0;//计数器
				if(app.getAttribute("online")!=null){
					count=(Integer)app.getAttribute("online");
				}
				count++;
				app.setAttribute("online", count);
				//将登陆成功的用户名放到cookie中
				Cookie cookie=new Cookie("uname", userName);
				resp.addCookie(cookie);
				
	    		resp.sendRedirect("index.jsp");
	    	}else{
	    		resp.sendRedirect("login.jsp");
	    	}
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	
    }
}
