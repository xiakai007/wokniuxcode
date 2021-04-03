package com.woniu.servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.woniu.daos.GoodsDao;
import com.woniu.daos.GoodsTypeDao;
import com.woniu.daos.SupplierDao;
import com.woniu.entities.Goods;
import com.woniu.entities.GoodsType;
import com.woniu.entities.PageBean;
import com.woniu.entities.Supplier;

public class GoodsServlet extends HttpServlet {
	private void getAllGds(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		GoodsDao goodsDao = new GoodsDao();
		//���������null��""�������ֵ
		String goods_code=req.getParameter("goods_code");
		String supp_name=req.getParameter("supp_name");
		String type_name=req.getParameter("type_name");
		Goods goods = new Goods(goods_code,supp_name,type_name);
		//��ӷ�ҳ��Ϣ
		PageBean<Goods> pageBean = new PageBean<>();
		//��һҳ
		int currentPage=1;
		String currentPagestr=req.getParameter("currentPage");
		
		int pageSize=4;
		pageBean.setPageSize(pageSize);//ʹ��pageBean�����װ��pageSize��currentPage
		
		try {
			//����Ŀ������������
			int count=goodsDao.getAllCount(goods);
			pageBean.setTotalCount(count);
			 //���currentPagestrΪnull����Ĭ��ֵΪ1
			if(currentPagestr!=null){
				currentPage=Integer.parseInt(currentPagestr);
				//���ǰһҳʱ����һҳΪֹ
				if(currentPage<=0){
					currentPage=1;
				}
				//�����һҳʱ�����һҳΪֹ
				if(currentPage>pageBean.getPages()){
					currentPage=pageBean.getPages();
					if(pageBean.getPages()==0){
						currentPage=1;
					}
				}
			}
			pageBean.setCurrentPage(currentPage);
			
			List<Goods> listGoods=goodsDao.getAllGoods(goods,pageBean);
			//ʹ��pageBean�����װ��ѯ�����ļ���
			pageBean.setData(listGoods);
			
			//����������з�����
			req.setAttribute("pageBean", pageBean);
			//�����ѯ������ѯ�ֶ���Ϣ
			req.setAttribute("goods1", goods);
			//����ת��������list3����Ӧ�����ݷ��͵�goods.jspҳ����
			RequestDispatcher dis=req.getRequestDispatcher("goods.jsp");
			dis.forward(req, resp);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String oper=req.getParameter("oper");
		if(oper.equals("gdlist")){
			getAllGds(req,resp);
		}else if(oper.equals("add")){
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
				resp.sendRedirect("goodsList.do?oper=gdlist");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}else if(oper.equals("del")){
			String goods_id=req.getParameter("goods_id");
			GoodsDao goodsDao = new GoodsDao();
			try {
				goodsDao.deleteGoodsById(Integer.parseInt(goods_id));
				resp.sendRedirect("goodsList.do?oper=gdlist");
			} catch (NumberFormatException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}else if(oper.equals("updGs")){
			String goods_id=req.getParameter("goods_id");
			GoodsDao goodsDao = new GoodsDao();
			try {
				GoodsTypeDao goodsTypeDao = new GoodsTypeDao();
				List<GoodsType> listTypes=goodsTypeDao.getAllTypes();
				SupplierDao supplierDao=new SupplierDao();
				List<Supplier> listSuppliers=supplierDao.getAllSuppliers();
				Goods goods=goodsDao.getGoodsById(Integer.parseInt(goods_id));
				req.setAttribute("goods", goods);
				req.setAttribute("listTypes", listTypes);
				req.setAttribute("listSuppliers", listSuppliers);
				RequestDispatcher dis =req.getRequestDispatcher("goodsUpd.jsp");
				dis.forward(req, resp);
			} catch (NumberFormatException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}else if(oper.equals("updSave")){
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
				resp.sendRedirect("goodsList.do?oper=gdlist");
			} catch (SQLException e) {
				e.printStackTrace();
			}
            
		}else if(oper.equals("addTSid")){
			try {
				GoodsTypeDao goodsTypeDao = new GoodsTypeDao();
				List<GoodsType> listTypes=goodsTypeDao.getAllTypes();
				SupplierDao supplierDao=new SupplierDao();
				List<Supplier> listSuppliers=supplierDao.getAllSuppliers();
				req.setAttribute("listTypes", listTypes);
				req.setAttribute("listSuppliers", listSuppliers);
				RequestDispatcher dis=req.getRequestDispatcher("goodsAdd.jsp");
				dis.forward(req, resp);
			} catch (NumberFormatException e) {
				e.printStackTrace();
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
