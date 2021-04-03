package com.woniu.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.woniu.entities.Goods;
import com.woniu.tools.ConnMana;

public class GoodsDao {
	public List<Goods> getAllGoods() throws SQLException{
		List<Goods> listGoods=new ArrayList<Goods>();
		Connection conn=ConnMana.getConnection();
		PreparedStatement pst=null;
		ResultSet rs=null;
		String sql="select * from goods";
		try{
			pst=conn.prepareStatement(sql);
			rs=pst.executeQuery();
			while(rs.next()){
				Integer goods_id=rs.getInt("goods_id");
				Integer type_id=rs.getInt("type_id");
				Integer supp_id=rs.getInt("supp_id");
				String goods_code=rs.getString("goods_code");
				String goods_name=rs.getString("goods_name");
				Integer goods_sum=rs.getInt("goods_sum");
				Float goods_price=rs.getFloat("goods_price");
				String goods_photo=rs.getString("goods_photo");
				String goods_desc=rs.getString("goods_desc");
				Goods goods=new Goods(goods_id, type_id, supp_id, goods_code, goods_name, goods_sum, goods_price, goods_photo, goods_desc);
				listGoods.add(goods);
				
			}
			return listGoods;
		}finally{
			ConnMana.closeSRC(pst, rs, conn);
		}
	}

	public void addGoods(Goods goods) throws SQLException {
		Connection conn=ConnMana.getConnection();
		PreparedStatement pst=null;
		ResultSet rs=null;
		String sql="insert into goods(type_id,supp_id,goods_code,goods_name,"
				+ "goods_sum,goods_price,goods_photo,goods_desc)value(?,?,?,?,?,?,?,?)";
		try{
			pst=conn.prepareStatement(sql);
			pst.setInt(1, goods.getType_id());
			pst.setInt(2, goods.getSupp_id());
			pst.setString(3, goods.getGoods_code());
			pst.setString(4, goods.getGoods_name());
			pst.setInt(5, goods.getGoods_sum());
			pst.setFloat(6, goods.getGoods_price());
			pst.setString(7, goods.getGoods_photo());
			pst.setString(8, goods.getGoods_desc());
			pst.executeUpdate();
			
		}finally{
			ConnMana.closeSRC(pst, rs, conn);
		}
		
	}

	public void deleteGoodsById(int goods_id) throws SQLException {
		Connection conn=ConnMana.getConnection();
		PreparedStatement pst=null;
		String sql="delete from goods where goods_id=?";
		try{
			pst=conn.prepareStatement(sql);
			pst.setInt(1, goods_id);
			pst.executeUpdate();
			
		}finally{
			ConnMana.closeSRC(pst, null, conn);
		}		
	}

}
