package com.woniu.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.woniu.entities.Users;
import com.woniu.tools.ConnMana;

public class UsersDao {

	public boolean isExit(Users user) throws SQLException {
		Connection conn=ConnMana.getConnection();
		PreparedStatement pst=null;
		ResultSet rs=null;
		String sql="select * from user where user_name=? and user_pwd=?";
		try{
			pst=conn.prepareStatement(sql);	
			pst.setString(1, user.getUser_name());
			pst.setString(2, user.getUser_pwd());
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
