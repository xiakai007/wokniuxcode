package com.woniu.mappers;

import org.apache.ibatis.annotations.Param;

import com.woniu.bean.pojo.Remark;

public interface RemarkMapper {
	public Remark selectRemarkById(@Param("id")Integer id);
}
