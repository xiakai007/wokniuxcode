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

import com.woniu.daos.GoodsTypeDao;
import com.woniu.entities.GoodsType;
import com.woniu.entities.PageBean;

/**
 * Servlet implementation class GoodsType
 */
@WebServlet("/types")
public class GoodsTypeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GoodsTypeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String oper=req.getParameter("oper");
		if(oper.equals("tplist")){
			GoodsTypeDao goodsTypeDao = new GoodsTypeDao();
			String type_code=req.getParameter("type_code");
			String type_name=req.getParameter("type_name");
			GoodsType goodsTypeQue=new GoodsType(type_code, type_name);
			try {
				//分页
				PageBean<GoodsType> pageBean=new PageBean<>();
				int pageSize=4;
				pageBean.setPageSize(pageSize);
				int totalCount=goodsTypeDao.getAllCount(goodsTypeQue);
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
				
				List<GoodsType> listType=goodsTypeDao.getAllTypes(goodsTypeQue,pageBean);
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
			GoodsTypeDao goodsTypeDao=new GoodsTypeDao();
			String type_code=req.getParameter("type_code");
			String type_name=req.getParameter("type_name");
			GoodsType goodsType = new GoodsType(type_code, type_name);
			try {
				goodsTypeDao.addType(goodsType);
				resp.setContentType("text/html;charset=utf-8");
				PrintWriter out=resp.getWriter();
				out.print("类型增加保存成功");
				out.flush();
				out.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}else if(oper.equals("del")){
			String type_id=req.getParameter("type_id");
			GoodsTypeDao goodsTypeDao = new GoodsTypeDao();
			try {
				goodsTypeDao.deleteTypeById(Integer.parseInt(type_id));
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
			GoodsTypeDao goodsTypeDao = new GoodsTypeDao();
			try {
				goodsTypeDao.delAllType(typeIds);
				resp.setContentType("text/html;charset=utf-8");
				PrintWriter out=resp.getWriter();
				out.print("类型批量删除成功");
				out.flush();
				out.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}else if(oper.equals("updUI")){
			String type_id=req.getParameter("type_id");
			GoodsTypeDao goodsTypeDao = new GoodsTypeDao();
			try {
				GoodsType goodsType=goodsTypeDao.getTypeById(Integer.parseInt(type_id));
				JSONObject typeObj = new JSONObject(goodsType);
				resp.setContentType("text/html;charset=utf-8");
				PrintWriter out=resp.getWriter();
				out.print(typeObj);
				out.flush();
				out.close();
			} catch (NumberFormatException | SQLException e) {
				e.printStackTrace();
			}
		}else if(oper.equals("typeUpd")){
			String type_id=req.getParameter("type_id");
			String type_code=req.getParameter("type_code");
			String type_name=req.getParameter("type_name");
			GoodsType goodsType = new GoodsType(Integer.parseInt(type_id), type_code, type_name);
			GoodsTypeDao goodsTypeDao = new GoodsTypeDao();
			try {
				goodsTypeDao.updateType(goodsType);
				resp.setContentType("text/html;charset=utf-8");
				PrintWriter out=resp.getWriter();
				out.print("类型修改保存成功");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}else if(oper.equals("showTypes")){
			GoodsTypeDao goodsTypeDao = new GoodsTypeDao();
			try {
				List<GoodsType> listTypes=goodsTypeDao.getAllTypes();
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
