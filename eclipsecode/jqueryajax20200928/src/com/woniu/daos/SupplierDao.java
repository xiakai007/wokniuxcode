package com.woniu.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.woniu.entities.PageBean;
import com.woniu.entities.Supplier;
import com.woniu.tools.ConnMana;

public class SupplierDao {
	public List<Supplier> getAllSuppliers() throws SQLException{
		List<Supplier> listSuppliers=new ArrayList<>();
		Connection conn=ConnMana.getConnection();
		PreparedStatement pst=null;
		ResultSet rs=null;
		String sql="select * from supplier";
		try{
			pst=conn.prepareStatement(sql);
		    rs=pst.executeQuery();
		    while(rs.next()){
		      Integer supp_id=rs.getInt("supp_id");
			  String supp_code=rs.getString("supp_code");
			  String supp_name=rs.getString("supp_name");
			  String supp_phone=rs.getString("supp_phone");
			  Supplier supplier=new Supplier(supp_id,supp_code,supp_name,supp_phone);
			  listSuppliers.add(supplier);
		    }
		    return listSuppliers;
		}finally{
			ConnMana.closeSRC(pst, rs, conn);
		}
	}

	public void addSupplier(Supplier supplier) throws SQLException {
		Connection conn=ConnMana.getConnection();
		PreparedStatement pst=null;
		String sql="insert into supplier(supp_code,supp_name,supp_phone)value(?,?,?)";
		try{
			pst=conn.prepareStatement(sql);
			pst.setString(1, supplier.getSupp_code());
			pst.setString(2, supplier.getSupp_name());
			pst.setString(3, supplier.getSupp_phone());
		    pst.executeUpdate();
		    
		}finally{
			ConnMana.closeSRC(pst, null, conn);
		} 		
	}

	public void deleteSupplierById(int supp_id) throws SQLException {
		Connection conn=ConnMana.getConnection();
		PreparedStatement pst=null;
		String sql="delete from supplier where supp_id=?";
		try{
			pst=conn.prepareStatement(sql);
			pst.setInt(1, supp_id);
		    pst.executeUpdate();
		    
		}finally{
			ConnMana.closeSRC(pst, null, conn);
		}	
	}

	public Supplier getSupplierById(int id) throws SQLException {
		Connection conn=ConnMana.getConnection();
		PreparedStatement pst=null;
		ResultSet rs=null;
		Supplier supplier=null;
		String sql="select* from supplier where supp_id=?";
		try{
			pst=conn.prepareStatement(sql);
			pst.setInt(1, id);
		    rs=pst.executeQuery();
		    if(rs.next()){
		    	Integer supp_id=rs.getInt("supp_id"); 
		    	String supp_code=rs.getString("supp_code");
		    	String supp_name=rs.getString("supp_name");
		    	String supp_phone=rs.getString("supp_phone");
		    	supplier=new Supplier(supp_id, supp_code, supp_name, supp_phone);
		    }
		    return supplier;
		}finally{
			ConnMana.closeSRC(pst, null, conn);
		}
	}

	public void updateSupplier(Supplier supplier) throws SQLException {
		Connection conn=ConnMana.getConnection();
		PreparedStatement pst=null;
		String sql="update supplier set supp_code=?,supp_name=?,supp_phone=? where supp_id=?";
		pst=conn.prepareStatement(sql);
		pst.setString(1, supplier.getSupp_code());
		pst.setString(2, supplier.getSupp_name());
		pst.setString(3, supplier.getSupp_phone());
		pst.setInt(4, supplier.getSupp_id());
		pst.executeUpdate();
	}

