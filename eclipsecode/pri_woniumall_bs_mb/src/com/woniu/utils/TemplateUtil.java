package com.woniu.utils;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.templateresolver.ServletContextTemplateResolver;

public class TemplateUtil {
	public static void process(String page,HttpServletRequest request, HttpServletResponse response){
		TemplateEngine engine = new TemplateEngine();
		ServletContextTemplateResolver templateResolver = new ServletContextTemplateResolver(request.getServletContext());
		templateResolver.setPrefix("/WEB-INF/templates/");
		templateResolver.setSuffix(".html");
		templateResolver.setCharacterEncoding("UTF-8");
		engine.setTemplateResolver(templateResolver);
		WebContext context = new WebContext(request, response, request.getServletContext());
		response.setCharacterEncoding("UTF-8");
		PrintWriter writer=null;
		try {
			writer=response.getWriter();
		} catch (IOException e) {
			e.printStackTrace();
		}
		engine.process(page, context, writer);
	}
}
