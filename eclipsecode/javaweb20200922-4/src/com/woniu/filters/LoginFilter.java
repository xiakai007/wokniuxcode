package com.woniu.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginFilter implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpServletRequest hreq=(HttpServletRequest)req;
		HttpServletResponse hresp=(HttpServletResponse)resp;
		HttpSession session=hreq.getSession();
		String path=hreq.getServletPath();
		//已登陆状态、登陆页面、登陆路径和静态资源予以放行
		if(session.getAttribute("loginUser")!=null||path.equals("/login.jsp")||path.equals("/login.do")||path.equals("/static")){
			chain.doFilter(hreq, hresp);
			return;
		}
		hresp.sendRedirect("login.jsp");
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
