package com.woniu.servlets;

import java.io.IOException;
import java.io.PrintWriter;
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
       doPost(req,resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String oper=req.getParameter("oper");
		if(oper.equals("login")){
			String userName = req.getParameter("userName");
			String userPwd = req.getParameter("userPwd");
			UsersDao usersDao = new UsersDao();
			Users user = new Users(userName, userPwd);
			try {
				Users loginUser = usersDao.isExit(user);
				if (loginUser != null) {
					HttpSession session = req.getSession();
					session.setAttribute("loginUser", loginUser);

					ServletContext app = req.getServletContext();
					Integer count = 0;// 计数器
					if (app.getAttribute("online") != null) {
						count = (Integer) app.getAttribute("online");
					}
					count++;
					app.setAttribute("online", count);
					// 将登陆成功的用户名放到cookie中
					Cookie cookie = new Cookie("uname", userName);
					resp.addCookie(cookie);
					resp.sendRedirect("index.jsp");
				} else {
					resp.sendRedirect("login.jsp");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}else if(oper.equals("check")){
			String checkName=req.getParameter("checkName");
			   UsersDao usersDao = new UsersDao();
			try {
				boolean flag = usersDao.isProper(checkName);
				resp.setContentType("text/html;charset=utf-8");
				PrintWriter out=resp.getWriter();
				out.print(flag);
				out.flush();
				out.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}else if(oper.equals("add")){
			String newUserName=req.getParameter("newUserName");
			String newUserPwd1=req.getParameter("newUserPwd1");
			Users user=new Users(newUserName,newUserPwd1);
			UsersDao usersDao=new UsersDao();
			try {
				usersDao.addUser(user);
				resp.sendRedirect("login.jsp");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		

	}
}
