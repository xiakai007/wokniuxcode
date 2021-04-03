package com.woniu.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONObject;

import com.woniu.daos.AdminDao;
import com.woniu.entities.Admin;

@WebServlet({ "/toLogin","/admin","/getSessionData" })
public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public AdminServlet() {
        super();
    }

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String path=req.getServletPath();
	       if(path.equals("/toLogin")){
	    	   String account=req.getParameter("account");
	           String password=req.getParameter("password");
	           Admin admin=new Admin(account,password);
	           AdminDao adminDao = new AdminDao();
	           try {
	        	   Admin loginAdmin=adminDao.isExit(admin);
	    		   resp.setContentType("text/html;charset=utf-8");
	    		   PrintWriter out=resp.getWriter();
	    		   if(loginAdmin!=null){
	    			   HttpSession session=req.getSession();
	    			   session.setAttribute("loginAdmin", loginAdmin);
	    			   out.print(true);
	    		   }else{
	    			   out.print(false);
	    		   }
	    		   out.flush();
	    		   out.close();
	    	   } catch (SQLException e) {
	    		  e.printStackTrace();
	    	   }
	       }else if(path.equals("/admin")){
	    	   String oper=req.getParameter("oper");
	    	   if(oper.equals("checkAccount")){
	    		   String account=req.getParameter("account");
	    		   AdminDao adminDao = new AdminDao();
	    		   resp.setContentType("text/html;charset=utf-8");
	        	   PrintWriter out=resp.getWriter();
	    		   try {
					boolean flag=adminDao.checkAccount(account);
					if(flag){
						out.print(true);
					}else{
						out.print(false);
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
	    	   }
	       }else if(path.equals("/getSessionData")){
	    	   HttpSession session=req.getSession();
	    	   Admin loginAdmin=(Admin)session.getAttribute("loginAdmin");
	    	   ServletContext app=req.getServletContext();
	    	   resp.setContentType("text/html;charset=utf-8");
	    	   PrintWriter out=resp.getWriter();
	    	   if(app.getAttribute("online")!=null){
	    		   int count=(Integer)app.getAttribute("online");
	        	   Map<String,Object> loginMap=new HashMap<>();
	        	   loginMap.put("online", count);
	        	   loginMap.put("loginAdmin", loginAdmin);
	        	   JSONObject loginObj = new JSONObject(loginMap);
	        	   out.print(loginObj);
	        	   out.flush();
	        	   out.close();
	    	   }
	       }
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
