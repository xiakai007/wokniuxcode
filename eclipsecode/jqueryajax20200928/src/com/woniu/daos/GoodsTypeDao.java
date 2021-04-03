package com.woniu.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.woniu.entities.GoodsType;
import com.woniu.entities.PageBean;
import com.woniu.tools.ConnMana;

public class GoodsTypeDao {
	public List<GoodsType> getAllTypes(GoodsType goodsTypeQue,PageBean<GoodsType> pageTypeQue) throws SQLException{
		List<GoodsType> listTypes=new ArrayList<>();
		Connection conn=ConnMana.getConnection();
		PreparedStatement pst=null;
		ResultSet rs=null;
		String sql="select * from goodstype where 1=1";
		if(goodsTypeQue.getType_code()!=null&&!goodsTypeQue.getType_code().equals("")){
			sql=sql+" and type_code=?";
		}
		if(goodsTypeQue.getType_name()!=null&&!goodsTypeQue.getType_name().equals("")){
			sql=sql+" and type_name like ?";
		}
		sql=sql+" limit ?,?";
		try{
			pst=conn.prepareStatement(sql);
			int count=0;
			if(goodsTypeQue.getType_code()!=null&&!goodsTypeQue.getType_code().equals("")){
				count++;
				pst.setString(count, goodsTypeQue.getType_code());
			}
			if(goodsTypeQue.getType_name()!=null&&!goodsTypeQue.getType_name().equals("")){
				count++;
				pst.setString(count, "%"+goodsTypeQue.getType_name()+"%");
			}
			count++;
			pst.setInt(count, (pageTypeQue.getCurrentPage()-1)*pageTypeQue.getPageSize());
			count++;
			pst.setInt(count, pageTypeQue.getPageSize());
			rs=pst.executeQuery();
			while(rs.next()){
				Integer type_id=rs.getInt("type_id");
				String type_code=rs.getString("type_code");
				String type_name=rs.getString("type_name");
				GoodsType goodsType=new GoodsType(type_id, type_code, type_name);
				listTypes.add(goodsType);
			}
			return listTypes;
		}finally{
			ConnMana.closeSRC(pst, rs, conn);
		}
	}
	public List<GoodsType> getAllTypes() throws SQLException{
		List<GoodsType> listTypes=new ArrayList<>();
		Connection conn=ConnMana.getConnection();
		PreparedStatement pst=null;
		ResultSet rs=null;
		String sql="select * from goodstype";
		try{
			pst=conn.prepareStatement(sql);
		    rs=pst.executeQuery();
		    while(rs.next()){
		      Integer type_id=rs.getInt("type_id");
			  String type_code=rs.getString("type_code");
			  String type_name=rs.getString("type_name");
			  GoodsType goodsType=new GoodsType(type_id,type_code,type_name);
			   listTypes.add(goodsType);
		    }
		    return listTypes;
		}finally{
			ConnMana.closeSRC(pst, rs, conn);
		}
	}

	public void addType(GoodsType goodsType) throws SQLException {
		Connection conn=ConnMana.getConnection();
		PreparedStatement pst=null;
		String sql="insert into goodstype(type_code,type_name)value(?,?)";
		try{
			pst=conn.prepareStatement(sql);
			pst.setString(1, goodsType.getType_code());
			pst.setString(2, goodsType.getType_name());
		    pst.executeUpdate();
		    
		}finally{
			ConnMana.closeSRC(pst, null, conn);
		}	
	}

	public void deleteTypeById(int type_id) throws SQLException {
		Connection conn=ConnMana.getConnection();
		PreparedStatement pst=null;
		String sql="delete from goodstype where type_id=?";
		try{
			pst=conn.prepareStatement(sql);
			pst.setInt(1, type_id);
		    pst.executeUpdate();
		    
		}finally{
			ConnMana.closeSRC(pst, null, conn);
		}			
	}

