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
		req.setCharacterEncoding("utf-8");
		String oper=req.getParameter("oper");
		if(oper.equals("supplist")){
			getAllSups(req,resp);
		}else if(oper.equals("add")){
			addSups(req,resp);
		}else if(oper.equals("del")){
			delSups(req,resp);
		}else if(oper.equals("upd")){
			updSups(req,resp);
		}else if(oper.equals("updSave")){
			updSaveSups(req,resp);
		}
		
	}
	private void updSaveSups(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		String supp_id=req.getParameter("supp_id");
		String supp_code=req.getParameter("supp_code");
		String supp_name=req.getParameter("supp_name");
		String supp_phone=req.getParameter("supp_phone");
		Supplier supplier=new Supplier(Integer.parseInt(supp_id), supp_code, supp_name, supp_phone);
		SupplierDao supplierDao = new SupplierDao();
		try {
			supplierDao.updateSupplier(supplier);
			resp.sendRedirect("supplierList.do?oper=supplist");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	private void updSups(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String supp_id=req.getParameter("supp_id");
		SupplierDao supplierDao = new SupplierDao();
		try {
			Supplier supplier=supplierDao.getSupplierById(Integer.parseInt(supp_id));
			req.setAttribute("supplier", supplier);
			RequestDispatcher dis=req.getRequestDispatcher("supplierUpd.jsp");
			dis.forward(req, resp);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	private void delSups(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		String supp_id=req.getParameter("supp_id");
		SupplierDao supplierDao = new SupplierDao();
		try {
			supplierDao.deleteSupplierById(Integer.parseInt(supp_id));
			resp.sendRedirect("supplierList.do?oper=supplist");
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	private void addSups(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		String supp_code=req.getParameter("supp_code");
    	String supp_name=req.getParameter("supp_name");
    	String supp_phone=req.getParameter("supp_phone");
    	Supplier supplier = new Supplier(supp_code,supp_name,supp_phone);
    	SupplierDao supplierDao = new SupplierDao();
    	try {
			supplierDao.addSupplier(supplier);
			resp.sendRedirect("supplierList.do?oper=supplist");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	private void getAllSups(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
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
		doGet(req,resp);
	}

}
