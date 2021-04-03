package com.woniu.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet({"/login","/index","/typesUI","/supplierUI","/goodsUI","/userUI","/pwdUpd","/instockUI"})
public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DispatcherServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String path=req.getServletPath();
		//System.out.println(path);
		if(path.equals("/login")){
			req.getRequestDispatcher("/WEB-INF/login.html").forward(req, resp);
		}else if(path.equals("/index")){
			req.getRequestDispatcher("/WEB-INF/index.html").forward(req, resp);
		}else if(path.equals("/typesUI")){
			req.getRequestDispatcher("/WEB-INF/goodsType.html").forward(req, resp);
		}else if(path.equals("/supplierUI")){
			req.getRequestDispatcher("/WEB-INF/supplier.html").forward(req, resp);
		}else if(path.equals("/goodsUI")){
			req.getRequestDispatcher("/WEB-INF/goods.html").forward(req, resp);
		}else if(path.equals("/userUI")){
			req.getRequestDispatcher("/WEB-INF/user.html").forward(req, resp);
		}else if(path.equals("/pwdUpd")){
			req.getRequestDispatcher("/WEB-INF/pwdUpd.html").forward(req, resp);
		}else if(path.equals("/instockUI")){
			req.getRequestDispatcher("/WEB-INF/instock.html").forward(req, resp);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
