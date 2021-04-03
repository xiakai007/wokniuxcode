package com.woniu.servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.woniu.daos.GoodsDao;
import com.woniu.entities.Goods;

public class GoodsServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		GoodsDao goodsDao = new GoodsDao();
		try {
			List<Goods> listGoods=goodsDao.getAllGoods();
			req.setAttribute("list3", listGoods);
			RequestDispatcher dis=req.getRequestDispatcher("goods.jsp");
			dis.forward(req, resp);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}

}
