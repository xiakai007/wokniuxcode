package com.woniu.springboot.portals.controller;

import com.woniu.springboot.portals.entity.pojo.Grade;
import com.woniu.springboot.portals.exception.K15Exception;
import com.woniu.springboot.portals.service.GradeService;
import com.woniu.springboot.portals.util.Constaint;
import com.woniu.springboot.portals.util.R;
import com.woniu.springboot.portals.util.ResultCode;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
//解决跨域问题，使用@CrossOrigin注解
@CrossOrigin
@RestController
@Slf4j
@RequestMapping(value = "/grade")
public class GradeController {
    @Autowired
    private GradeService gradeService;
    @ApiOperation(value = "获取所有的班级信息")
    @GetMapping(value = "/getAllGrades")
    public R getAllGrades(){
        List<Grade> grades = gradeService.selectAllGrades();
        if(grades!=null&&grades.size()>0){
            return R.ok().data("grades",grades);
        }else{
            throw new K15Exception(ResultCode.GRADELISTNULL, Constaint.GRADELISTNULL);
        }
    }
    @ApiOperation(value = "添加年级")
    @PostMapping(value = "/addGrade")
    /*POST请求时接受前端JSON格式数据时参数必须使用@RequestBody来接受*/
    public R addGrade(@RequestBody Grade grade){
        log.info("班级id:"+grade.getId());
        log.info("班级名称:"+grade.getName());
        log.info("课程数量:"+grade.getCoursenum());
        return R.ok();
    }
}
