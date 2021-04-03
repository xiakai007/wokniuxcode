package com.woniu.k15admin.service.impl;


import com.woniu.k15admin.mapper.DeptMapper;
import com.woniu.k15admin.pojo.Dept;
import com.woniu.k15admin.service.DeptService;
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
