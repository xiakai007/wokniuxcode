package com.woniu.gateway.config;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * 脏字过滤
 */
@WebFilter(urlPatterns = "/*")
public class RequestFilter implements Filter{
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        MyRequest myRequest = new MyRequest((HttpServletRequest)servletRequest);
        filterChain.doFilter(myRequest,servletResponse);
    }
}
