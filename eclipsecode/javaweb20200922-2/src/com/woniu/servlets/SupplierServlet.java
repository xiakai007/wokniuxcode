package com.woniu.servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.woniu.daos.SupplierDao;
import com.woniu.entities.Supplier;

public class SupplierServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		SupplierDao supplierDao= new SupplierDao();
		try {
			List<Supplier> listSuppliers=supplierDao.getAllSuppliers();
			req.setAttribute("list2", listSuppliers);
			RequestDispatcher dis=req.getRequestDispatcher("supplier.jsp");
			dis.forward(req, resp);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}

}
