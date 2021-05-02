package com.woniu.springboot.portals.mapper;

import com.woniu.springboot.portals.entity.pojo.Subject;
import org.apache.ibatis.annotations.Param;

public interface SubjectMapper {
    public Subject selectSubjectById(@Param("id") Integer id);
}
