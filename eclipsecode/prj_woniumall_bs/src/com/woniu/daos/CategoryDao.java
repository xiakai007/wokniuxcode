package com.woniu.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.woniu.entities.Category;
import com.woniu.entities.PageBean;
import com.woniu.tools.ConnMana;

public class CategoryDao {
	public List<Category> getAllTypes(Category categoryQue,PageBean<Category> pageTypeQue) throws SQLException{
		List<Category> listTypes=new ArrayList<>();
		Connection conn=ConnMana.getConnection();
		PreparedStatement pst=null;
		ResultSet rs=null;
		String sql="select * from mall_category where 1=1";
		if(categoryQue.getName()!=null&&!categoryQue.getName().equals("")){
			sql=sql+" and name like ?";
		}
		if(categoryQue.getNavable()!=null&&!categoryQue.getNavable().equals("")){
			sql=sql+" and navable=?";
		}
		sql=sql+" limit ?,?";
		try{
			pst=conn.prepareStatement(sql);
			int count=0;
			if(categoryQue.getName()!=null&&!categoryQue.getName().equals("")){
				count++;
				pst.setString(count, "%"+categoryQue.getName()+"%");
			}
			if(categoryQue.getNavable()!=null&&!categoryQue.getNavable().equals("")){
				count++;
				pst.setString(count, categoryQue.getNavable());
			}
			count++;
			pst.setInt(count, (pageTypeQue.getCurrentPage()-1)*pageTypeQue.getPageSize());
			count++;
			pst.setInt(count, pageTypeQue.getPageSize());
			rs=pst.executeQuery();
			while(rs.next()){
				Integer id=rs.getInt("id");
				String name=rs.getString("name");
				String status=rs.getString("status");
				String navable=rs.getString("navable");
				Category category=new Category(id, name, status, navable);
				listTypes.add(category);
			}
			return listTypes;
		}finally{
			ConnMana.closeSRC(pst, rs, conn);
		}
	}
	public List<Category> getAllTypes() throws SQLException{
		List<Category> listTypes=new ArrayList<>();
		Connection conn=ConnMana.getConnection();
		PreparedStatement pst=null;
		ResultSet rs=null;
		String sql="select * from mall_category";
		try{
			pst=conn.prepareStatement(sql);
		    rs=pst.executeQuery();
		    while(rs.next()){
		      Integer id=rs.getInt("id");
			  String name=rs.getString("name");
			  String status=rs.getString("status");
			  String navable=rs.getString("navable");
			  Category category=new Category(id, name, status, navable);
			   listTypes.add(category);
		    }
		    return listTypes;
		}finally{
			ConnMana.closeSRC(pst, rs, conn);
		}
	}
	public int getAllCount(Category category) throws SQLException {
		Connection conn=ConnMana.getConnection();
		PreparedStatement pst=null;
		ResultSet rs=null;
		String sql="select count(id) as 'amount' from mall_category where 1=1";
		if(category.getName()!=null&&!category.getName().equals("")){
			sql=sql+" and name=?";
		}
		if(category.getNavable()!=null&&!category.getNavable().equals("")){
			sql=sql+" and navable=?";
		}
		try{
			pst=conn.prepareStatement(sql);
			int count=0;
			if(category.getName()!=null&&!category.getName().equals("")){
				count++;
				pst.setString(count, category.getName());
			}
			if(category.getNavable()!=null&&!category.getNavable().equals("")){
				count++;
				pst.setString(count++, category.getNavable());
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
	public void addCategory(Category category) throws SQLException {
		Connection conn=ConnMana.getConnection();
		PreparedStatement pst=null;
		String sql="insert into mall_category (name,status,navable)value(?,?,?)";
		try{
			pst=conn.prepareStatement(sql);
			pst.setString(1, category.getName());
			pst.setString(2, category.getStatus());
			pst.setString(3, category.getNavable());
		    pst.executeUpdate();
		    
		}finally{
			ConnMana.closeSRC(pst, null, conn);
		}	
	}
	public void deleteCategoryById(int id) throws SQLException {
		Connection conn=ConnMana.getConnection();
		PreparedStatement pst=null;
		String sql="delete from mall_category where id=?";
		try{
			pst=conn.prepareStatement(sql);
			pst.setInt(1, id);
		    pst.executeUpdate();
		    
		}finally{
			ConnMana.closeSRC(pst, null, conn);
		}			
	}
	public void delAllType(String typeIds) throws SQLException {
		Connection conn=ConnMana.getConnection();
		PreparedStatement pst=null;
		String sql="delete from mall_category where id in("+typeIds+")";
		try{
			pst=conn.prepareStatement(sql);
			pst.executeUpdate();
		}finally{
			ConnMana.closeSRC(pst, null, conn);
		}
	}
	public Category getTypeById(int cid) throws SQLException {
		Connection conn=ConnMana.getConnection();
		PreparedStatement pst=null;
		ResultSet rs=null;
		String sql="select * from mall_category where id=?";
		try{
			pst=conn.prepareStatement(sql);
			pst.setInt(1, cid);
		    rs=pst.executeQuery();
		    Category category=null;
		    if(rs.next()){
		    	Integer id=rs.getInt("id");
		    	String name=rs.getString("name");
		    	String status=rs.getString("status");
		    	String navable=rs.getString("navable");
		    	category=new Category(id, name, status, navable);
		    }
		    return category;
		}finally{
			ConnMana.closeSRC(pst, null, conn);
		}
	}
	public void updateType(Category category) throws SQLException {
        Connection conn=ConnMana.getConnection();
        PreparedStatement pst=null;
        String sql="update mall_category set name=?,status=?,navable=? where id=?";
        try{
        	pst=conn.prepareStatement(sql);
        	pst.setString(1, category.getName());
            pst.setString(2, category.getStatus());
            pst.setString(3, category.getNavable());
            pst.setInt(4, category.getId());
            pst.executeUpdate();
        }finally{
        	ConnMana.closeSRC(pst, null, conn);
        }
        
	}
}
