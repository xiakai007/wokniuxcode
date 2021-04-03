package com.woniu.mappers;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;

import com.woniu.bean.pojo.Goods;
import com.woniu.providers.GoodsProvider;
@Mapper
public interface GoodsMapper {
	/**
	 * ���һ��goods-category
	 * @param goodsno
	 * @return
	 */
	@Select("SELECT * FROM mall_goods WHERE goodsno=#{goodsno}")
	@Results({
		@Result(
				property="category",column="categoryid",
				one=@One(select="com.woniu.mappers.CategoryMapper.selectCategoryById")
		)
	})
	public Goods selectGoodsByGoodsno(@Param("goodsno")String goodsno);
	/**
	 * һ�Զ࣬category-goods
	 * @param categoryid
	 * @return
	 */
	@Select("SELECT * FROM mall_goods WHERE categoryid=#{categoryid}")
	public List<Goods> selectGoodsByCategoryid(@Param("categoryid")Integer categoryid);
	/**
	 * ��̬sql����ѯ
	 * @param goods
	 * @return
	 */
	@SelectProvider(type=GoodsProvider.class,method="selectDynamicSqlByGoods")
	public List<Goods> selectGoodsByDSqlGoods(Goods goods);
	/**
	 * ��̬sql������
	 * @param goods
	 * @return
	 */
	@UpdateProvider(type=GoodsProvider.class,method="updateDynamicSql")
	public int updateGoods(Goods goods);
	@SelectProvider(type=GoodsProvider.class,method="selectDSqlByMap")
	public List<Goods> selectGoodsByDSqlMap(Map<String,Object> mapParams);
}
