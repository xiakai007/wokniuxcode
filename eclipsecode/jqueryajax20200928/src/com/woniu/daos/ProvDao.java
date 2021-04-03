package com.woniu.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.woniu.entities.Prov;
import com.woniu.tools.ConnMana;

public class ProvDao {

	public List<Prov> getAllProv() throws SQLException {
		Connection conn=ConnMana.getConnection();
		PreparedStatement pst=null;
		ResultSet rs=null;
		List<Prov> listProv=new ArrayList<>();
		String sql="select * from prov";
		try{
			pst=conn.prepareStatement(sql);
			rs=pst.executeQuery();
			while(rs.next()){
				Integer prov_id=rs.getInt("prov_id");
				String prov_name=rs.getString("prov_name");
				Prov prov=new Prov(prov_id, prov_name);
				listProv.add(prov);
			}
			return listProv;
		}finally{
			ConnMana.closeSRC(pst, rs, conn);
		}
	}

}
