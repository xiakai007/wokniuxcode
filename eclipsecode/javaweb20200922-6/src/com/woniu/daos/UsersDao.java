package com.woniu.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
    /**
     * 只获取员工（入库人）的id和姓名
     * @return
     * @throws SQLException
     */
	public List<Users> getAllUsers() throws SQLException {
		Connection conn=ConnMana.getConnection();
		PreparedStatement pst=null;
		ResultSet rs=null;
		Users user=null;
		List<Users> listUsers=new ArrayList<>();
		String sql="select * from user";
		try{
			pst=conn.prepareStatement(sql);
			rs=pst.executeQuery();
			while(rs.next()){
				Integer user_id=rs.getInt("user_id");
				String user_name=rs.getString("user_name");
				user=new Users(user_id,user_name);
				listUsers.add(user);
			}
			return listUsers;
		}finally{
			ConnMana.closeSRC(pst, rs, conn);
		}
	}
	public boolean isProper(String checkName) throws SQLException {
		Connection conn=ConnMana.getConnection();
		PreparedStatement pst=null;
		ResultSet rs=null;
		String sql="select * from user where user_name=?";
		try{
			pst=conn.prepareStatement(sql);
			pst.setString(1, checkName);
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
