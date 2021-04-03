package com.woniu.jd.mapper;

import com.woniu.jd.pojo.entity.Goods;
import org.springframework.stereotype.Repository;

import java.util.List;
public interface GoodsMapper {
    List<Goods> selectGoodsAll();
    int insertGoods(Goods goodsAdd);
}
