package com.woniu.springboot.portals.mapper;

import com.woniu.springboot.portals.entity.pojo.Grade;

import java.util.List;

public interface GradeMapper {
    public List<Grade> selectAllGrades();
}
