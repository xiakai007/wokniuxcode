package com.woniu.springboot.portals.service;

import com.woniu.springboot.portals.entity.pojo.Grade;

import java.util.List;

public interface GradeService {
    public List<Grade> selectAllGrades();
}
