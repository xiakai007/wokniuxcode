package com.woniu.utils;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyUtil {
	private static SqlSessionFactory sqlSessionFactory;
	static{
		InputStream in=null;
		try {
			in=Resources.getResourceAsStream("mybatis-config.xml");
		} catch (IOException e) {
			e.printStackTrace();
		}
		sqlSessionFactory=new SqlSessionFactoryBuilder().build(in);
	}
	public static SqlSession getSqlSession(){
		SqlSession sqlSession=sqlSessionFactory.openSession();
		return sqlSession;
	}
	public static void closeSqlSession(SqlSession sqlSession){
		if(sqlSession!=null){
			sqlSession.close();
		}
	}

}
