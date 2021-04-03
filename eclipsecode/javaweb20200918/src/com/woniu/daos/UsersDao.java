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

	public boolean isExit(Users user) {
		Connection conn=ConnMana.getConnection();
		PreparedStatement pst=null;
		ResultSet rs=null;
		String sql="select * from users where user_name=? and user_pwd=?";
		try {
			pst=conn.prepareStatement(sql);
			pst.setString(1, user.getUser_name());
			pst.setString(2, user.getUser_pwd());
			rs=pst.executeQuery();
			if(rs.next()){
				return true;
			}else{
				return false;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}finally{
			ConnMana.closeSRC(pst, rs, conn);
		}
	}
	public void addUser(Users user){
		Connection conn=ConnMana.getConnection();
		PreparedStatement pst=null;
		String sql="insert into users (user_name,user_pwd) value(?,?);";
		try {
			pst=conn.prepareStatement(sql);
			pst.setString(1, user.getUser_name());
			pst.setString(2, user.getUser_pwd());
			pst.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			ConnMana.closeSRC(pst, null, conn);
		}
	}
	public List<Users> getUsersName(){
		Connection conn=ConnMana.getConnection();
		ResultSet rs=null;
		String sql="select * from users";
		PreparedStatement pst=null;
		Users user=null;
		List<Users> listUserNames=new ArrayList<>();
		try {
			pst=conn.prepareStatement(sql);
			rs=pst.executeQuery();
			while(rs.next()){
				String userName=rs.getString("user_name");
				user=new Users(userName);
				listUserNames.add(user);
			}
			return listUserNames;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	public boolean checkUserName(Users user) {
		Connection conn=ConnMana.getConnection();
		PreparedStatement pst=null;
		ResultSet rs=null;
		String sql="select * from users where user_name=?";
		try {
			pst=conn.prepareStatement(sql);
			pst.setString(1, user.getUser_name());
			rs=pst.executeQuery();
			if(rs.next()){
				return false;
			}else{
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return true;
		}
	}

}
