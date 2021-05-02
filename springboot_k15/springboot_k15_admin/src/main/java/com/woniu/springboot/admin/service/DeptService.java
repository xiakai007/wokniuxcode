package com.woniu.springboot.admin.service;



import com.woniu.springboot.admin.pojo.Dept;

import java.util.List;

public interface DeptService {
    public List<Dept> selectAllDept();
}
