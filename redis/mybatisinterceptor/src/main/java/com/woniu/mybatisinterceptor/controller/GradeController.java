package com.woniu.mybatisinterceptor.controller;

import com.woniu.mybatisinterceptor.mbg.mapper.GradeMapper;
import com.woniu.mybatisinterceptor.mbg.model.Grade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GradeController {
    @Autowired
    private GradeMapper gradeMapper;
    @GetMapping("/findGrades")
    public String findGrades(){
        List<Grade> grades = gradeMapper.selectByExample(null);
        System.out.println(grades);
        return "查询年级成功";
    }
}
