package com.woniu.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.woniu.bean.pojo.Category;
import com.woniu.bean.pojo.Goods;
import com.woniu.mappers.CategoryMapper;
import com.woniu.mappers.GoodsMapper;
import com.woniu.utils.MyBatisUtil;
import com.woniu.utils.TemplateUtil;

@WebServlet("/index")
public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private GoodsMapper goodsMapper;
	private CategoryMapper categoryMapper;
	private Logger logger=Logger.getLogger(IndexServlet.class);
	public void init(ServletConfig config) throws ServletException {
		SqlSession sqlSession=MyBatisUtil.getSqlSession();
		goodsMapper=sqlSession.getMapper(GoodsMapper.class);
		categoryMapper=sqlSession.getMapper(CategoryMapper.class);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Page<Goods> page=PageHelper.startPage(1, 12);
		List<Goods> newBookList=goodsMapper.selectGoodsByNewest();
		request.setAttribute("newBookList", newBookList);
		Page<Goods> page2=PageHelper.startPage(1, 6);
		List<Goods> hotBookList=goodsMapper.selectGoodsByHot();
		request.setAttribute("hotBookList", hotBookList);
		List<Category> categoryList =categoryMapper.selectCategoryByNavable();
		request.setAttribute("categoryList", categoryList);
		List<Category> categoryListNot =categoryMapper.selectCategoryByNotNavable();
		request.setAttribute("categoryListNot", categoryListNot);
		TemplateUtil.process("index", request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
