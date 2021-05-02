package com.woniu.springboot.portals.service;

import com.woniu.springboot.portals.entity.pojo.Course;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CourseService {
    public List<Course> getFineCourses(String isfine);
    public List<Course> getNewestCourses();
}
