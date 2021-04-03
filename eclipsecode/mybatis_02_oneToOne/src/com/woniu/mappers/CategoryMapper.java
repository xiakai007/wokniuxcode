package com.woniu.mappers;

import org.apache.ibatis.annotations.Param;

import com.woniu.bean.pojo.Category;

public interface CategoryMapper {
	public Category selectByIdToStep(@Param("id")Integer id);

}
