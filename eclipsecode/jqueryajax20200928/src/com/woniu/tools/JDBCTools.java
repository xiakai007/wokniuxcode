package com.woniu.tools;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.woniu.annotations.Column;

public class JDBCTools {
	private final static String DRIVER_URL="com.mysql.cj.jdbc.Driver";
	private final static String CONNECTION_URL="jdbc:mysql://localhost:3306/woniumall?characterEncoding=utf8&useSSL=false&serverTimezone=Asia/Shanghai";
    private final static String USER_NAME="root";
    private final static String USER_PWD="123456";
    
    public static Connection getConnection(){
    	try {
			Class.forName(DRIVER_URL);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
    	try {
			Connection conn=DriverManager.getConnection(CONNECTION_URL, USER_NAME, USER_PWD);
			return conn;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
    }
    public static void closeSRC(Statement sta,ResultSet rs,Connection conn){
    	try {
			if(sta!=null&&!sta.isClosed()){
				sta.close();
			}
			if(rs!=null&&!rs.isClosed()){
				rs.close();
			}
			if(conn!=null&&!conn.isClosed()){
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }
    /*将结果集中的数据自动封装为一个集合，结果集的列名和属性名称一致*/
    public static List getList(ResultSet rs,Class clazz) throws SQLException, InstantiationException, IllegalAccessException, NoSuchFieldException, SecurityException{
    	List list=new ArrayList();
    	ResultSetMetaData rsmd=rs.getMetaData();
    	while(rs.next()){
    		Object obj=clazz.newInstance();
    		for(int i=1;i<=rsmd.getColumnCount();i++){
    			String columnName=rsmd.getColumnName(i);
    			Object columnValue=rs.getObject(columnName);
    			String fieldName=columnName;
    			Field field=clazz.getDeclaredField(fieldName);
    			field.setAccessible(true);
    			field.set(obj, columnValue);
    		}
    		list.add(obj);
    	}
    	return list;
    }
    /*将结果集中的数据自动封装为一个集合，结果集的列名和属性名称不一致*/
    public static List getMyList(ResultSet rs,Class clazz) throws SQLException, InstantiationException, IllegalAccessException{
    	List list=new ArrayList();
    	ResultSetMetaData rsmd=rs.getMetaData();
    	while(rs.next()){
    		Object obj=clazz.newInstance();
    		for(int i=1;i<=rsmd.getColumnCount();i++){
    			String columnName= rsmd.getColumnName(i);
    			Object columnValue=rs.getObject(columnName);
    			//得到实体类MySupplier的属性
    			Field[] fields=clazz.getDeclaredFields();
    			for(Field field:fields){
    				if(field.isAnnotationPresent(Column.class)){
    					Column column=field.getAnnotation(Column.class);
    					String annoColumnName=column.value();
    					if(annoColumnName.equals(columnName)){
    						field.setAccessible(true);
    						field.set(obj, columnValue);
    					}
    				}
    			}
    		}
    		list.add(obj);
    	}
    	return list;
    }

}