	public GoodsType getTypeById(int id) throws SQLException {
		Connection conn=ConnMana.getConnection();
		PreparedStatement pst=null;
		ResultSet rs=null;
		String sql="select * from goodstype where type_id=?";
		try{
			pst=conn.prepareStatement(sql);
			pst.setInt(1, id);
		    rs=pst.executeQuery();
		    GoodsType goodsType=null;
		    if(rs.next()){
		    	Integer type_id=rs.getInt("type_id");
		    	String type_code=rs.getString("type_code");
		    	String type_name=rs.getString("type_name");
		    	goodsType=new GoodsType(type_id,type_code,type_name);
		    }
		    return goodsType;
		}finally{
			ConnMana.closeSRC(pst, null, conn);
		}
	}

	public void updateType(GoodsType goodsType) throws SQLException {
        Connection conn=ConnMana.getConnection();
        PreparedStatement pst=null;
        String sql="update goodstype set type_code=?,type_name=? where type_id=?";
        try{
        	pst=conn.prepareStatement(sql);
        	pst.setString(1, goodsType.getType_code());
            pst.setString(2, goodsType.getType_name());
            pst.setInt(3, goodsType.getType_id());
            pst.executeUpdate();
        }finally{
        	ConnMana.closeSRC(pst, null, conn);
        }
        
	}
	public int getAllCount(GoodsType goodsType) throws SQLException {
		Connection conn=ConnMana.getConnection();
		PreparedStatement pst=null;
		ResultSet rs=null;
		String sql="select count(type_id) as 'amount' from goodstype where 1=1";
		if(goodsType.getType_code()!=null&&!goodsType.getType_code().equals("")){
			sql=sql+" and type_code=?";
		}
		if(goodsType.getType_name()!=null&&!goodsType.getType_name().equals("")){
			sql=sql+" and type_name like ?";
		}
		try{
			pst=conn.prepareStatement(sql);
			int count=0;
			if(goodsType.getType_code()!=null&&!goodsType.getType_code().equals("")){
				count++;
				pst.setString(count, goodsType.getType_code());
			}
			if(goodsType.getType_name()!=null&&!goodsType.getType_name().equals("")){
				count++;
				pst.setString(count++, "%"+goodsType.getType_name()+"%");
			}
			rs=pst.executeQuery();
			if(rs.next()){
				return rs.getInt("amount");
			}else {
				return 0;
			}
		}finally{
			ConnMana.closeSRC(pst, null, conn);
		}
	}
	public List<GoodsType> getAllTypes(GoodsType goodsTypeQue) throws SQLException {
		Connection conn=ConnMana.getConnection();
		PreparedStatement pst=null;
		ResultSet rs=null;
		List<GoodsType> listType=new ArrayList<>();
		String sql="select * from goodstype where 1=1";
		if(goodsTypeQue.getType_code()!=null&&!goodsTypeQue.getType_code().equals("")){
			sql=sql+" and type_code=?";
		}
		if(goodsTypeQue.getType_name()!=null&&!goodsTypeQue.getType_name().equals("")){
			sql=sql+" and type_name like ?";
		}
		try{
			pst=conn.prepareStatement(sql);
			int count=0;
			if(goodsTypeQue.getType_code()!=null&&!goodsTypeQue.getType_code().equals("")){
				count++;
				pst.setString(count, goodsTypeQue.getType_code());
			}
			if(goodsTypeQue.getType_name()!=null&&!goodsTypeQue.getType_name().equals("")){
				count++;
				pst.setString(count, "%"+goodsTypeQue.getType_name()+"%");
			}
			rs=pst.executeQuery();
			while(rs.next()){
				Integer type_id=rs.getInt("type_id");
				String type_code=rs.getString("type_code");
				String type_name=rs.getString("type_name");
				GoodsType goodsType = new GoodsType(type_id, type_code, type_name);
				listType.add(goodsType);
			}
			return listType;
		}finally{
			ConnMana.closeSRC(pst, rs, conn);
		}
	}
	public void delAllType(String typeIds) throws SQLException {
		Connection conn=ConnMana.getConnection();
		PreparedStatement pst=null;
		String sql="delete from goodstype where type_id in("+typeIds+")";
		try{
			pst=conn.prepareStatement(sql);
			pst.executeUpdate();
		}finally{
			ConnMana.closeSRC(pst, null, conn);
		}
	}

}
