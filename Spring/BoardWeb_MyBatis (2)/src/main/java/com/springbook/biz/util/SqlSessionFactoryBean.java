package com.springbook.biz.util;

import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SqlSessionFactoryBean {
	//MyBatis를 사용하기 위해서는 SqlSessionFactoryBean 이 생성되어 있어야 한다. 
	
	private static SqlSessionFactory sessionFactory = null ; 
	
	static {
		try {
			if (sessionFactory== null) {
				Reader reader = Resources.getResourceAsReader("sql-map-config.xml");
				sessionFactory = new SqlSessionFactoryBuilder().build(reader);
			}		
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
		public static SqlSession getSqlSessionInstance() {
			return sessionFactory.openSession(); 
		}
	}	
	

