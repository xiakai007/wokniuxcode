package com.woniu.springboot.portals.mapper;

import com.woniu.springboot.portals.entity.pojo.Teacher;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TeacherMapper {
    public List<Teacher> selectFamousTeachers(@Param("isfamous") String isfamous);
    public Teacher selectTeacherById(@Param("id")Integer id);
}
