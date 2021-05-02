package com.woniu.springboot.portals.controller;

import com.github.pagehelper.PageHelper;
import com.woniu.springboot.portals.entity.pojo.Course;
import com.woniu.springboot.portals.exception.K15Exception;
import com.woniu.springboot.portals.service.CourseService;
import com.woniu.springboot.portals.util.Constaint;
import com.woniu.springboot.portals.util.R;
import com.woniu.springboot.portals.util.ResultCode;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/course")
@CrossOrigin
public class CourseController {
    @Autowired
    private CourseService courseService;
    @ApiOperation(value = "获取精品课程信息")
    @GetMapping(value = "/getFineCourse")
    /*get请求时参数追加在路径中，前台传来的是JSON格式数据*/
    public R getFineCourse(/*@ApiParam(required = true,name="isfine",value = "取值y或n")*/ String isfine){
        PageHelper.startPage(1,8);
        List<Course> fineCourses = courseService.getFineCourses(isfine);
        if(fineCourses!=null&&fineCourses.size()>0){
            return R.ok().data("fineCourses",fineCourses);
        }else{
            throw  new K15Exception(ResultCode.FINECOURSENULL, Constaint.FINECOURSENULL);
        }
    }
    //get的第4种、第5种方式的路径
    @GetMapping(value = "/getFineCourseFourth/{isfine}")
    public R getFineCourseFourth(/*@ApiParam(required = true,name="isfine",value = "取值y或n")*/ @PathVariable("isfine") String isfine){
        List<Course> fineCourses = courseService.getFineCourses(isfine);
        if(fineCourses!=null&&fineCourses.size()>0){
            return R.ok().data("fineCourses",fineCourses);
        }else{
            throw  new K15Exception(ResultCode.FINECOURSENULL, Constaint.FINECOURSENULL);
        }
    }
    @ApiOperation(value = "获取最新课程信息")
    @GetMapping(value = "/getNewestCourses")
    public R getNewestCourses(){
        PageHelper.startPage(1,8);
        List<Course> newestCourses = courseService.getNewestCourses();
        if(newestCourses!=null&&newestCourses.size()>0){
            return R.ok().data("newestCourses",newestCourses);
        }else{
            throw new K15Exception(ResultCode.NEWESTCOURSENULL,Constaint.NEWESTCOURSENULL);
        }
    }
}
