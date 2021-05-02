package com.woniu.springboot.portals.service;

import com.woniu.springboot.portals.entity.pojo.Teacher;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TeacherService {
    public List<Teacher> getFamousTeachers(String isfamous);
    public Teacher selectTeacherById(Integer id);
}
