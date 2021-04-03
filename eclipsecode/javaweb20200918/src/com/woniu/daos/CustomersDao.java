package com.woniu.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.woniu.entities.Customers;
import com.woniu.tools.ConnMana;

public class CustomersDao {
	public List<Customers> getAllCustomers(){
		List<Customers> listCusts=new ArrayList<>();
		Connection conn=ConnMana.getConnection();
		PreparedStatement pst=null;
		ResultSet rs=null;
		String sql="select * from customers";
		try {
			pst=conn.prepareStatement(sql);
			rs=pst.executeQuery();
			while(rs.next()){
				Integer cust_id=rs.getInt("cust_id");
				String cust_name=rs.getString("cust_name");
				Customers custs=new Customers(cust_id,cust_name);
				listCusts.add(custs);
			}
			return listCusts;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}finally{
			ConnMana.closeSRC(pst, rs, conn);
		}
		
	}

}
