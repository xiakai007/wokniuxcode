package com.woniu.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.templateresolver.ServletContextTemplateResolver;

import com.woniu.entities.Users;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		TemplateEngine engine = new TemplateEngine();
		ServletContextTemplateResolver resolver = new ServletContextTemplateResolver(req.getServletContext());
		resolver.setPrefix("/template/");
		resolver.setSuffix(".html");
		resolver.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		engine.setTemplateResolver(resolver);
		WebContext webContext= new WebContext(req, resp, req.getServletContext());
		req.setAttribute("message", "<b>legend</b>");
		webContext.setVariable("message1", "legue");
		req.setAttribute("user", new Users("admin","123456"));
		req.setAttribute("date",new Date());
		HttpSession session=req.getSession();
		session.setAttribute("loginUser", new Users("tom","654321"));
		resp.setContentType("text/html;charset=utf-8");
		ServletContext app=req.getServletContext();
		app.setAttribute("online", 10);
		List<Users> userList=new ArrayList<Users>();
		userList.add(new Users("tom","123qwe"));
		userList.add(new Users("jack","123asd"));
		userList.add(new Users("mike","123zxc"));
		req.setAttribute("userList", userList);
		engine.process("index", webContext, resp.getWriter());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
