package com.config;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MySqlsessionFactory {
	private static SqlSessionFactory sqlSessionFactory;
	static {
		String resource = "Configuration.xml";
		InputStream inputStream=null;
		try {
			inputStream = Resources.getResourceAsStream(resource);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sqlSessionFactory =
		new SqlSessionFactoryBuilder().build(inputStream);
	}//end class
	
	public static SqlSession getSession() {
		return sqlSessionFactory.openSession();
	}
	
	
	
}//end class
