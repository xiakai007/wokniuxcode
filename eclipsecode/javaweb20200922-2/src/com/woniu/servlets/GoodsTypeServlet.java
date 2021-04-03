package com.woniu.servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.woniu.daos.GoodsTypeDao;
import com.woniu.entities.GoodsType;

public class GoodsTypeServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String oper=req.getParameter("oper");
		if(oper.equals("typelist")){
			GoodsTypeDao goodsTypeDao = new GoodsTypeDao();
			try {
				List<GoodsType> listTypes=goodsTypeDao.getAllTypes();
				req.setAttribute("list", listTypes);
				RequestDispatcher dis=req.getRequestDispatcher("goodsType.jsp");
				dis.forward(req, resp);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}else if(oper.equals("add")){
	    	String type_code=req.getParameter("type_code");
	    	String type_name=req.getParameter("type_name");
	    	GoodsType goodsType = new GoodsType(type_code,type_name);
	    	GoodsTypeDao goodsTypeDao = new GoodsTypeDao();
	    	try {
				goodsTypeDao.addType(goodsType);
				resp.sendRedirect("goodsType.do?oper=typelist");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}else if(oper.equals("del")){
			String type_id=req.getParameter("type_id");
	    	GoodsTypeDao goodsTypeDao = new GoodsTypeDao();
	    	try {
				goodsTypeDao.deleteTypeById(Integer.parseInt(type_id));
				resp.sendRedirect("goodsType.do?oper=typelist");
			} catch (NumberFormatException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}else if(oper.equals("updUI")){
			String type_id=req.getParameter("type_id");
			GoodsTypeDao goodsTypeDao = new GoodsTypeDao();
			try {
				GoodsType goodsType=goodsTypeDao.getTypeById(Integer.parseInt(type_id));
				req.setAttribute("goodsType", goodsType);
				RequestDispatcher dis=req.getRequestDispatcher("goodsTypeUpd.jsp");
				dis.forward(req, resp);
			} catch (NumberFormatException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}else if(oper.equals("updUIsave")){
			String type_id=req.getParameter("type_id");
			String type_code=req.getParameter("type_code");
			String type_name=req.getParameter("type_name");
			GoodsType goodsType=new GoodsType(Integer.parseInt(type_id),type_code,type_name);
			GoodsTypeDao goodsTypeDao = new GoodsTypeDao();
			try {
				goodsTypeDao.updateType(goodsType);
				resp.sendRedirect("goodsType.do?oper=typelist");
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
