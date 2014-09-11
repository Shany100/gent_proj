package com.jiang.gent.dao.utils;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MybatisUtils {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static SqlSession getSession() throws IOException{
		SqlSession session = null;
		String resource = "conf/mybatis-config.xml";  
	    Reader reader = Resources.getResourceAsReader(resource);  
	    SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);  
	    session = sqlSessionFactory.openSession();  
		
	    return session;
	}

}
