package com.woniu.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.woniu.entities.Users;
import com.woniu.tools.ConnMana;

public class UsersDao {

	public Users isExit(Users user) throws SQLException {
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
				Integer user_id=rs.getInt("user_id");
				String user_name=rs.getString("user_name");
				String user_pwd=rs.getString("user_pwd");
				String user_role=rs.getString("user_role");
				String user_status=rs.getString("user_status");
				Users loginUser=new Users(user_id, user_name, user_pwd, user_role, user_status);
				return loginUser;
			}else{
				return null;
			}
		}finally{
			ConnMana.closeSRC(pst, rs, conn);
		}
	}

}
