package com.woniu.mappers;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.woniu.bean.pojo.Goods;
import com.woniu.bean.vo.GoodsQuery;

public interface GoodsMapper {
	public void addGoods(Goods goods);
	public void deleteGoods(Integer id);
	public void updateGoods(Goods goods);
    public Goods selectGoods(Integer id);
    public List<Goods> selectAllGoods();
    public List<Goods> selectGoodsByNewest(@Param("newest")String newest);
    public List<Goods> selectGoodsByAuthor(@Param("author")String author);
    public List<Goods> selectGoodsByAuthorAndHot(@Param("author")String author,@Param("hot")String hot);
    public List<Goods> selectGoodsByAuthorAndPublisher(GoodsQuery goodsQuery);
    public List<Goods> selectGoodsByNameAndPublisherWithMap(Map mapQuery);
}
