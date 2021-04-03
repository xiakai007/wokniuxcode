package com.woniu.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONObject;

import com.woniu.daos.UsersDao;
import com.woniu.entities.PageBean;
import com.woniu.entities.Users;
@WebServlet({"/toLogin","/getSessionData","/user","/savePwd"})
public class UsersServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       String path=req.getServletPath();
       if(path.equals("/toLogin")){
    	   String userName=req.getParameter("userName");
           String userPwd=req.getParameter("userPwd");
           Users user=new Users(userName,userPwd);
           UsersDao usersDao = new UsersDao();
           try {
    		   Users loginUser=usersDao.isExit(user);
    		   resp.setContentType("text/html;charset=utf-8");
    		   PrintWriter out=resp.getWriter();
    		   if(loginUser!=null){
    			   HttpSession session=req.getSession();
    			   session.setAttribute("loginUser", loginUser);
    			   out.print(true);
    		   }else{
    			   out.print(false);
    		   }
    		   out.flush();
    		   out.close();
    	   } catch (SQLException e) {
    		  e.printStackTrace();
    	   }
       }else if(path.equals("/getSessionData")){
    	   HttpSession session=req.getSession();
    	   Users loginUser=(Users)session.getAttribute("loginUser");
    	   ServletContext app=req.getServletContext();
    	   resp.setContentType("text/html;charset=utf-8");
    	   PrintWriter out=resp.getWriter();
    	   if(app.getAttribute("online")!=null){
    		   int count=(Integer)app.getAttribute("online");
        	   Map<String,Object> loginMap=new HashMap<>();
        	   loginMap.put("online", count);
        	   loginMap.put("loginUser", loginUser);
        	   JSONObject loginObj = new JSONObject(loginMap);
        	   out.print(loginObj);
        	   out.flush();
        	   out.close();
    	   }
       }else if(path.equals("/user")){
    	   String oper=req.getParameter("oper");
    	   if(oper.equals("userlist")){
    		   String user_name=req.getParameter("user_name");
    		   Users userQue = new Users(user_name);
    		   UsersDao usersDao = new UsersDao();
    		   PageBean<Users> pageBean=new PageBean<>();
    		   int pageSize=3;
    		   pageBean.setPageSize(pageSize);
    		   try {
				int totalCount=usersDao.getAllCount(userQue);
				pageBean.setTotalCount(totalCount);
				int currentPage=1;
				if(req.getParameter("currentPage")!=null&&!req.getParameter("currentPage").equals("")){
					currentPage=Integer.parseInt(req.getParameter("currentPage"));
				}
				if(currentPage<1){
					currentPage=1;
				}
				if(currentPage>pageBean.getPages()){
					currentPage=pageBean.getPages();
					if(pageBean.getPages()==0){
						currentPage=1;
					}
				}
				pageBean.setCurrentPage(currentPage);
				List<Users> pageData=usersDao.getAllUsers(userQue,pageBean);
				pageBean.setPageData(pageData);
				JSONObject userJsonObj = new JSONObject(pageBean);
				resp.setContentType("text/html;charset=utf-8");
				PrintWriter out=resp.getWriter();
				out.print(userJsonObj);
				out.flush();
				out.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
    		   
    	   }else if(oper.equals("updStatus")){
    		   String user_id=req.getParameter("user_id");
    		   String user_status=req.getParameter("status");
    		   UsersDao usersDao = new UsersDao();
    		   resp.setContentType("text/html;charset=utf-8");
			   PrintWriter out=resp.getWriter();
    		   try {
				usersDao.updateStatus(Integer.parseInt(user_id),user_status);
				out.print("更改成功");
				out.flush();
				out.close();
			} catch (NumberFormatException e) {
				e.printStackTrace();
				out.print("更改失败");
			} catch (SQLException e) {
				e.printStackTrace();
				out.print("更改失败");
			}
    	   }else if(oper.equals("resetPwd")){
    		   String user_id=req.getParameter("user_id");
    		   UsersDao usersDao = new UsersDao();
    		   try {
				usersDao.resetPwdById(Integer.parseInt(user_id));
				resp.setContentType("text/html;charset=utf-8");
				PrintWriter out=resp.getWriter();
				out.print("密码已重置");
				out.flush();
				out.close();
			} catch (NumberFormatException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
    	   }else if(oper.equals("checkPwd")){
    		   String oldPwd=req.getParameter("oldPwd");
    		   HttpSession session=req.getSession();
    		   Users loginUser=(Users)session.getAttribute("loginUser");
    		   resp.setContentType("text/html;charset=utf-8");
        	   PrintWriter out=resp.getWriter();
        	   if(oldPwd.equals(loginUser.getUser_pwd())){
        		   out.print(true);
        	   }else{
        		   out.print(false);
        	   }
    	   }else if(oper.equals("updatePwd")){
    		   String newPwd=req.getParameter("newPwd");
    		   HttpSession session=req.getSession();
    		   Users loginUser=(Users)session.getAttribute("loginUser");
    		   Integer user_id=loginUser.getUser_id();
    		   UsersDao usersDao = new UsersDao();
    		   resp.setContentType("text/html;charset=utf-8");
        	   PrintWriter out=resp.getWriter();
    		   try {
				usersDao.updateUserPwd(user_id,newPwd);
				session.removeAttribute("loginUser");
				out.print("密码修改成功");
			} catch (SQLException e) {
				e.printStackTrace();
			}
    	   }else if(oper.equals("checkUserName")){
    		   String userName=req.getParameter("userName");
    		   UsersDao usersDao = new UsersDao();
    		   resp.setContentType("text/html;charset=utf-8");
        	   PrintWriter out=resp.getWriter();
    		   try {
				boolean flag=usersDao.checkUserName(userName);
				if(flag){
					out.print(true);
				}else{
					out.print(false);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
    	   }
       }
	   
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);

	}
}
