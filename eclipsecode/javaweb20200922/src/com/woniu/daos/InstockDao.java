package com.woniu.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.woniu.entities.Instock;
import com.woniu.tools.ConnMana;

public class InstockDao {

	public List<Instock> getAllIntock() throws SQLException {
		Connection conn=ConnMana.getConnection();
		PreparedStatement pst=null;
		ResultSet rs=null;
		List<Instock> listInstock=new ArrayList<>();
		String sql="select * from instock";
		try{
			pst=conn.prepareStatement(sql);
			rs=pst.executeQuery();
			while(rs.next()){
				Integer instock_id=rs.getInt("instock_id");
				Integer user_id=rs.getInt("user_id");
				Integer goods_id=rs.getInt("goods_id");
				String instock_code=rs.getString("instock_code");
				Date instock_time=rs.getDate("instock_time");
				String instock_status=rs.getString("instock_status");
				String instock_rms=rs.getString("instock_rms");
				Integer instock_count=rs.getInt("instock_count");
				Instock instock=new Instock(instock_id, user_id, goods_id, instock_code, instock_time, instock_status, instock_rms, instock_count);
				listInstock.add(instock);
			}
			return listInstock;
		}finally{
			ConnMana.closeSRC(pst, rs, conn);
		}
	}

	public void addIntock(Instock instock) throws SQLException {
		Connection conn=ConnMana.getConnection();
		PreparedStatement pst=null;
		String sql="insert into instock (user_id,goods_id,instock_code,instock_time,instock_status,instock_rms,instock_count) value(?,?,?,?,?,?,?)";
		try{
			pst=conn.prepareStatement(sql);
			pst.setInt(1, instock.getUser_id());
			pst.setInt(2, instock.getGoods_id());
			pst.setString(3, instock.getInstock_code());
			long instime=instock.getInstock_time().getTime();
			java.sql.Date instimesql=new java.sql.Date(instime);
			pst.setDate(4, instimesql);
			pst.setString(5, instock.getInstock_status());
			pst.setString(6, instock.getInstock_rms());
			pst.setInt(7, instock.getInstock_count());
			pst.executeUpdate();
		}finally{
			ConnMana.closeSRC(pst, null, conn);
		}
		
		
	}

	public void deleteInstockById(Integer id) throws SQLException {
		Connection conn=ConnMana.getConnection();
		PreparedStatement pst=null;
		String sql="delete from instock where instock_id=?";
		try{
			pst=conn.prepareStatement(sql);
			pst.setInt(1, id);
			pst.executeUpdate();
		}finally{
			ConnMana.closeSRC(pst, null, conn);
		}
		
	}

	public Instock getInstockById(int id) throws SQLException {
		Connection conn=ConnMana.getConnection();
		PreparedStatement pst=null;
		ResultSet rs=null;
		Instock instock=null;
		String sql="select * from instock where instock_id=?";
		try{
			pst=conn.prepareStatement(sql);
			pst.setInt(1, id);
			rs=pst.executeQuery();
			if(rs.next()){
				Integer instock_id=rs.getInt("instock_id");
				Integer user_id=rs.getInt("user_id");
				Integer goods_id=rs.getInt("goods_id");
				String instock_code=rs.getString("instock_code");
				Date instock_time=rs.getDate("instock_time");
				String instock_status=rs.getString("instock_status");
				String instock_rms=rs.getString("instock_rms");
				Integer instock_count=rs.getInt("instock_count");
				instock=new Instock(instock_id,user_id, goods_id, instock_code, instock_time, instock_status, instock_rms, instock_count);
			}
			return instock;
		}finally{
			ConnMana.closeSRC(pst, rs, conn);
		}
	}

	public void updSaveInstock(Instock instock) throws SQLException {
		Connection conn=ConnMana.getConnection();
		PreparedStatement pst=null;
		String sql="update instock set user_id=?,goods_id=?,instock_code=?,instock_time=?,instock_status=?,instock_rms=?,instock_count=? where instock_id=?";
		try{
			pst=conn.prepareStatement(sql);
			pst.setInt(1, instock.getUser_id());
			pst.setInt(2, instock.getGoods_id());
			pst.setString(3, instock.getInstock_code());
			long insTime=instock.getInstock_time().getTime();
			java.sql.Date insTimesql=new java.sql.Date(insTime);
			pst.setDate(4, insTimesql);
			pst.setString(5, instock.getInstock_status());
			pst.setString(6, instock.getInstock_rms());
			pst.setInt(7, instock.getInstock_count());
			pst.setInt(8, instock.getInstock_id());
			pst.executeUpdate();
		}finally{
			ConnMana.closeSRC(pst, null, conn);
		}
	}

}
