package com.woniu.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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

}
