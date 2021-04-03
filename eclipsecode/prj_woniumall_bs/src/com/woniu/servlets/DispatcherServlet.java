package com.woniu.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet({"/login","/index","/categoryUI","/goodsUI"})
public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public DispatcherServlet() {
        super();
    }

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String path=req.getServletPath();
		if(path.equals("/login")){
			req.getRequestDispatcher("/WEB-INF/login.html").forward(req, resp);
		}else if(path.equals("/index")){
			req.getRequestDispatcher("/WEB-INF/index.html").forward(req, resp);
		}
		else if(path.equals("/categoryUI")){
			req.getRequestDispatcher("/WEB-INF/category.html").forward(req, resp);
		}else if(path.equals("/goodsUI")){
			req.getRequestDispatcher("/WEB-INF/goods.html").forward(req, resp);
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
