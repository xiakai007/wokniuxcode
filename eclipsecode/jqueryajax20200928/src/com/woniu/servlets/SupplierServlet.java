package com.woniu.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;

import com.woniu.daos.SupplierDao;
import com.woniu.entities.PageBean;
import com.woniu.entities.Supplier;
@WebServlet("/supp")
public class SupplierServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String oper=req.getParameter("oper");
		if(oper.equals("supplist")){
			String supp_code=req.getParameter("supp_code");
			String supp_name=req.getParameter("supp_name");
			Supplier suppQuery =new Supplier(supp_code,supp_name);
			SupplierDao supplierDao=new SupplierDao();
			try {
				//分页
				PageBean<Supplier> pageBean=new PageBean<>();
				int pageSize=5;
				pageBean.setPageSize(pageSize);
				int totalCount=supplierDao.getAllCount(suppQuery);
				pageBean.setTotalCount(totalCount);
				int currentPage=1;
				if(req.getParameter("currentPage")!=null&&!req.getParameter("currentPage").equals("")){
					currentPage=Integer.parseInt(req.getParameter("currentPage"));
				}
				if(currentPage<1){
					currentPage=1;
				}
				if(currentPage>pageBean.getPages()){
					currentPage=pageBean.getPages();
					if(pageBean.getPages()==0){
						currentPage=1;
					}
				}
				pageBean.setCurrentPage(currentPage);
				
				List<Supplier> listSupps=supplierDao.getAllSuppliers(suppQuery,pageBean);
				pageBean.setPageData(listSupps);
				
				JSONObject suppPageObj=new JSONObject(pageBean);
				//System.out.println(suppPageObj);
				resp.setContentType("text/html;charset=utf-8");
				PrintWriter out=resp.getWriter();
				out.print(suppPageObj);
				out.flush();
				out.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}else if(oper.equals("add")){
			String supp_code=req.getParameter("supp_code");
			String supp_name=req.getParameter("supp_name");
			String supp_phone=req.getParameter("supp_phone");
			Supplier supplier = new Supplier(supp_code,supp_name,supp_phone);
			SupplierDao supplierDao = new SupplierDao();
			resp.setContentType("text/html;charset=utf-8");
			PrintWriter out=resp.getWriter();
			try {
				supplierDao.addSupplier(supplier);
				out.print("增加成功");
			} catch (SQLException e) {
				e.printStackTrace();
				out.print("增加失败");
			}
		}else if(oper.equals("del")){
			String supp_id=req.getParameter("supp_id");
			SupplierDao supplierDao = new SupplierDao();
			resp.setContentType("text/html;charset=utf-8");
			PrintWriter out=resp.getWriter();
			try {
				supplierDao.deleteSupplierById(Integer.parseInt(supp_id));
				out.print("删除成功");
			} catch (NumberFormatException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
				out.print("删除失败");
			}
		}else if(oper.equals("delAll")){
			String suppIds=req.getParameter("suppIds");
			SupplierDao supplierDao = new SupplierDao();
			resp.setContentType("text/html;charset=utf-8");
			PrintWriter out=resp.getWriter();
			try {
				supplierDao.delAllSupp(suppIds);
				out.print("批量删除成功");
			} catch (SQLException e) {
				e.printStackTrace();
				out.print("批量删除失败");
			}
		}else if(oper.equals("updUI")){
			String supp_id=req.getParameter("supp_id");
			SupplierDao supplierDao = new SupplierDao();
			resp.setContentType("text/html;charset=utf-8");
			PrintWriter out=resp.getWriter();
			try {
				Supplier supplier=supplierDao.getSupplierById(Integer.parseInt(supp_id));
				JSONObject suppObj = new JSONObject(supplier);
				out.print(suppObj);
			} catch (NumberFormatException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}else if(oper.equals("update")){
			String supp_id=req.getParameter("supp_id");
			String supp_code=req.getParameter("supp_code");
			String supp_name=req.getParameter("supp_name");
			String supp_phone=req.getParameter("supp_phone");
			Supplier supplier=new Supplier(Integer.parseInt(supp_id), supp_code, supp_name, supp_phone);
			SupplierDao supplierDao = new SupplierDao();
			resp.setContentType("text/html;charset=utf-8");
			PrintWriter out=resp.getWriter();
			try {
				supplierDao.updateSupplier(supplier);
				out.print("修改保存成功");
			} catch (SQLException e) {
				e.printStackTrace();
				out.print("修改保存失败");
			}
		}else if(oper.equals("showSuppliers")){
			SupplierDao supplierDao = new SupplierDao();
			resp.setContentType("text/html;charset=utf-8");
			PrintWriter out=resp.getWriter();
			try {
				List<Supplier> listSuppliers=supplierDao.getAllSuppliers();
				JSONArray SuppliersJA = new JSONArray(listSuppliers);
				out.print(SuppliersJA);
				out.flush();
				out.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req,resp);
	}

}
