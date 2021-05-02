package com.woniu.springboot.portals.service.impl;

import com.woniu.springboot.portals.entity.pojo.Grade;
import com.woniu.springboot.portals.mapper.GradeMapper;
import com.woniu.springboot.portals.service.GradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class GradeServiceImpl implements GradeService {
    @Autowired
    private GradeMapper gradeMapper;
    @Override
    public List<Grade> selectAllGrades() {
        return gradeMapper.selectAllGrades();
    }
}
