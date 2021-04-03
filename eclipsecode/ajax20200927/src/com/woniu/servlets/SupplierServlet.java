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

import com.woniu.daos.SupplierDao;
import com.woniu.entities.Supplier;

public class SupplierServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		SupplierDao supplierDao = new SupplierDao();
		try {
			List<Supplier> listSuppliers=supplierDao.getAllSuppliers();
			resp.setContentType("text/html;charset=utf-8");
			PrintWriter out=resp.getWriter();
			JSONArray json_Supps=new JSONArray(listSuppliers);
			out.print(json_Supps);
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
