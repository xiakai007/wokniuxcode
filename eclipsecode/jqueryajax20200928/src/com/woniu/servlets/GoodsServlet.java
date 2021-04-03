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

import com.woniu.daos.GoodsDao;
import com.woniu.daos.GoodsTypeDao;
import com.woniu.daos.SupplierDao;
import com.woniu.entities.Goods;
import com.woniu.entities.GoodsType;
import com.woniu.entities.PageBean;
import com.woniu.entities.Supplier;
@WebServlet("/goods")
public class GoodsServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String oper=req.getParameter("oper");
		if(oper.equals("goodslist")){
			String goods_code=req.getParameter("goods_code");
			String supp_name=req.getParameter("supp_name");
			String type_name=req.getParameter("type_name");
			Goods goodsQue = new Goods(goods_code, supp_name, type_name);
			GoodsDao goodsDao = new GoodsDao();
			PageBean<Goods> pageBean= new PageBean<>();
			int pageSize=5;
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
			String type_id=req.getParameter("type_id");
			String supp_id=req.getParameter("supp_id");
			String goods_code=req.getParameter("goods_code");
			String goods_name=req.getParameter("goods_name");
			String goods_sum=req.getParameter("goods_sum");
			String goods_price=req.getParameter("goods_price");
			String goods_photo=req.getParameter("goods_photo");
			String goods_desc=req.getParameter("goods_desc");
			Goods goods = new Goods(Integer.parseInt(type_id), Integer.parseInt(supp_id), goods_code, goods_name, Integer.parseInt(goods_sum), Float.parseFloat(goods_price), goods_photo, goods_desc);
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
			String goods_id=req.getParameter("goods_id");
			GoodsDao goodsDao = new GoodsDao();
			try {
				goodsDao.deleteGoodsById(Integer.parseInt(goods_id));
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
			String goods_id=req.getParameter("goods_id");
			GoodsDao goodsDao = new GoodsDao();
			SupplierDao supplierDao = new SupplierDao();
			GoodsTypeDao goodsTypeDao = new GoodsTypeDao();
			resp.setContentType("text/html;charset=utf-8");
			PrintWriter out=resp.getWriter();
			Map<String,Object> mapGST=new HashMap<String,Object>();
			try {
				Goods goods=goodsDao.getGoodsById(Integer.parseInt(goods_id));
				List<Supplier> listSuppliers=supplierDao.getAllSuppliers();
				List<GoodsType> listTypes=goodsTypeDao.getAllTypes();
				mapGST.put("goods", goods);
				mapGST.put("suppliers", listSuppliers);
				mapGST.put("types", listTypes);
				JSONObject mapGST_JO = new JSONObject(mapGST);
				out.print(mapGST_JO);
				out.flush();
				out.close();
			} catch (NumberFormatException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}else if(oper.equals("goodsUpdSave")){
			String goods_id=req.getParameter("goods_id");
            String type_id=req.getParameter("type_id");
            String supp_id=req.getParameter("supp_id");
            String goods_code=req.getParameter("goods_code");
            String goods_name=req.getParameter("goods_name");
            String goods_sum=req.getParameter("goods_sum");
            String goods_price=req.getParameter("goods_price");
            String goods_photo=req.getParameter("goods_photo");
            String goods_desc=req.getParameter("goods_desc");
            Goods goods=new Goods(Integer.parseInt(goods_id), Integer.parseInt(type_id), Integer.parseInt(supp_id), goods_code, goods_name, Integer.parseInt(goods_sum), Float.parseFloat(goods_price), goods_photo, goods_desc);
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
