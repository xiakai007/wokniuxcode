package com.woniu.controller;

import com.woniu.pojo.Dept;
import com.woniu.service.DeptService;
import com.woniu.util.R;
import com.woniu.util.ResultCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value="/dept")
public class DeptController {
    @Autowired
    public DeptService deptService;
    @GetMapping(value="/depts")
    public R selectAllDept(){
        List<Dept> depts = deptService.selectAllDept();
        if(depts!=null&&depts.size()>0){
            return R.ok().code(ResultCode.DEPTALLSECCESS).data("depts",depts);
        }
        return null;
    }
}
