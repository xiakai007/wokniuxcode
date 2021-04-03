package com.woniu.mybatisinterceptor.controller;


import com.woniu.mybatisinterceptor.mbg.mapper.StuMapper;
import com.woniu.mybatisinterceptor.mbg.model.Stu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StuController {
    @Autowired
    private StuMapper stuMapper;
    @GetMapping(value = "/findById")
    public Stu findById(Integer sid){
        System.out.println("sid:"+sid);
        return stuMapper.selectByPrimaryKey(sid);
    }
}