	public List<Supplier> getAllSuppliers(Supplier supp) throws SQLException {
		Connection conn=ConnMana.getConnection();
		PreparedStatement pst=null;
		ResultSet rs=null;
		List<Supplier> listSupps=new ArrayList<>();
		String sql="select * from supplier where 1=1";
		if(supp.getSupp_code()!=null&&!supp.getSupp_code().equals("")){
			sql=sql+" and supp_code=?";
		}
		if(supp.getSupp_name()!=null&&!supp.getSupp_name().equals("")){
			sql=sql+" and supp_name like ?";
		}
		try{
			pst=conn.prepareStatement(sql);
			int count=0;
			if(supp.getSupp_code()!=null&&!supp.getSupp_code().equals("")){
				count++;
				pst.setString(count, supp.getSupp_code());
			}
			if(supp.getSupp_name()!=null&&!supp.getSupp_name().equals("")){
				count++;
				pst.setString(count, "%"+supp.getSupp_name()+"%");
			}
			rs=pst.executeQuery();
			while(rs.next()){
				Integer supp_id=rs.getInt("supp_id");
				String supp_code=rs.getString("supp_code");
				String supp_name=rs.getString("supp_name");
				String supp_phone=rs.getString("supp_phone");
				Supplier supplier=new Supplier(supp_id,supp_code,supp_name,supp_phone);
				listSupps.add(supplier);
			}
			return listSupps;
		}finally{
			ConnMana.closeSRC(pst, rs, conn);
		}
	}

	public int getAllCount(Supplier supp) throws SQLException {
		Connection conn=ConnMana.getConnection();
		PreparedStatement pst=null;
		ResultSet rs=null;
		String sql="select count(supp_id) as 'cd' from supplier where 1=1";
		if(supp.getSupp_code()!=null&&!supp.getSupp_code().equals("")){
			sql=sql+" and supp_code=?";
		}
		if(supp.getSupp_name()!=null&&!supp.getSupp_name().equals("")){
			sql=sql+" and supp_name like ?";
		}
		try{
			pst=conn.prepareStatement(sql);
			int count=0;
			if(supp.getSupp_code()!=null&&!supp.getSupp_code().equals("")){
				count++;
				pst.setString(count, supp.getSupp_code());
			}
			if(supp.getSupp_name()!=null&&!supp.getSupp_name().equals("")){
				count++;
				pst.setString(count, "%"+supp.getSupp_name()+"%");
			}
			rs=pst.executeQuery();
			if(rs.next()){
				return rs.getInt("cd");
			}
			return 0;
		}finally{
			ConnMana.closeSRC(pst, rs, conn);
		}
	}

	public List<Supplier> getAllSuppliers(Supplier supp, PageBean<Supplier> pageBean) throws SQLException {
		Connection conn=ConnMana.getConnection();
		PreparedStatement pst=null;
		ResultSet rs=null;
		List<Supplier> listSupps=new ArrayList<>();
		String sql="select * from supplier where 1=1";
		if(supp.getSupp_code()!=null&&!supp.getSupp_code().equals("")){
			sql=sql+" and supp_code=?";
		}
		if(supp.getSupp_name()!=null&&!supp.getSupp_name().equals("")){
			sql=sql+" and supp_name like ?";
		}
		sql=sql+" limit ?,?";
		try{
			pst=conn.prepareStatement(sql);
			int count=0;
			if(supp.getSupp_code()!=null&&!supp.getSupp_code().equals("")){
				count++;
				pst.setString(count, supp.getSupp_code());
			}
			if(supp.getSupp_name()!=null&&!supp.getSupp_name().equals("")){
				count++;
				pst.setString(count, "%"+supp.getSupp_name()+"%");
			}
			count++;
			pst.setInt(count, (pageBean.getCurrentPage()-1)*pageBean.getPageSize());
			count++;
			pst.setInt(count, pageBean.getPageSize());
			rs=pst.executeQuery();
			while(rs.next()){
				Integer supp_id=rs.getInt("supp_id");
				String supp_code=rs.getString("supp_code");
				String supp_name=rs.getString("supp_name");
				String supp_phone=rs.getString("supp_phone");
				Supplier supplier=new Supplier(supp_id,supp_code,supp_name,supp_phone);
				listSupps.add(supplier);
			}
			return listSupps;
		}finally{
			ConnMana.closeSRC(pst, rs, conn);
		}
	}

	public void delAllSupp(String suppIds) throws SQLException {
		Connection conn=ConnMana.getConnection();
		PreparedStatement pst=null;
		String sql="delete from supplier where supp_id in("+suppIds+")";
		try{
			pst=conn.prepareStatement(sql);
		    pst.executeUpdate();
		    
		}finally{
			ConnMana.closeSRC(pst, null, conn);
		}
		
	}

}





