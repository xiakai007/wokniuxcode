package com.woniu.servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.woniu.daos.GoodsTypeDao;
import com.woniu.entities.GoodsType;

public class GoodsTypeSaveServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	req.setCharacterEncoding("utf-8");
    	String type_code=req.getParameter("type_code");
    	String type_name=req.getParameter("type_name");
    	GoodsType goodsType = new GoodsType(type_code,type_name);
    	GoodsTypeDao goodsTypeDao = new GoodsTypeDao();
    	try {
			goodsTypeDao.addType(goodsType);
			
			resp.sendRedirect("goodsTypeList.do");
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	
    }
}
