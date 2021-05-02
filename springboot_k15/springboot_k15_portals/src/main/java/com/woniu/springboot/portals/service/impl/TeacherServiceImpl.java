package com.woniu.springboot.portals.service.impl;

import com.woniu.springboot.portals.entity.pojo.Teacher;
import com.woniu.springboot.portals.mapper.TeacherMapper;
import com.woniu.springboot.portals.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TeacherServiceImpl implements TeacherService {
    @Autowired
    private TeacherMapper teacherMapper;
    @Override
    public List<Teacher> getFamousTeachers(String isfamous) {
        return teacherMapper.selectFamousTeachers(isfamous);
    }

    @Override
    public Teacher selectTeacherById(Integer id) {
        return teacherMapper.selectTeacherById(id);
    }
}
