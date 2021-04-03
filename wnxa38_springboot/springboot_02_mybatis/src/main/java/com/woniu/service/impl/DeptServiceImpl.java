package com.woniu.service.impl;

import com.woniu.mapper.DeptMapper;
import com.woniu.pojo.Dept;
import com.woniu.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeptServiceImpl implements DeptService {
    @Autowired
    private DeptMapper deptMapper;
    @Override
    public List<Dept> selectAllDept() {
        return deptMapper.selectAllDept();
    }
}
