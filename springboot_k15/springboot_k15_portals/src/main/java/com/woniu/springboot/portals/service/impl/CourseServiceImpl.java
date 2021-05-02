package com.woniu.springboot.portals.service.impl;

import com.woniu.springboot.portals.entity.pojo.Course;
import com.woniu.springboot.portals.mapper.CourseMapper;
import com.woniu.springboot.portals.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CourseServiceImpl implements CourseService {
    @Autowired
    private CourseMapper courseMapper;
    @Override
    public List<Course> getFineCourses(String isfine) {
        return courseMapper.selectFineCourses(isfine);
    }

    @Override
    public List<Course> getNewestCourses() {
        return courseMapper.selectNewestCourses();
    }
}
