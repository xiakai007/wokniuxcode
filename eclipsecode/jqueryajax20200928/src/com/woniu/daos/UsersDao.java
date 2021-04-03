package com.woniu.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.woniu.entities.PageBean;
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
	public boolean isProper(Users user) throws SQLException {
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
	public boolean checkUserName(String userName) throws SQLException {
		Connection conn=ConnMana.getConnection();
		PreparedStatement pst=null;
		ResultSet rs=null;
		String sql="select * from user where user_name=? and user_status='启用'";
		try{
			pst=conn.prepareStatement(sql);
			pst.setString(1, userName);
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
	public void addUser(Users user) throws SQLException {
		Connection conn=ConnMana.getConnection();
		PreparedStatement pst=null;
		String sql="insert into user(user_name,user_pwd)value(?,?)";
		try{
			pst=conn.prepareStatement(sql);
			pst.setString(1, user.getUser_name());
			pst.setString(2, user.getUser_pwd());
			pst.executeUpdate();
		}finally{
			ConnMana.closeSRC(pst, null, conn);
		}
		
	}
	public int getAllCount(Users userQue) throws SQLException {
		Connection conn=ConnMana.getConnection();
		PreparedStatement pst=null;
		ResultSet rs=null;
		String sql="select count(user_id) as 'ids' from user where 1=1";
		if(userQue.getUser_name()!=null&&!userQue.getUser_name().equals("")){
			sql=sql+" and user_name like ?";
		}
		try{
			pst=conn.prepareStatement(sql);
			int count=0;
			if(userQue.getUser_name()!=null&&!userQue.getUser_name().equals("")){
				count++;
				pst.setString(count, "%"+userQue.getUser_name()+"%");
			}
			rs=pst.executeQuery();
			if(rs.next()){
				return rs.getInt("ids");
			}
		}finally{
			ConnMana.closeSRC(pst, rs, conn);
		}
		return 0;
	}
	public List<Users> getAllUsers(Users userQue, PageBean<Users> pageBean) throws SQLException {
		Connection conn=ConnMana.getConnection();
		PreparedStatement pst=null;
		ResultSet rs=null;
		List<Users> listUser=new ArrayList<>();
		String sql="select * from user where 1=1";
		if(userQue.getUser_name()!=null&&!userQue.getUser_name().equals("")){
			sql=sql+" and user_name like ?";
		}
		sql=sql+" limit ?,?";
		try{
			pst=conn.prepareStatement(sql);
			int count=0;
			if(userQue.getUser_name()!=null&&!userQue.getUser_name().equals("")){
				count++;
				pst.setString(count, "%"+userQue.getUser_name()+"%");
			}
			count++;
			pst.setInt(count, pageBean.getPageSize()*(pageBean.getCurrentPage()-1));
			count++;
			pst.setInt(count, pageBean.getPageSize());
			rs=pst.executeQuery();
			while(rs.next()){
				Integer user_id=rs.getInt("user_id");
				String user_name=rs.getString("user_name");
				String user_pwd=rs.getString("user_pwd");
				String user_role=rs.getString("user_role");
				String user_status=rs.getString("user_status");
				Users user = new Users(user_id, user_name, user_pwd, user_role, user_status);
				listUser.add(user);
			}
			return listUser;
		}finally{
			ConnMana.closeSRC(pst, rs, conn);
		}
	}
	public void resetPwdById(int user_id) throws SQLException {
		Connection conn=ConnMana.getConnection();
		PreparedStatement pst=null;
		String sql="update user set user_pwd='123456' where user_id="+user_id;
		try{
			pst=conn.prepareStatement(sql);
			pst.executeUpdate();
		}finally{
			ConnMana.closeSRC(pst, null, conn);
		}
	}
	public boolean isCorrect(Users user) throws SQLException {
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
	public void updateStatus(int user_id, String user_status) throws SQLException {
		Connection conn=ConnMana.getConnection();
		PreparedStatement pst=null;
		String sql="update user set user_status=? where user_id=?";
		try{
			pst=conn.prepareStatement(sql);
			pst.setString(1, user_status);
			pst.setInt(2, user_id);
			pst.executeUpdate();
		}finally{
			ConnMana.closeSRC(pst, null, conn);
		}
		
	}
	public void updateUserPwd(Integer user_id, String newPwd) throws SQLException {
		Connection conn=ConnMana.getConnection();
		PreparedStatement pst=null;
		String sql="update user set user_pwd=? where user_id=?";
		try{
			pst=conn.prepareStatement(sql);
			pst.setString(1, newPwd);
			pst.setInt(2, user_id);
			pst.executeUpdate();
		}finally{
			ConnMana.closeSRC(pst, null, conn);
		}
		
	}

}
