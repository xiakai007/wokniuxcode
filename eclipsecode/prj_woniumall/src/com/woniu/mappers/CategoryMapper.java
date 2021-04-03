package com.woniu.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.woniu.bean.pojo.Category;
import com.woniu.bean.pojo.Goods;

public interface CategoryMapper {
	public Category selectCategoryById(@Param("id")Integer id);
	public List<Category> selectCategoryByNavable();
	public List<Category> selectCategoryByNotNavable();
}
