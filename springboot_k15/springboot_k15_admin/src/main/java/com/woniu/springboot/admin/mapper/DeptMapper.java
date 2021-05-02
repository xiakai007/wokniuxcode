package com.woniu.springboot.admin.mapper;


import com.woniu.springboot.admin.pojo.Dept;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DeptMapper {
    public List<Dept> selectAllDept();
    public Dept selectDeptById(@Param("id") Integer id);
    public int deleteDeptById(@Param("id") Integer id);
}
