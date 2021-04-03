package com.woniu.service;

import com.woniu.pojo.Dept;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DeptService {
    public List<Dept> findAllDept();
    public boolean removeDeptById(Integer id);
}
