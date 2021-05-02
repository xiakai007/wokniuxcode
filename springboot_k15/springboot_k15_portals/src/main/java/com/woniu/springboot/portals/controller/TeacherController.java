package com.woniu.springboot.portals.controller;

import com.woniu.springboot.portals.entity.pojo.Teacher;
import com.woniu.springboot.portals.exception.K15Exception;
import com.woniu.springboot.portals.service.TeacherService;
import com.woniu.springboot.portals.util.Constaint;
import com.woniu.springboot.portals.util.R;
import com.woniu.springboot.portals.util.ResultCode;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@Slf4j
@CrossOrigin
@RestController
@RequestMapping(value = "/teacher")
public class TeacherController {
    @Autowired
    private TeacherService teacherService;
    @ApiOperation(value ="获取所有的名师信息")
    @GetMapping(value = "/getFamousTeachers")
    public R getFamousTeachers(String isfamous){
        List<Teacher> famousTeachers = teacherService.getFamousTeachers(isfamous);
        if(famousTeachers!=null&&famousTeachers.size()>0){
            return R.ok().data("famousTeachers",famousTeachers);
        }else{
            throw new K15Exception(ResultCode.FAMOUSTEACHERNULL, Constaint.FAMOUSTEACHERNULL);
        }
    }
    @ApiOperation(value = "根据id获取老师信息")
    @GetMapping(value = "/getTeacherById")
    public R getTeacherById(Integer id){
        log.info("id:"+id);
        Teacher teacherView = teacherService.selectTeacherById(id);
        if(teacherView!=null){
            return R.ok().data("teacherView",teacherView);
        }else{
            throw new K15Exception(ResultCode.TEACHERVIEWNULL,Constaint.TEACHERVIEWNULL);
        }
    }
}
