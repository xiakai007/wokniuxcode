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
		String sql="select mall_goods.id,mall_goods.name,goodsno,author,publisher,"
				+ "mall_category.id as 'categoryid',mall_category.name as 'categoryname',image,newest,hot "
				+ "from mall_goods left join "
				+ "mall_category on mall_goods.categoryid=mall_category.id "
				+ "where 1=1";
		if(goodsQue.getName()!=null&&!goodsQue.getName().equals("")){
			sql=sql+" and name like ?";
		}
		if(goodsQue.getAuthor()!=null&&!goodsQue.getAuthor().equals("")){
			sql=sql+" and author like ?";
		}
		if(goodsQue.getPublisher()!=null&&!goodsQue.getPublisher().equals("")){
			sql=sql+" and publisher like ?";
		}
		sql=sql+" limit ?,?";
		
		try{
			pst=conn.prepareStatement(sql);
			//设置的占位符，用于计数
			int count=0;
			if(goodsQue.getName()!=null&&!goodsQue.getName().equals("")){
				count++;
				pst.setString(count, "%"+goodsQue.getName()+"%");
			}
			if(goodsQue.getAuthor()!=null&&!goodsQue.getAuthor().equals("")){
				count++;
				pst.setString(count, "%"+goodsQue.getAuthor()+"%");
			}
			if(goodsQue.getPublisher()!=null&&!goodsQue.getPublisher().equals("")){
				count++;
				pst.setString(count, "%"+goodsQue.getPublisher()+"%");
			}
			count++;
			pst.setInt(count, (pageBean.getCurrentPage()-1)*pageBean.getPageSize());
			count++;
			pst.setInt(count, pageBean.getPageSize());
			
			rs=pst.executeQuery();
			while(rs.next()){
				Integer id=rs.getInt("id");
				String name=rs.getString("name");
				String goodsno=rs.getString("goodsno");
				String author=rs.getString("author");
				String publisher=rs.getString("publisher");
				Integer categoryid=rs.getInt("categoryid");
				String categoryname=rs.getString("categoryname");
				String image=rs.getString("image");
				String newest=rs.getString("newest");
				String hot=rs.getString("hot");
				Goods goods=new Goods(id,name,goodsno,author,publisher,categoryid,newest,hot);
				goods.setCategoryname(categoryname);
				goods.setImage(image);
				listGoods.add(goods);
			}
			return listGoods;
		}finally{
			ConnMana.closeSRC(pst, rs, conn);
		}
	}

	public int getAllCount(Goods goodsQue) throws SQLException {
		Connection conn=ConnMana.getConnection();
		PreparedStatement pst=null;
		ResultSet rs=null;
		String sql="select count(mall_goods.id) as 'amount' from mall_goods left join mall_category on mall_goods.id=mall_category.id "
				+ "where 1=1";
		if(goodsQue.getName()!=null&&!goodsQue.getName().equals("")){
			sql=sql+" and name like ?";
		}
		if(goodsQue.getAuthor()!=null&&!goodsQue.getAuthor().equals("")){
			sql=sql+" and author like ?";
		}
		if(goodsQue.getPublisher()!=null&&!goodsQue.getPublisher().equals("")){
			sql=sql+" and publisher like ?";
		}
		try{
			pst=conn.prepareStatement(sql);
			int count=0;
			if(goodsQue.getName()!=null&&!goodsQue.getName().equals("")){
				count++;
				pst.setString(count, "%"+goodsQue.getName()+"%");
			}
			if(goodsQue.getAuthor()!=null&&!goodsQue.getAuthor().equals("")){
				count++;
				pst.setString(count, "%"+goodsQue.getAuthor()+"%");
			}
			if(goodsQue.getPublisher()!=null&&!goodsQue.getPublisher().equals("")){
				count++;
				pst.setString(count, "%"+goodsQue.getPublisher()+"%");
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
	public void addGoods(Goods goods) throws SQLException {
		Connection conn=ConnMana.getConnection();
		PreparedStatement pst=null;
		ResultSet rs=null;
		String sql="insert into mall_goods(name,goodsno,author,publisher,"
				+ "categoryid,newest,hot)value(?,?,?,?,?,?,?)";
		try{
			pst=conn.prepareStatement(sql);
			pst.setString(1, goods.getName());
			pst.setString(2, goods.getGoodsno());
			pst.setString(3, goods.getAuthor());
			pst.setString(4, goods.getPublisher());
			pst.setInt(5, goods.getCategoryid());
			pst.setString(6, goods.getNewest());
			pst.setString(7, goods.getHot());
			pst.executeUpdate();
		}finally{
			ConnMana.closeSRC(pst, rs, conn);
		}
	}
	public void deleteGoodsById(int id) throws SQLException {
		Connection conn=ConnMana.getConnection();
		PreparedStatement pst=null;
		String sql="delete from mall_goods where id=?";
		try{
			pst=conn.prepareStatement(sql);
			pst.setInt(1, id);
			pst.executeUpdate();
			
		}finally{
			ConnMana.closeSRC(pst, null, conn);
		}		
	}
	public void deleteAllGoods(String goodsIds) throws SQLException {
		Connection conn=ConnMana.getConnection();
		PreparedStatement pst=null;
		String sql="delete from mall_goods where id in("+goodsIds+")";
		try{
			pst=conn.prepareStatement(sql);
			pst.executeUpdate();
		}finally{
			ConnMana.closeSRC(pst, null, conn);
		}
	}
	public Goods getGoodsById(int gid) throws SQLException {
		Connection conn=ConnMana.getConnection();
		PreparedStatement pst=null;
		ResultSet rs=null;
		Goods goods=null;
		String sql="select * from mall_goods where id=?";
		try{
			pst=conn.prepareStatement(sql);
			pst.setInt(1, gid);
			rs=pst.executeQuery();
			if(rs.next()){
				Integer id=rs.getInt("id");
				String name=rs.getString("name");
				String goodsno=rs.getString("goodsno");
				String author=rs.getString("author");
				String publisher=rs.getString("publisher");
				Integer categoryid=rs.getInt("categoryid");
				String image=rs.getString("image");
				String newest=rs.getString("newest");
				String hot=rs.getString("hot");
				goods=new Goods(id, name, goodsno, author, publisher, categoryid, newest, hot);
				goods.setImage(image);
			}
			return goods;
		}finally{
			ConnMana.closeSRC(pst, null, conn);
		}
	}
	public void updateGoods(Goods goods) throws SQLException {
		Connection conn=ConnMana.getConnection();
        PreparedStatement pst=null;
        String sql="update mall_goods set name=?,goodsno=?,author=?,publisher=?,categoryid=?,image=?,newest=?,hot=? where id=?";
        try{
        	pst=conn.prepareStatement(sql);
        	pst.setString(1, goods.getName());
        	pst.setString(2, goods.getGoodsno());
        	pst.setString(3, goods.getAuthor());
        	pst.setString(4, goods.getPublisher());
        	pst.setInt(5, goods.getCategoryid());
        	pst.setString(6, goods.getImage());
        	pst.setString(7, goods.getNewest());
        	pst.setString(8, goods.getHot());
        	pst.setInt(9, goods.getId());
            pst.executeUpdate();
        }finally{
        	ConnMana.closeSRC(pst, null, conn);
        }		
	}
}
