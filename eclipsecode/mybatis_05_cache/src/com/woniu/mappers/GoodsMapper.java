package com.woniu.mappers;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.woniu.bean.pojo.Goods;

public interface GoodsMapper {
	/**
	 * �������������ߡ��������ѯ
	 * @param name
	 * @param author
	 * @param publisher
	 * @return
	 */
	public List<Goods> selectGoodsByDynamicSql(@Param("name")String name,@Param("author")String author,@Param("publisher")String publisher);
	/**
	 * ����Category�Ķ�̬��ѯ
	 * @param goods
	 * @return
	 */
	public List<Goods> selectGoodsByDSqlCategory(Goods goods);
	/**
	 * �޸���Ʒ��Ϣ
	 * @param goods
	 * @return
	 */
	public int updateGoods(Goods goods);
	/**
	 * ʹ��trim��ѯ
	 * @param goods
	 * @return
	 */
	public List<Goods> selectGoodsByDSWithTrim(Goods goods);
	/**
	 * ʹ��trim�޸�
	 * @param goods
	 * @return
	 */
	public int updateGoodsWithTrim(Goods goods);
	public List<Goods> selectGoodsByIds(Integer[] ids);
	public List<Goods> selectGoodsByList(List<Integer> ids);
	public List<Goods> selectGoodsByMap(Map<String,Integer[]> mapIds);
}
