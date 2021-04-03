package com.woniu.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;

import com.woniu.daos.ProvDao;
import com.woniu.entities.Prov;


public class ProvServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public ProvServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProvDao provDao=new ProvDao();
		try {
			List<Prov> listProv=provDao.getAllProv();
			JSONArray provArr=new JSONArray(listProv);
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out=response.getWriter();
			out.print(provArr);
			out.flush();
			out.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
