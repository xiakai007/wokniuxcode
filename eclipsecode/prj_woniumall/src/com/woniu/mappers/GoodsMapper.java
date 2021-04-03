package com.woniu.mappers;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.woniu.bean.pojo.Goods;

public interface GoodsMapper {
	public List<Goods> selectGoodsByCategoryId(@Param("categoryid")Integer categoryid);
	public List<Goods> selectAllGoods();
	/**
	 * ��ѯ���µ���Ʒ����
	 * @return
	 */
	public List<Goods> selectGoodsByNewest();
	public List<Goods> selectGoodsByHot();
	public Goods selectGoodsById(@Param("id")Integer id);
	public Goods selectGoodsByIdToCart(@Param("id")Integer id);
	public Goods selectHotGoodsById(@Param("id")Integer id);
	public Goods selectGoodsByIdRmk(@Param("id")Integer id);
	public int getCountGoodsByNewest();
	public int getCountGoodsByCategoryid(@Param("categoryid")Integer categoryid);
	public List<Goods> selectGoodsByName(@Param("name")String name);
	public int getCountGoodsByName(@Param("name")String name);
	/**
	 * һ���û���Ӧ�����Ʒ
	 * @param userid
	 * @return
	 */
	public List<Goods> selectGoodsByUserid(@Param("userid")Integer userid);
}
