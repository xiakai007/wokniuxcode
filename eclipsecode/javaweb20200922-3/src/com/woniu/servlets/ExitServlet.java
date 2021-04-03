package com.woniu.servlets;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ExitServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	doPost(req,resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	HttpSession session=req.getSession();
    	ServletContext app=req.getServletContext();
    	if(app.getAttribute("online")!=null){
    		int count=(int)app.getAttribute("online");
    		count--;
    		app.setAttribute("online", count);
    	}
    	
    	session.removeAttribute("loginUser");
    	resp.sendRedirect("login.html");
    }
}
