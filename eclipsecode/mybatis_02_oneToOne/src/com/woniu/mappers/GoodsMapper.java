package com.woniu.mappers;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.woniu.bean.pojo.Goods;

public interface GoodsMapper {
	public List<Goods> selectGoodsAll();
	public Goods selectGoodsById(@Param("id")Integer id);
}
