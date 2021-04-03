package com.woniu.servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.woniu.daos.GoodsTypeDao;
import com.woniu.entities.GoodsType;
import com.woniu.entities.PageType;

public class GoodsTypeServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String oper=req.getParameter("oper");
		if(oper.equals("typelist")){
			getAllTys(req,resp);
			
		}else if(oper.equals("add")){
	    	String type_code=req.getParameter("type_code");
	    	String type_name=req.getParameter("type_name");
	    	GoodsType goodsType = new GoodsType(type_code,type_name);
	    	GoodsTypeDao goodsTypeDao = new GoodsTypeDao();
	    	try {
				goodsTypeDao.addType(goodsType);
				resp.sendRedirect("goodsType.do?oper=typelist");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}else if(oper.equals("del")){
			String type_id=req.getParameter("type_id");
	    	GoodsTypeDao goodsTypeDao = new GoodsTypeDao();
	    	try {
				goodsTypeDao.deleteTypeById(Integer.parseInt(type_id));
				resp.sendRedirect("goodsType.do?oper=typelist");
			} catch (NumberFormatException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}else if(oper.equals("updUI")){
			String type_id=req.getParameter("type_id");
			GoodsTypeDao goodsTypeDao = new GoodsTypeDao();
			try {
				GoodsType goodsType=goodsTypeDao.getTypeById(Integer.parseInt(type_id));
				req.setAttribute("goodsType", goodsType);
				RequestDispatcher dis=req.getRequestDispatcher("goodsTypeUpd.jsp");
				dis.forward(req, resp);
			} catch (NumberFormatException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}else if(oper.equals("updUIsave")){
			String type_id=req.getParameter("type_id");
			String type_code=req.getParameter("type_code");
			String type_name=req.getParameter("type_name");
			GoodsType goodsType=new GoodsType(Integer.parseInt(type_id),type_code,type_name);
			GoodsTypeDao goodsTypeDao = new GoodsTypeDao();
			try {
				goodsTypeDao.updateType(goodsType);
				resp.sendRedirect("goodsType.do?oper=typelist");
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		
	}
    private void getAllTys(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	GoodsTypeDao goodsTypeDao = new GoodsTypeDao();
    	String type_code=req.getParameter("type_code");
    	String type_name=req.getParameter("type_name");
    	GoodsType goodsType=new GoodsType(type_code, type_name);
    	
    	PageType<GoodsType> pageType=new PageType<>();
    	//当前页默认为第1页
    	int currentPage=1;
    	String currentPageStr=req.getParameter("currentPage");
    	//每页显示4行
    	int pageSize=4;
    	pageType.setPageSize(pageSize);
    	try {
			int totalCount=goodsTypeDao.getAllCount(goodsType);
			pageType.setTotalCount(totalCount);
			
	    	if(currentPageStr!=null){
	    		currentPage=Integer.parseInt(currentPageStr);
	    		if(currentPage<=0){
	    			currentPage=1;
	    		}
	    		if(currentPage>pageType.getPages()){
	    			currentPage=pageType.getPages();
	    			if(pageType.getPages()==0){
	    				currentPage=1;
	    			}
	    		}
	    	}
	    	pageType.setCurrentPage(currentPage);
			List<GoodsType> listTypes=goodsTypeDao.getAllTypes(goodsType,pageType);
			pageType.setPagaData(listTypes);
			req.setAttribute("goodsType", goodsType);
			req.setAttribute("pageType", pageType);
			RequestDispatcher dis=req.getRequestDispatcher("goodsType.jsp");
			dis.forward(req, resp);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}
	@Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	doGet(req,resp);
    }
}
