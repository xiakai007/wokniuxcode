package com.woniu.mapper;

import com.woniu.bean.pojo.Dept;
import org.apache.ibatis.annotations.Param;

public interface DeptMapper {
    public Dept selectDeptById(@Param("id") Integer id);
}
