package com.woniu.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.woniu.daos.UsersDao;

public class CheckUserServlet extends HttpServlet {
   @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	   String checkName=req.getParameter("checkName");
	   UsersDao usersDao = new UsersDao();
	   boolean flag;
	try {
		flag = usersDao.isProper(checkName);
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out=resp.getWriter();
		out.print(flag);
		out.flush();
		out.close();
	} catch (SQLException e) {
		e.printStackTrace();
	}
		
	}
    
   @Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	   doGet(req,resp);
   }
}
