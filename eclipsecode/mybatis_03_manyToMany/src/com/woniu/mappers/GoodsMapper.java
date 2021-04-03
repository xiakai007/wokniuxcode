package com.woniu.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.woniu.bean.pojo.Goods;

public interface GoodsMapper {
	public List<Goods> selectGoodsByUserid(@Param("userid")Integer userid);
	public Goods selectGoodsByid(@Param("id")Integer id);
	public List<Goods> selectGoodsByPage();
}
