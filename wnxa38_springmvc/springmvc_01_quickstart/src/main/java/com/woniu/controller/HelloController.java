package com.woniu.controller;

import org.springframework.lang.Nullable;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloController implements Controller {
    @Nullable
    @Override
    public ModelAndView handleRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        String name=httpServletRequest.getParameter("name");
        String data="hello:"+name;
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("msg",data);
        modelAndView.setViewName("welcome");
        return modelAndView;
    }
}
