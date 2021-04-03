package com.woniuxy.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.woniuxy.entities.EmpType;
import com.woniuxy.tools.ConnManager;

public class EmpTypeDao {
	
	public void addEmpType(EmpType empty) {
		Connection conn = null;
		PreparedStatement pst = null;
		conn = ConnManager.getConnection();
		String sql= "insert into emptype(type_code,type_name) values(?,?)";
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, empty.getType_code());
			pst.setString(2, empty.getType_name());
			pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			ConnManager.closeSC(pst, conn);
		}
	}
	public void updateEmpType(EmpType empty) {
		Connection conn = null;
		PreparedStatement pst = null;
		conn = ConnManager.getConnection();
		String sql= "update empType set type_code=?,type_name=? where type_id=?";
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, empty.getType_code());
			pst.setString(2, empty.getType_name());
			pst.setInt(3, empty.getType_id());
			pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			ConnManager.closeSC(pst, conn);
		}
	}
	public void deleteEmpTypeById(Integer type_id) {
		Connection conn = null;
		PreparedStatement pst = null;
		conn = ConnManager.getConnection();
		String sql= "delete from Emptype where type_id=?";
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, type_id);
			pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			ConnManager.closeSC(pst, conn);
		}
	}
	public List<EmpType> getAllEmpType(){
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		conn = ConnManager.getConnection();
		List<EmpType> listEmpts = new ArrayList<>();
		String sql= "select * from EmpType";
		try {
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();
			while(rs.next()) {
				Integer type_id = rs.getInt("type_id");
				String type_code = rs.getString("type_code");
				String type_name = rs.getString("type_name");
				EmpType empt = new EmpType(type_id,type_code,type_name);
				listEmpts.add(empt);
			}
			return listEmpts;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}finally {
			ConnManager.closeSC(pst, conn);
			ConnManager.closeResultSet(rs);
		}
	}
	public EmpType getEmpTypeById(Integer id){
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		conn = ConnManager.getConnection();
		EmpType empt = null;
		String sql= "select * from EmpType where type_id=?";
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, id);
			rs = pst.executeQuery();
			if(rs.next()) {
				Integer type_id = rs.getInt("type_id");
				String type_code = rs.getString("type_code");
				String type_name = rs.getString("type_name");
				empt = new EmpType(type_id,type_code,type_name);
			}
			return empt;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}finally {
			ConnManager.closeSC(pst, conn);
			ConnManager.closeResultSet(rs);
		}
	}

}


















