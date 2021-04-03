package com.woniu.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.woniu.entities.GoodsType;
import com.woniu.tools.ConnMana;

public class GoodsTypeDao {
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

}
