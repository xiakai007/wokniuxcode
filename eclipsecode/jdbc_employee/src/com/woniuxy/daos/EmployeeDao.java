package com.woniuxy.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.woniuxy.entities.Employee;
import com.woniuxy.tools.ConnManager;

public class EmployeeDao {
	
	public void addEmployee(Employee empl) {
		Connection conn = ConnManager.getConnection();
		PreparedStatement pst = null;
		String sql = "insert into employee(emp_name,emp_age,emp_status,emp_type)values(?,?,?,?)";
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, empl.getEmp_name());
			pst.setInt(2, empl.getEmp_age());
			pst.setString(3, empl.getEmp_status());
			pst.setInt(4, empl.getEmp_type());
			pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			ConnManager.closeSC(pst, conn);
		}
	}
	public void updateEmployee(Employee empl) {
		Connection conn = ConnManager.getConnection();
		PreparedStatement pst = null;
		String sql = "update employee set emp_name=?,emp_age=?,emp_status=?,emp_type=? where emp_id=?";
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, empl.getEmp_name());
			pst.setInt(2, empl.getEmp_age());
			pst.setString(3, empl.getEmp_status());
			pst.setInt(4, empl.getEmp_type());
			pst.setInt(5, empl.getEmp_id());
			pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			ConnManager.closeSC(pst, conn);
		}
	}
	public void deleteEmplById(Integer id) {
		Connection conn = ConnManager.getConnection();
		PreparedStatement pst = null;
		String sql = "delete from employee where emp_id=?";
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, id);
			pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			ConnManager.closeSC(pst, conn);
		}
	}
	public List<Employee> getAllEmployees(){
		List<Employee> listEmpls = new ArrayList<>();
		Connection conn = ConnManager.getConnection();
		PreparedStatement pst = null;
		ResultSet rs = null;
		String sql = "select * from employee";
        try {
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();
			while(rs.next()) {
				Integer emp_id = rs.getInt("emp_id");
				String emp_name = rs.getString("emp_name");
				Integer emp_age = rs.getInt("emp_age");
				String emp_status = rs.getString("emp_status");
				Integer emp_type = rs.getInt("emp_type");
				Employee empl = new Employee(emp_id,emp_name,emp_age,emp_status,emp_type);
				listEmpls.add(empl);
			}
			return listEmpls;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}finally {
			ConnManager.closeSC(pst, conn);
			ConnManager.closeResultSet(rs);
		}		
	}
	public Employee getEmplById(Integer id) {
		Employee empl = null;
		Connection conn = ConnManager.getConnection();
		PreparedStatement pst = null;
		ResultSet rs = null;
		String sql = "select * from employee where emp_id=?";
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, id);
			rs = pst.executeQuery();
			if(rs.next()) {
				Integer emp_id = rs.getInt("emp_id");
				String emp_name = rs.getString("emp_name");
				Integer emp_age = rs.getInt("emp_age");
				String emp_status = rs.getString("emp_status");
				Integer emp_type = rs.getInt("emp_type");
				empl = new Employee(emp_id,emp_name,emp_age,emp_status,emp_type);
			}
			return empl;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}finally {
			ConnManager.closeSC(pst, conn);
			ConnManager.closeResultSet(rs);
		}
		
	}

}

























