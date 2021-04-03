package com.woniu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@RequestMapping("/hello")
@Controller
public class HelloController {
    @RequestMapping("/handler1")
    public void handlerMethod1(){
        System.out.println("************/hello/handler1************");
    }
    @RequestMapping("/handler2")
    public String handlerMethod2(HttpServletRequest request){
        System.out.println("************/hello/handler2************");
        request.setAttribute("msg","返回值为String，依靠HttpServletRequest对象实现");
        return "handler2";
    }
    @RequestMapping("/handler3")
    public ModelAndView handlerMethod3(){
        System.out.println("************/hello/handler3************");
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("msg","返回值为ModelAndView");
        modelAndView.setViewName("welcome");
        return modelAndView;
    }
}
