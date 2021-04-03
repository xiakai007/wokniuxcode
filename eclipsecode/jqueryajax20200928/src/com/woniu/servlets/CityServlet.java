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

import com.woniu.daos.CityDao;
import com.woniu.entities.City;

public class CityServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		CityDao cityDao=new CityDao();
		String prov_id=req.getParameter("prov_id");
		try {
			List<City> listCity=cityDao.getAllCity(Integer.parseInt(prov_id));
			JSONArray cityArr=new JSONArray(listCity);
			resp.setContentType("text/html;charset=utf-8");
			PrintWriter out=resp.getWriter();
			out.print(cityArr);
			out.flush();
			out.close();
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}

}
