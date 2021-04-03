package com.woniu.servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.woniu.daos.GoodsDao;
import com.woniu.daos.InstockDao;
import com.woniu.daos.UsersDao;
import com.woniu.entities.Goods;
import com.woniu.entities.Instock;
import com.woniu.entities.Users;

public class InstockServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String oper=req.getParameter("oper");
		if(oper.equals("insList")){
			InstockDao instockDao=new InstockDao();
			try {
				List<Instock> listInstock = instockDao.getAllIntock();
				req.setAttribute("listInstock", listInstock);
				RequestDispatcher dis= req.getRequestDispatcher("instock.jsp");
				dis.forward(req, resp);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}else if(oper.equals("add")){
			String user_id=req.getParameter("user_id");
			String goods_id=req.getParameter("goods_id");
			String instock_code=req.getParameter("instock_code");
			String instock_time=req.getParameter("instock_time");
			String instock_status=req.getParameter("instock_status");
			String instock_rms=req.getParameter("instock_rms");
			String instock_count=req.getParameter("instock_count");
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
			Date instock_timeDate=null;
			try {
				instock_timeDate = sdf.parse(instock_time);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			Instock instock=new Instock(Integer.parseInt(user_id), Integer.parseInt(goods_id), instock_code, instock_timeDate, instock_status, instock_rms, Integer.parseInt(instock_count));
			InstockDao instockDao=new InstockDao();
			try {
				instockDao.addIntock(instock);
				resp.sendRedirect("instockList.do?oper=insList");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}else if(oper.equals("del")){
			String instock_id=req.getParameter("instock_id");
			InstockDao instockDao=new InstockDao();
			try {
				instockDao.deleteInstockById(Integer.parseInt(instock_id));
				resp.sendRedirect("instockList.do?oper=insList");
			} catch (NumberFormatException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}else if(oper.equals("updIns")){
			String instock_id=req.getParameter("instock_id");
			InstockDao instockDao = new InstockDao();
			UsersDao userDao=new UsersDao();
			GoodsDao goodsDao=new GoodsDao();
			try {
				Instock instock=instockDao.getInstockById(Integer.parseInt(instock_id));
				List<Users> listUsers=userDao.getAllUsers();
				List<Goods> listGoods=goodsDao.getAllGoods();
				req.setAttribute("listUsers", listUsers);
				req.setAttribute("listGoods", listGoods);
				req.setAttribute("instock", instock);
				RequestDispatcher dis=req.getRequestDispatcher("instockUpd.jsp");
				dis.forward(req, resp);
			} catch (NumberFormatException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}else if(oper.equals("updInsSave")){
			String instock_id=req.getParameter("instock_id");
			String user_id=req.getParameter("user_id");
			String goods_id=req.getParameter("goods_id");
			String instock_code=req.getParameter("instock_code");
			String instock_time=req.getParameter("instock_time");
			String instock_status=req.getParameter("instock_status");
			String instock_rms=req.getParameter("instock_rms");
			String instock_count=req.getParameter("instock_count");
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
			Date insTime=null;
			try {
				insTime=sdf.parse(instock_time);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			Instock instock=new Instock(Integer.parseInt(instock_id),Integer.parseInt(user_id), Integer.parseInt(goods_id), instock_code, insTime, instock_status, instock_rms, Integer.parseInt(instock_count));
			InstockDao instockDao = new InstockDao();
			try {
				instockDao.updSaveInstock(instock);
				resp.sendRedirect("instockList.do?oper=insList");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}else if(oper.equals("addUGid")){
			UsersDao usersDao = new UsersDao();
			GoodsDao goodsDao = new GoodsDao();
			try {
				List<Users> listUsers=usersDao.getAllUsers();
				List<Goods> listGoods=goodsDao.getAllGoods();
				req.setAttribute("listUsers", listUsers);
				req.setAttribute("listGoods", listGoods);
				RequestDispatcher dis=req.getRequestDispatcher("instockAdd.jsp");
				dis.forward(req, resp);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req,resp);
	}

}
