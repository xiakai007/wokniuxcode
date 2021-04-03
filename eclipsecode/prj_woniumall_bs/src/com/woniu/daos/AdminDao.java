package com.woniu.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.woniu.entities.Admin;
import com.woniu.entities.PageBean;
import com.woniu.tools.ConnMana;

public class AdminDao {

	public Admin isExit(Admin admin) throws SQLException {
		Connection conn=ConnMana.getConnection();
		PreparedStatement pst=null;
		ResultSet rs=null;
		String sql="select * from mall_admin where account=? and password=?";
		try{
			pst=conn.prepareStatement(sql);	
			pst.setString(1, admin.getAccount());
			pst.setString(2, admin.getPassword());
			rs=pst.executeQuery();
			if(rs.next()){
				Integer id=rs.getInt("id");
				String account=rs.getString("account");
				String password=rs.getString("password");
				String role=rs.getString("role");
				Timestamp lastlogintime=rs.getTimestamp("lastlogintime");
				String lastloginip=rs.getString("lastloginip");
				String status=rs.getString("status");
				Admin loginAdmin=new Admin(id, account, password, role, lastlogintime, lastloginip, status);
				return loginAdmin;
			}else{
				return null;
			}
		}finally{
			ConnMana.closeSRC(pst, rs, conn);
		}
	}
	public boolean checkAccount(String account) throws SQLException {
		Connection conn=ConnMana.getConnection();
		PreparedStatement pst=null;
		ResultSet rs=null;
		String sql="select * from mall_admin where account=? and status='1'";
		try{
			pst=conn.prepareStatement(sql);
			pst.setString(1, account);
			rs=pst.executeQuery();
			if(rs.next()){
				return true;
			}else{
				return false;
			}
		}finally{
			ConnMana.closeSRC(pst, rs, conn);
		}
	}

}
