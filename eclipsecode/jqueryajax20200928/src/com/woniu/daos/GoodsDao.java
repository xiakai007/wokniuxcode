package com.woniu.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.woniu.entities.Goods;
import com.woniu.entities.PageBean;
import com.woniu.tools.ConnMana;

public class GoodsDao {
	/**
	 * 得到符合查询条件和分页的数据
	 * @param goodsQue
	 * @param pageBean
	 * @return 页面数据pageData
	 * @throws SQLException
	 */
	public List<Goods> getAllGoods(Goods goodsQue, PageBean<Goods> pageBean) throws SQLException{
		List<Goods> listGoods=new ArrayList<Goods>();
		Connection conn=ConnMana.getConnection();
		PreparedStatement pst=null;
		ResultSet rs=null;
		String sql="select goods_id,goods.type_id,type_name,goods.supp_id,supp_name,"
				+ "goods_code,goods_name,goods_sum,goods_price,goods_photo,goods_desc "
				+ "from goods left join goodstype on goods.type_id=goodstype.type_id "
				+ "left join supplier on goods.supp_id=supplier.supp_id where 1=1";
		if(goodsQue.getGoods_code()!=null&&!goodsQue.getGoods_code().equals("")){
			sql=sql+" and goods_code=?";
		}
		if(goodsQue.getSupp_name()!=null&&!goodsQue.getSupp_name().equals("")){
			sql=sql+" and supp_name like ?";
		}
		if(goodsQue.getType_name()!=null&&!goodsQue.getType_name().equals("")){
			sql=sql+" and type_name like ?";
		}
		sql=sql+" limit ?,?";
		
		try{
			pst=conn.prepareStatement(sql);
			//设置的占位符，用于计数
			int count=0;
			if(goodsQue.getGoods_code()!=null&&!goodsQue.getGoods_code().equals("")){
				count++;
				pst.setString(count, goodsQue.getGoods_code());
			}
			if(goodsQue.getSupp_name()!=null&&!goodsQue.getSupp_name().equals("")){
				count++;
				pst.setString(count, "%"+goodsQue.getSupp_name()+"%");
			}
			if(goodsQue.getType_name()!=null&&!goodsQue.getType_name().equals("")){
				count++;
				pst.setString(count, "%"+goodsQue.getType_name()+"%");
			}
			count++;
			pst.setInt(count, (pageBean.getCurrentPage()-1)*pageBean.getPageSize());
			count++;
			pst.setInt(count, pageBean.getPageSize());
			
			rs=pst.executeQuery();
			while(rs.next()){
				Integer goods_id=rs.getInt("goods_id");
				Integer type_id=rs.getInt("type_id");
				String type_name=rs.getString("type_name");
				Integer supp_id=rs.getInt("supp_id");
				String supp_name=rs.getString("supp_name");
				String goods_code=rs.getString("goods_code");
				String goods_name=rs.getString("goods_name");
				Integer goods_sum=rs.getInt("goods_sum");
				Float goods_price=rs.getFloat("goods_price");
				String goods_photo=rs.getString("goods_photo");
				String goods_desc=rs.getString("goods_desc");
				Goods goods=new Goods(goods_id, type_id, supp_id, goods_code, goods_name, goods_sum, goods_price, goods_photo, goods_desc);
				goods.setType_name(type_name);
				goods.setSupp_name(supp_name);
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

	public Goods getGoodsById(int id) throws SQLException {
		Connection conn=ConnMana.getConnection();
		PreparedStatement pst=null;
		ResultSet rs=null;
		Goods goods=null;
		String sql="select * from goods where goods_id=?";
		try{
			pst=conn.prepareStatement(sql);
			pst.setInt(1, id);
			rs=pst.executeQuery();
			if(rs.next()){
				Integer goods_id=rs.getInt("goods_id");
				Integer type_id=rs.getInt("type_id");
				Integer supp_id=rs.getInt("supp_id");
				String goods_code=rs.getString("goods_code");
				String goods_name=rs.getString("goods_name");
				Integer goods_sum=rs.getInt("goods_sum");
				Float goods_price=rs.getFloat("goods_price");
				String goods_photo=rs.getString("goods_photo");
				String goods_desc=rs.getString("goods_desc");
				goods=new Goods(goods_id, type_id, supp_id, goods_code, goods_name, goods_sum, goods_price, goods_photo, goods_desc);
			}
			return goods;
		}finally{
			ConnMana.closeSRC(pst, null, conn);
		}
	}

	public void updateGoods(Goods goods) throws SQLException {
		Connection conn=ConnMana.getConnection();
        PreparedStatement pst=null;
        String sql="update goods set type_id=?,supp_id=?,goods_code=?,goods_name=?,goods_sum=?,goods_price=?,goods_photo=?,goods_desc=? where goods_id=?";
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
        	pst.setInt(9, goods.getGoods_id());
            pst.executeUpdate();
        }finally{
        	ConnMana.closeSRC(pst, null, conn);
        }		
	}

	public int getAllCount(Goods goodsQue) throws SQLException {
		Connection conn=ConnMana.getConnection();
		PreparedStatement pst=null;
		ResultSet rs=null;
		String sql="select count(goods_id) as 'amount' from goods left join goodstype on goods.type_id=goodstype.type_id "
				+ "left join supplier on goods.supp_id=supplier.supp_id where 1=1";
		if(goodsQue.getGoods_code()!=null&&!goodsQue.getGoods_code().equals("")){
			sql=sql+" and goods_code=?";
		}
		if(goodsQue.getSupp_name()!=null&&!goodsQue.getSupp_name().equals("")){
			sql=sql+" and supp_name like ?";
		}
		if(goodsQue.getType_name()!=null&&!goodsQue.getType_name().equals("")){
			sql=sql+" and type_name like ?";
		}
		try{
			pst=conn.prepareStatement(sql);
			int count=0;
			if(goodsQue.getGoods_code()!=null&&!goodsQue.getGoods_code().equals("")){
				count++;
				pst.setString(count, goodsQue.getGoods_code());
			}
			if(goodsQue.getSupp_name()!=null&&!goodsQue.getSupp_name().equals("")){
				count++;
				pst.setString(count, "%"+goodsQue.getSupp_name()+"%");
			}
			if(goodsQue.getType_name()!=null&&!goodsQue.getType_name().equals("")){
				count++;
				pst.setString(count, "%"+goodsQue.getType_name()+"%");
			}
			rs=pst.executeQuery();
			if(rs.next()){
				return rs.getInt("amount");
			}
		}finally{
			ConnMana.closeSRC(pst, rs, conn);
		}
		return 0;
	}
    /**
     * 只获取商品的id和名称
     * @return
     * @throws SQLException
     */
	public List<Goods> getAllGoods() throws SQLException {
		Connection conn=ConnMana.getConnection();
		PreparedStatement pst=null;
		ResultSet rs=null;
		List<Goods> listGoods=new ArrayList<>();
		Goods goods=null;
		String sql="select * from goods";
		try{
			pst=conn.prepareStatement(sql);
			rs=pst.executeQuery();
			while(rs.next()){
				Integer goods_id=rs.getInt("goods_id");
				String goods_name=rs.getString("goods_name");
				goods=new Goods(goods_id,goods_name);
				listGoods.add(goods);
			}
			return listGoods;
		}finally{
			ConnMana.closeSRC(pst, rs, conn);
		}
	}

	public void deleteAllGoods(String goodsIds) throws SQLException {
		Connection conn=ConnMana.getConnection();
		PreparedStatement pst=null;
		String sql="delete from goods where goods_id in("+goodsIds+")";
		try{
			pst=conn.prepareStatement(sql);
			pst.executeUpdate();
		}finally{
			ConnMana.closeSRC(pst, null, conn);
		}
	}

	

}
