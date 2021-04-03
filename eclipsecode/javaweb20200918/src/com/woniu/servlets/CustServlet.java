package com.woniu.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.woniu.daos.CustomersDao;
import com.woniu.entities.Customers;

public class CustServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		CustomersDao ctd = new CustomersDao();
		List<Customers> listCusts= ctd.getAllCustomers();
		
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out=resp.getWriter();
		out.print("<table border='1px' style='border-collapse:collapse;'>");
		out.print("<tr><td>客户编号</td><td>客户姓名</td></tr>");
		for(Customers cust:listCusts){
			out.print("<tr><td>"+cust.getCust_id()+"</td><td>"
		+cust.getCust_name()+"</td></tr>");
		}
		out.print("</table>");
		out.flush();
		out.close();
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}

}
