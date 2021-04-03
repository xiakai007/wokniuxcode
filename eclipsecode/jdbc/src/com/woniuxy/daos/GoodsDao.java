package com.woniuxy.daos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.woniuxy.entities.Goods;
import com.woniuxy.tools.ConnectionManager;

/**
 * 此类中完成持久化操作
 * @author xiakai
 *
 */
public class GoodsDao {
	/**
	 * 加入一个商品
	 * @param goods
	 */
	public void addGoods(Goods goods) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		Connection conn = null;
		PreparedStatement pst = null;
		try {
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/goods_dqlquery?characterEncoding=utf8&useSSL=false&serverTimezone=Asia/Shanghai", "root","123456");
			String sql = "insert into goods(goodsName,goodsCostPrice,goodsCount,goodsType)values(?,?,?,?)";
			pst = conn.prepareStatement(sql);
			pst.setString(1, goods.getGoodsName());
			pst.setFloat(2, goods.getGoodsCostPrice());
			pst.setInt(3, goods.getGoodsCount());
			pst.setInt(4, goods.getGoodsType());
			//方法的返回值代表影响的SQL语句第几行
			int re = pst.executeUpdate();
			System.out.println("影响了SQL语句中的第"+re+"行");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	/**
	 * 根据商品ID删除一个商品
	 * @param goodsId
	 */
	public void deleteGoodsById(Integer goodsId) {
		Connection conn = null;
		PreparedStatement pst = null;
		conn = ConnectionManager.getCounnection();
		String sql = "delete from goods where goodsId=?";
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, goodsId);
			//方法的返回值代表SQL语句影响了第几行
			int re = pst.executeUpdate();
			System.out.println("delete方法的SQL语句影响了第"+re+"行");
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			ConnectionManager.close(pst, conn);
		}
		
	}
	/**
	 * 修改（更新）一个商品
	 * @param good
	 */
	public void UpdateGoods(Goods goods) {
		Connection conn = null;
		PreparedStatement pst = null;
		conn = ConnectionManager.getCounnection();
		String sql = "update goods set goodsName=?,goodsCostPrice=?,goodsCount=?,goodsType=? where goodsId=?";
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, goods.getGoodsName());
			pst.setFloat(2, goods.getGoodsCostPrice());
			pst.setInt(3, goods.getGoodsCount());
			pst.setInt(4, goods.getGoodsType());
			pst.setInt(5, goods.getGoodsId());
			int re = pst.executeUpdate();
			System.out.println("Update方法的SQL语句影响了第"+re+"行");
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			ConnectionManager.close(pst, conn);
		}
	}
	/**
	 * 浏览所有商品
	 * @return
	 */
	public List<Goods> getAllGoods(){
		Connection conn = null;
		PreparedStatement pst = null;
		//结果集
		ResultSet rs= null;
		conn = ConnectionManager.getCounnection();
		List<Goods> listGoods = new ArrayList<>();
		String sql = "select * from Goods";
		try {
			pst = conn.prepareStatement(sql);
			//返回结果集
			rs = pst.executeQuery();
			while(rs.next()) {
				//rs.getInt("goodsId"),参数与和结果集中的列名保持一致，与数据库中表goods中的列名无关
				Integer goodsId = rs.getInt("goodsId");
				String goodsName = rs.getString("goodsName");
				Float goodsCostPrice = rs.getFloat("goodsCostPrice");
				Integer goodsCount = rs.getInt("goodsCount");
				Integer goodsType = rs.getInt("goodsType");
				Goods goods = new Goods(goodsId,goodsName,goodsCostPrice,goodsCount,goodsType);
				listGoods.add(goods);
				
			}
			return listGoods;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}finally {
			ConnectionManager.close(pst, conn);
			ConnectionManager.closeResultSet(rs);
		}
		
	}
	public List<Goods> getGoodsName(){
		Connection conn = null;
		PreparedStatement pst = null;
		//结果集
		ResultSet rs= null;
		conn = ConnectionManager.getCounnection();
		List<Goods> listGoodsName = new ArrayList<>();
		String sql = "select * from Goods";
		try {
			pst = conn.prepareStatement(sql);
			//返回结果集
			rs = pst.executeQuery();
			while(rs.next()) {
				//rs.getInt("goodsId"),参数与和结果集中的列名保持一致，与数据库中表goods中的列名无关
				String goodsName = rs.getString(2);
				Goods goods = new Goods(goodsName);
				listGoodsName.add(goods);
				
			}
			return listGoodsName;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}finally {
			ConnectionManager.close(pst, conn);
			ConnectionManager.closeResultSet(rs);
		}
		
	}
	
	public Goods getGoodById(Integer id) {
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		Goods good = null;
		String sql = "select * from goods where goodsId=?";
		conn = ConnectionManager.getCounnection();
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, id);
			rs = pst.executeQuery();
			if(rs.next()) {
				Integer goodsId = rs.getInt("goodsId");
				String goodsName = rs.getString("goodsName");
				Float goodsCostPrice = rs.getFloat("goodsCostPrice");
				Integer goodsCount = rs.getInt("goodsCount");
				Integer goodsType = rs.getInt("goodsType");
				good = new Goods(goodsId,goodsName,goodsCostPrice,goodsCount,goodsType);
			}
			return good;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}finally {
			ConnectionManager.close(pst, conn);
			ConnectionManager.closeResultSet(rs);
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
