package com.woniuxy.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.woniuxy.entities.TestDate;
import com.woniuxy.tools.ConnMana;

public class TestDateDao {
	public List<TestDate> getAllDate(){
		Connection conn = ConnMana.getConnection();
		PreparedStatement pst = null;
		ResultSet rs = null;
		List<TestDate> listDate = new ArrayList<>();
		String sql = "select * from testdate";
		try {
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();
			while(rs.next()) {
				Integer id = rs.getInt("t_id");
				String name = rs.getString("t_name");
				Date d1 = rs.getDate("t_date");
				Date d2 = rs.getTimestamp("t_date");
				TestDate td = new TestDate(id,name,d2);
				listDate.add(td);
			}
			return listDate;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}finally {
			ConnMana.closeSC(pst, conn);
			ConnMana.closeResultSet(rs);
		}
		
	}
	public void addTestDate(TestDate td) {
		Connection conn = ConnMana.getConnection();
		PreparedStatement pst = null;
		String sql = "insert into testdate(t_name,t_date)values(?,?)";
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, td.getT_name());
			//只设置年月日
			long lg = td.getT_date().getTime();
			java.sql.Date sd = new java.sql.Date(lg);
			//设置年月日时分秒
			long lg2 = td.getT_date().getTime();
			Timestamp ts = new Timestamp(lg2);
			//只设置时分秒，数据库类型须支持time的类型
			long lg3 = td.getT_date().getTime();
			Time t = new Time(lg3);
			pst.setTimestamp(2, ts);
			pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			ConnMana.closeSC(pst, conn);
		}
	}

}










