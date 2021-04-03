package com.woniu.mybatisinterceptor.controller;

import com.woniu.mybatisinterceptor.mbg.mapper.StudentMapper;
import com.woniu.mybatisinterceptor.mbg.model.Student;
import com.woniu.mybatisinterceptor.util.MyPageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StudentController {
    @Autowired
    private StudentMapper studentMapper;
    @GetMapping("/findStudents")
    public String findStudents(){
        MyPageHelper.setOffset(3);
        MyPageHelper.setLimit(5);
        List<Student> students = studentMapper.selectByExample(null);
        System.out.println(students);
        return "查询学生成功";
    }
}
