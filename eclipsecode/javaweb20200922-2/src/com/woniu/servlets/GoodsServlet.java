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
import com.woniu.daos.GoodsTypeDao;
import com.woniu.entities.Goods;
import com.woniu.entities.GoodsType;

public class GoodsServlet extends HttpServlet {
	private void getAllGds(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		//三种情况，null、""、具体的值
		String goods_code=req.getParameter("goods_code");
		String supp_name=req.getParameter("supp_name");
		String type_name=req.getParameter("type_name");
		Goods goods = new Goods(goods_code,supp_name,type_name);
		
		GoodsDao goodsDao = new GoodsDao();
		try {
			List<Goods> listGoods=goodsDao.getAllGoods(goods);
			//向请求对象中放数据
			req.setAttribute("list3", listGoods);
			//请求转发，将“list3”对应的数据发送到goods.jsp页面中
			RequestDispatcher dis=req.getRequestDispatcher("goods.jsp");
			dis.forward(req, resp);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String oper=req.getParameter("oper");
		if(oper.equals("gdlist")){
			getAllGds(req,resp);
		}else if(oper.equals("add")){
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
				resp.sendRedirect("goodsList.do?oper=gdlist");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}else if(oper.equals("del")){
			String goods_id=req.getParameter("goods_id");
			GoodsDao goodsDao = new GoodsDao();
			try {
				goodsDao.deleteGoodsById(Integer.parseInt(goods_id));
				resp.sendRedirect("goodsList.do?oper=gdlist");
			} catch (NumberFormatException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}else if(oper.equals("updGs")){
			String goods_id=req.getParameter("goods_id");
			GoodsDao goodsDao = new GoodsDao();
			try {
				GoodsTypeDao goodsTypeDao = new GoodsTypeDao();
				List<GoodsType> listTypes=goodsTypeDao.getAllTypes();
				Goods goods=goodsDao.getGoodsById(Integer.parseInt(goods_id));
				req.setAttribute("goods", goods);
				req.setAttribute("listTypes", listTypes);
				RequestDispatcher dis =req.getRequestDispatcher("goodsUpd.jsp");
				dis.forward(req, resp);
			} catch (NumberFormatException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}else if(oper.equals("updSave")){
			String goods_id=req.getParameter("goods_id");
            String type_id=req.getParameter("type_id");
            String supp_id=req.getParameter("supp_id");
            String goods_code=req.getParameter("goods_code");
            String goods_name=req.getParameter("goods_name");
            String goods_sum=req.getParameter("goods_sum");
            String goods_price=req.getParameter("goods_price");
            String goods_photo=req.getParameter("goods_photo");
            String goods_desc=req.getParameter("goods_desc");
            Goods goods=new Goods(Integer.parseInt(goods_id), Integer.parseInt(type_id), Integer.parseInt(supp_id), goods_code, goods_name, Integer.parseInt(goods_sum), Float.parseFloat(goods_price), goods_photo, goods_desc);
            GoodsDao goodsDao = new GoodsDao();
            try {
				goodsDao.updateGoods(goods);
				resp.sendRedirect("goodsList.do?oper=gdlist");
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
