package com.woniu.mappers;

import org.apache.ibatis.annotations.Param;

import com.woniu.bean.pojo.Category;

public interface CategoryMapper2 {
	public Category selectCategoryById(@Param("id")Integer id);

}
