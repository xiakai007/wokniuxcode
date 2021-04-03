package com.woniu.service.impl;

import com.woniu.mapper.DeptMapper;
import com.woniu.pojo.Dept;
import com.woniu.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class DeptServiceImpl implements DeptService {
    @Autowired
    private DeptMapper deptMapper;
    @Override
    @Transactional(readOnly = true,propagation= Propagation.NOT_SUPPORTED)
    public List<Dept> findAllDept() {
        return deptMapper.selectAllDept();
    }

    @Override
    public boolean removeDeptById(Integer id) {
        return deptMapper.deleteDeptById(id)>0?true:false;
    }
}
