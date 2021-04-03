package com.woniu.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.woniu.utils.TemplateUtil;

@WebServlet("/exit")
public class ExitServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
    public ExitServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doGet(request, response);
	}

	protected void safeExit(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session=request.getSession();
		session.removeAttribute("user");
		TemplateUtil.process("login", request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
