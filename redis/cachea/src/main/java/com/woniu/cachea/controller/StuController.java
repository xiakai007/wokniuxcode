package com.woniu.cachea.controller;

import com.woniu.cachea.entity.Stu;
import com.woniu.cachea.mapper.StuMapper;
import org.apache.ibatis.executor.CachingExecutor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StuController {
    @Autowired
    private StuMapper stuMapper;
    CachingExecutor c;
    @GetMapping(value = "/findById")
    public Stu findById(Integer sid){
        System.out.println("sid:"+sid);
        return stuMapper.selectByPrimaryKey(sid);
    }
}
