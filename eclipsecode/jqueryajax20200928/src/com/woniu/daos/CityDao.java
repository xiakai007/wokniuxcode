package com.woniu.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.woniu.entities.City;
import com.woniu.tools.ConnMana;

public class CityDao {

	public List<City> getAllCity(int id) throws SQLException {
		Connection conn=ConnMana.getConnection();
		PreparedStatement pst=null;
		ResultSet rs=null;
		List<City> listCity=new ArrayList<>();
		String sql="select * from city where prov_id=?";
		try{
			pst=conn.prepareStatement(sql);
			pst.setInt(1, id);
			rs=pst.executeQuery();
			while(rs.next()){
				Integer city_id=rs.getInt("city_id");
				String city_name=rs.getString("city_name");
				City city=new City(city_id,city_name);
				listCity.add(city);
			}
			return listCity;
		}finally{
			ConnMana.closeSRC(pst, rs, conn);
		}
	}
	

}
