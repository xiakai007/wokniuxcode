package com.woniu.servlets;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.woniu.bean.pojo.Goods;
import com.woniu.bean.pojo.PageBean;
import com.woniu.bean.pojo.User;
import com.woniu.mappers.GoodsMapper;
import com.woniu.utils.MyBatisUtil;
import com.woniu.utils.TemplateUtil;

@WebServlet("/goods")
public class GoodsServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	private Logger logger=Logger.getLogger(GoodsServlet.class);
	private GoodsMapper goodsMapper;
    public GoodsServlet() {
    }
    @Override
    public void init() throws ServletException {
    	SqlSession sqlSession=MyBatisUtil.getSqlSession();
    	goodsMapper=sqlSession.getMapper(GoodsMapper.class);
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doGet(request, response);
	}
	protected void proDetail(HttpServletRequest request, HttpServletResponse response){
		String idStr=request.getParameter("id");
		if(idStr!=null){
			Goods goods=goodsMapper.selectGoodsByIdRmk(Integer.parseInt(idStr));
			request.setAttribute("goods", goods);
			TemplateUtil.process("proDetail", request, response);
		}
	}
	protected void proDetailHot(HttpServletRequest request, HttpServletResponse response){
		String idStr=request.getParameter("id");
		if(idStr!=null){
			Goods goodsHot=goodsMapper.selectGoodsByIdRmk(Integer.parseInt(idStr));
			request.setAttribute("goodsHot", goodsHot);
			TemplateUtil.process("proDetailHot", request, response);
		}
	}
	protected void proMoreNew(HttpServletRequest request, HttpServletResponse response){
		int currentPage=1;
		String crtpage=request.getParameter("currentPage");
		if(crtpage==null){
			currentPage=1;
		}else{
			currentPage=Integer.parseInt(crtpage);
		}
		PageBean<Goods> pageBean=new PageBean<>();
		int count=goodsMapper.getCountGoodsByNewest();
		//给pageBean赋值totalCount
		pageBean.setTotalCount(count);
		//每页的条目数
		int pageSize=6;
		//给pageBean赋值pageSize
		pageBean.setPageSize(pageSize);
		int pages=pageBean.getPages();
		//给pageBean赋值pages
		pageBean.setPages(pages);
		//给pageBean赋值currentPage
		pageBean.setCurrentPage(currentPage);
		if(currentPage>pages){
			currentPage=pages;
		}
		Page<Goods> page=PageHelper.startPage(currentPage, pageSize);
		List<Goods> goodsList=goodsMapper.selectGoodsByNewest();
		//给pageBean赋值goodsList
		pageBean.setData(goodsList);
		request.setAttribute("pageBean", pageBean);
		TemplateUtil.process("proNewList", request, response);
	}
	protected void proSearch(HttpServletRequest request, HttpServletResponse response){
		int currentPage=1;
		String crtpage=request.getParameter("currentPage");
		if(crtpage==null){
			currentPage=1;
		}else{
			currentPage=Integer.parseInt(crtpage);
		}
		String name=null;
		String nameSearch=request.getParameter("searchname");
		//处理中文乱码
		if(nameSearch!=null){
			try {
				name=new String(nameSearch.getBytes("ISO-8859-1"),"UTF-8");
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}
		PageBean<Goods> pageBean=new PageBean<>();
		int count=goodsMapper.getCountGoodsByName(name);
		//给pageBean赋值totalCount
		pageBean.setTotalCount(count);
		//每页的条目数
		int pageSize=6;
		//给pageBean赋值pageSize
		pageBean.setPageSize(pageSize);
		int pages=pageBean.getPages();
		//给pageBean赋值pages
		pageBean.setPages(pages);
		//给pageBean赋值currentPage
		pageBean.setCurrentPage(currentPage);
		if(currentPage>pages){
			currentPage=pages;
		}
		Page<Goods> page=PageHelper.startPage(currentPage, pageSize);
		List<Goods> goodsList=goodsMapper.selectGoodsByName(name);
		//给pageBean赋值goodsList
		pageBean.setData(goodsList);
		request.setAttribute("pageBean", pageBean);
		request.setAttribute("name", name);
		TemplateUtil.process("proSearch", request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
