package com.woniu.springboot.admin.service.impl;


import com.woniu.springboot.admin.mapper.DeptMapper;
import com.woniu.springboot.admin.pojo.Dept;
import com.woniu.springboot.admin.service.DeptService;
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
