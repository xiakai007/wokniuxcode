package com.woniu.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;

import com.woniu.daos.GoodsTypeDao;
import com.woniu.entities.GoodsType;

public class GoodsTypeServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		GoodsTypeDao goodsTypeDao = new GoodsTypeDao();
		try {
			List<GoodsType> listTypes=goodsTypeDao.getAllTypes();
			resp.setContentType("text/html;charset=utf-8");
			PrintWriter out=resp.getWriter();
			//将集合转换为JSON格式
			JSONArray jsATypes=new JSONArray(listTypes);
			out.print(jsATypes);
			out.flush();
			out.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

}
