package com.woniu.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import com.woniu.daos.CategoryDao;
import com.woniu.daos.GoodsDao;
import com.woniu.entities.Category;
import com.woniu.entities.Goods;
import com.woniu.entities.PageBean;
@WebServlet("/goods")
public class GoodsServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String oper=req.getParameter("oper");
		if(oper.equals("goodslist")){
			String name=req.getParameter("name");
			String author=req.getParameter("author");
			String publisher=req.getParameter("publisher");
			Goods goodsQue = new Goods(name, author, publisher);
			GoodsDao goodsDao = new GoodsDao();
			PageBean<Goods> pageBean= new PageBean<>();
			int pageSize=15;
			pageBean.setPageSize(pageSize);
			try {
				int totalCount=goodsDao.getAllCount(goodsQue);
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
				List<Goods> pageData=goodsDao.getAllGoods(goodsQue, pageBean);
				pageBean.setPageData(pageData);
				JSONObject goodsPageObj = new JSONObject(pageBean);
				resp.setContentType("text/html;charset=utf-8");
				PrintWriter out=resp.getWriter();
				out.print(goodsPageObj);
				out.flush();
				out.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}else if(oper.equals("goodsAddSave")){
			String name=req.getParameter("name");
			String goodsno=req.getParameter("goodsno");
			String author=req.getParameter("author");
			String publisher=req.getParameter("publisher");
			String categoryid=req.getParameter("categoryid");
			String image=req.getParameter("image");
			String newest=req.getParameter("newest");
			String hot=req.getParameter("hot");
			Goods goods = new Goods(name, goodsno, author, publisher, Integer.parseInt(categoryid), newest, hot);
			goods.setImage(image);
			GoodsDao goodsDao = new GoodsDao();
			try {
				goodsDao.addGoods(goods);
				resp.setContentType("text/html;charset=utf-8");
				PrintWriter out=resp.getWriter();
				out.print("增加保存成功");
				out.flush();
				out.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}else if(oper.equals("delete")){
			String id=req.getParameter("id");
			GoodsDao goodsDao = new GoodsDao();
			try {
				goodsDao.deleteGoodsById(Integer.parseInt(id));
				resp.setContentType("text/html;charset=utf-8");
				PrintWriter out=resp.getWriter();
				out.print("删除商品成功");
				out.flush();
				out.close();
			} catch (NumberFormatException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}else if(oper.equals("deleteAll")){
			String goodsIds=req.getParameter("goodsIds");
			GoodsDao goodsDao = new GoodsDao();
			try {
				goodsDao.deleteAllGoods(goodsIds);
				resp.setContentType("text/html;charset=utf-8");
				PrintWriter out=resp.getWriter();
				out.print("批量删除商品成功");
				out.flush();
				out.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}else if(oper.equals("updUI")){
			String id=req.getParameter("id");
			GoodsDao goodsDao = new GoodsDao();
			CategoryDao categoryDao = new CategoryDao();
			resp.setContentType("text/html;charset=utf-8");
			PrintWriter out=resp.getWriter();
			Map<String,Object> mapGC=new HashMap<String,Object>();
			try {
				Goods goods=goodsDao.getGoodsById(Integer.parseInt(id));
				List<Category> listCategory=categoryDao.getAllTypes();
				mapGC.put("goods", goods);
				mapGC.put("category", listCategory);
				JSONObject mapGC_JO = new JSONObject(mapGC);
				out.print(mapGC_JO);
				out.flush();
				out.close();
			} catch (NumberFormatException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		else if(oper.equals("goodsUpdSave")){
			String id=req.getParameter("id");
            String name=req.getParameter("name");
            String goodsno=req.getParameter("goodsno");
            String author=req.getParameter("author");
            String publisher=req.getParameter("publisher");
            String categoryid=req.getParameter("categoryid");
            String image=req.getParameter("image");
            String newest=req.getParameter("newest");
            String hot=req.getParameter("hot");
            Goods goods=new Goods(Integer.parseInt(id), name, goodsno, author, publisher, Integer.parseInt(categoryid), newest, hot);
            goods.setImage(image);
            GoodsDao goodsDao = new GoodsDao();
            try {
				goodsDao.updateGoods(goods);
				resp.setContentType("text/html;charset=utf-8");
				PrintWriter out=resp.getWriter();
				out.print("修改保存成功");
				out.flush();
				out.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req,resp);
	}

}
