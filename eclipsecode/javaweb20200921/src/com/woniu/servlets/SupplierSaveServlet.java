package com.woniu.servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.woniu.daos.SupplierDao;
import com.woniu.entities.Supplier;

public class SupplierSaveServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	req.setCharacterEncoding("utf-8");
    	String supp_code=req.getParameter("supp_code");
    	String supp_name=req.getParameter("supp_name");
    	String supp_phone=req.getParameter("supp_phone");
    	Supplier supplier = new Supplier(supp_code,supp_name,supp_phone);
    	SupplierDao supplierDao = new SupplierDao();
    	try {
			supplierDao.addSupplier(supplier);
			resp.sendRedirect("supplierList.do");
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	
    }
}
