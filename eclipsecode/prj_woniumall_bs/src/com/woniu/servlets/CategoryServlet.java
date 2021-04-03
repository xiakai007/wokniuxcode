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

import com.woniu.daos.CategoryDao;
import com.woniu.entities.Category;
import com.woniu.entities.PageBean;

/**
 * Servlet implementation class GoodsType
 */
@WebServlet("/types")
public class CategoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CategoryServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String oper=req.getParameter("oper");
		if(oper.equals("tplist")){
			CategoryDao categoryDao = new CategoryDao();
			String name=req.getParameter("name");
			String navable=req.getParameter("navable");
			Category categoryQue=new Category(name, navable);
			try {
				//分页
				PageBean<Category> pageBean=new PageBean<>();
				int pageSize=2;
				pageBean.setPageSize(pageSize);
				int totalCount=categoryDao.getAllCount(categoryQue);
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
				
				List<Category> listType=categoryDao.getAllTypes(categoryQue,pageBean);
				pageBean.setPageData(listType);
				
				JSONObject typePageObj = new JSONObject(pageBean);
				resp.setContentType("text/html;charset=utf-8");
				PrintWriter out=resp.getWriter();
				out.print(typePageObj);
				out.flush();
				out.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}else if(oper.equals("typeAdd")){
			CategoryDao categoryDao = new CategoryDao();
			String name=req.getParameter("name");
			String status=req.getParameter("status");
			String navable=req.getParameter("navable");
			Category category = new Category(name, status, navable);
			try {
				categoryDao.addCategory(category);
				resp.setContentType("text/html;charset=utf-8");
				PrintWriter out=resp.getWriter();
				out.print("类型增加保存成功");
				out.flush();
				out.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}else if(oper.equals("del")){
			String id=req.getParameter("id");
			CategoryDao categoryDao = new CategoryDao();
			try {
				categoryDao.deleteCategoryById(Integer.parseInt(id));
				resp.setContentType("text/html;charset=utf-8");
				PrintWriter out=resp.getWriter();
				out.print("类型删除成功");
				out.flush();
				out.close();
			} catch (NumberFormatException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}else if(oper.equals("delAll")){
			String typeIds=req.getParameter("typeIds");
			CategoryDao categoryDao = new CategoryDao();
			try {
				categoryDao.delAllType(typeIds);
				resp.setContentType("text/html;charset=utf-8");
				PrintWriter out=resp.getWriter();
				out.print("类型批量删除成功");
				out.flush();
				out.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}else if(oper.equals("updUI")){
			String id=req.getParameter("id");
			CategoryDao categoryDao = new CategoryDao();
			try {
				Category category=categoryDao.getTypeById(Integer.parseInt(id));
				JSONObject typeObj = new JSONObject(category);
				resp.setContentType("text/html;charset=utf-8");
				PrintWriter out=resp.getWriter();
				out.print(typeObj);
				out.flush();
				out.close();
			} catch (NumberFormatException | SQLException e) {
				e.printStackTrace();
			}
		}else if(oper.equals("typeUpd")){
			String id=req.getParameter("id");
			String name=req.getParameter("name");
			String status=req.getParameter("status");
			String navable=req.getParameter("navable");
			Category category = new Category(Integer.parseInt(id), name, status, navable);
			CategoryDao categoryDao = new CategoryDao();
			try {
				categoryDao.updateType(category);
				resp.setContentType("text/html;charset=utf-8");
				PrintWriter out=resp.getWriter();
				out.print("类型修改保存成功");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}else if(oper.equals("showTypes")){
			CategoryDao categoryDao = new CategoryDao();
			try {
				List<Category> listTypes=categoryDao.getAllTypes();
				JSONArray listTypesJA = new JSONArray(listTypes);
				resp.setContentType("text/html;charset=utf-8");
				PrintWriter out=resp.getWriter();
				out.print(listTypesJA);
				out.flush();
				out.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
