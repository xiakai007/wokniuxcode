package com.woniu.springboot.admin.controller;


import com.woniu.springboot.admin.pojo.Dept;
import com.woniu.springboot.admin.service.DeptService;
import com.woniu.springboot.admin.util.R;
import com.woniu.springboot.admin.util.ResultCode;
import io.swagger.annotations.ApiOperation;
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
    @ApiOperation(value="查询所有部门信息")
    @GetMapping(value="/depts")
    public R selectAllDept(){
        List<Dept> depts = deptService.selectAllDept();
        if(depts!=null&&depts.size()>0){
            return R.ok().code(ResultCode.DEPTALLSECCESS).data("depts",depts);
        }
        return null;
    }
}
