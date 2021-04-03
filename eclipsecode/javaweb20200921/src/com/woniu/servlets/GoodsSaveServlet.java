package com.woniu.servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.woniu.daos.GoodsDao;
import com.woniu.entities.Goods;

public class GoodsSaveServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String type_id=req.getParameter("type_id");
		String supp_id=req.getParameter("supp_id");
		String goods_code=req.getParameter("goods_code");
		String goods_name=req.getParameter("goods_name");
		String goods_sum=req.getParameter("goods_sum");
		String goods_price=req.getParameter("goods_price");
		String goods_photo=req.getParameter("goods_photo");
		String goods_desc=req.getParameter("goods_desc");
		Goods goods = new Goods(Integer.parseInt(type_id), Integer.parseInt(supp_id), goods_code, goods_name, Integer.parseInt(goods_sum), Float.parseFloat(goods_price), goods_photo, goods_desc);
		GoodsDao goodsDao = new GoodsDao();
		try {
			goodsDao.addGoods(goods);
			resp.sendRedirect("goodsList.do");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}

}
