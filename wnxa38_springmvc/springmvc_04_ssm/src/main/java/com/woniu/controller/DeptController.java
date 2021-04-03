package com.woniu.controller;

import com.woniu.pojo.Dept;
import com.woniu.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RequestMapping("/dept")
@Controller
public class DeptController {
    @Autowired
    private DeptService deptService;
    @RequestMapping("/getAllDept")
    public ModelAndView getAllDept(ModelAndView modelAndView){
        List<Dept> deptList = deptService.findAllDept();
        modelAndView.addObject("deptList",deptList);
        modelAndView.setViewName("dept");
        return modelAndView;
    }
    @RequestMapping("/removeDept")
    public ModelAndView removeDept(HttpServletRequest request, ModelAndView modelAndView){
        boolean flag=true;
        String id=request.getParameter("id");
        if(id!=null){
            flag = deptService.removeDeptById(Integer.parseInt(id));
        }
        if(flag){
            //转发
            //modelAndView.setViewName("forward:/dept/selectAllDept");
            //重定向
            modelAndView.setViewName("redirect:/dept/getAllDept");
        }
        return modelAndView;
    }
}
