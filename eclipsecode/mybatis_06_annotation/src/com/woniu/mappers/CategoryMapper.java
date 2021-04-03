package com.woniu.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.woniu.bean.pojo.Category;
@Mapper
public interface CategoryMapper {
	@Select("SELECT * FROM mall_category")
	public List<Category> selectAllCategory();
	@Insert("INSERT INTO mall_category (name,status,navable)"
			+ "VALUES(#{name},#{status},#{navable})")
	public int addCategory(Category category);
	@Delete("DELETE FROM mall_category WHERE id=#{id}")
	public int deleteCategoryById(Integer id);
	@Update("UPDATE mall_category SET name=#{name},status=#{status},"
			+ "navable=#{navable} WHERE id=#{id}")
	public int updateCategory(Category category);
	/**
	 * 多对一，goods-category
	 * @param id
	 * @return
	 */
	@Select("SELECT * FROM mall_category WHERE id=#{id}")
	public Category selectCategoryById(@Param("id")Integer id);
	/**
	 * 一对多，category-goods
	 * @param id
	 * @return
	 */
	@Select("SELECT * FROM mall_category WHERE id=#{id}")
	@Results({
		@Result(property="id",column="id"),
		@Result(property="goodsList",column="id",
				many=@Many(select="com.woniu.mappers.GoodsMapper.selectGoodsByCategoryid")
		)
	})
	public Category selectCategoryByIdRef(@Param("id")Integer id);
}
