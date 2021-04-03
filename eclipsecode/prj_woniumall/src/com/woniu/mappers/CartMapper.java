package com.woniu.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.woniu.bean.pojo.Cart;
import com.woniu.bean.pojo.Goods;

public interface CartMapper {
	public int addCart(Cart cart);
	public Cart selectCartByIdToStep(@Param("id")Integer id);
	public List<Cart> selectCartByUserid(@Param("userid")Integer userid);
	public List<Cart> selectCartByGoodsid(@Param("goodsid")Integer goodsid);
	public int deleteCartByGoodsid(@Param("goodsid")Integer goodsid);
	public List<Cart> selectCartAll();
	public int getCountCartByUserid(@Param("userid")Integer userid);
	public Cart isCartExit(Cart cart);
	public int updateCartByGoodsidAndUserid(Cart cart);
}
