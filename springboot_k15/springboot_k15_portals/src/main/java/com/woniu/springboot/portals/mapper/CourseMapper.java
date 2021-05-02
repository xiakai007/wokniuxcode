package com.woniu.springboot.portals.mapper;

import com.woniu.springboot.portals.entity.pojo.Course;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CourseMapper {
    public List<Course> selectFineCourses(@Param("isfine") String isfine);
    public List<Course> selectNewestCourses();
}
