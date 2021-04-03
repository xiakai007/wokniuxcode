package com.woniu.servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.woniu.daos.SupplierDao;

public class SupplierDelServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String supp_id=req.getParameter("supp_id");
		SupplierDao supplierDao = new SupplierDao();
		try {
			supplierDao.deleteSupplierById(Integer.parseInt(supp_id));
			resp.sendRedirect("supplierList.do");
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	
    }
}
