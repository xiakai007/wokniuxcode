package com.woniu.mappers;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.woniu.bean.pojo.Goods;

public interface GoodsMapper {
	/**
	 * 根据书名、作者、出版社查询
	 * @param name
	 * @param author
	 * @param publisher
	 * @return
	 */
	public List<Goods> selectGoodsByDynamicSql(@Param("name")String name,@Param("author")String author,@Param("publisher")String publisher);
	/**
	 * 关联Category的动态查询
	 * @param goods
	 * @return
	 */
	public List<Goods> selectGoodsByDSqlCategory(Goods goods);
	/**
	 * 修改商品信息
	 * @param goods
	 * @return
	 */
	public int updateGoods(Goods goods);
	/**
	 * 使用trim查询
	 * @param goods
	 * @return
	 */
	public List<Goods> selectGoodsByDSWithTrim(Goods goods);
	/**
	 * 使用trim修改
	 * @param goods
	 * @return
	 */
	public int updateGoodsWithTrim(Goods goods);
	public List<Goods> selectGoodsByIds(Integer[] ids);
	public List<Goods> selectGoodsByList(List<Integer> ids);
	public List<Goods> selectGoodsByMap(Map<String,Integer[]> mapIds);
}
