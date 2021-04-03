package com.woniu.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.woniu.bean.pojo.Category;
import com.woniu.bean.pojo.Goods;
import com.woniu.bean.pojo.PageBean;
import com.woniu.mappers.CategoryMapper;
import com.woniu.mappers.GoodsMapper;
import com.woniu.utils.MyBatisUtil;
import com.woniu.utils.TemplateUtil;

@WebServlet("/category")
public class CategoryServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	private CategoryMapper categoryMapper;
	private GoodsMapper goodsMapper;
	private Logger logger=Logger.getLogger(CategoryServlet.class);
    public CategoryServlet() {
    }
    @Override
    public void init() throws ServletException {
    	SqlSession sqlSession=MyBatisUtil.getSqlSession();
    	categoryMapper=sqlSession.getMapper(CategoryMapper.class);
    	goodsMapper=sqlSession.getMapper(GoodsMapper.class);
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doGet(request, response);
	}
	protected void categoryToGoodsList(HttpServletRequest request, HttpServletResponse response){
		String id=request.getParameter("id");
		if(id!=null){
			int currentPage=1;
			String crtpage=request.getParameter("currentPage");
			if(crtpage==null){
				currentPage=1;
			}else{
				currentPage=Integer.parseInt(crtpage);
			}
			PageBean<Goods> pageBean=new PageBean<>();
			int count=goodsMapper.getCountGoodsByCategoryid(Integer.parseInt(id));
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
			List<Goods> goodsList=goodsMapper.selectGoodsByCategoryId(Integer.parseInt(id));
			//给pageBean赋值goodsList
			pageBean.setData(goodsList);
			request.setAttribute("pageBean", pageBean);
			TemplateUtil.process("proCategoryToGoodsList", request, response);
		}
	}
	protected void categoryToGoodsesNot(HttpServletRequest request, HttpServletResponse response){
		String id=request.getParameter("id");
		if(id!=null){
			Category category=categoryMapper.selectCategoryById(Integer.parseInt(id));
			List<Goods> cateGoodsesNot=category.getGoodsList();
			request.setAttribute("cateGoodsesNot", cateGoodsesNot);
			TemplateUtil.process("proCategoryToGoodses", request, response);
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
