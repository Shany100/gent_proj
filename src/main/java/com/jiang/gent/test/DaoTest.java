package com.jiang.gent.test;

import java.io.IOException;
import java.io.Reader;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.google.gson.Gson;
import com.jiang.gent.bean.Event;
import com.jiang.gent.bean.User;
import com.jiang.gent.dao.UserDao;
import com.jiang.gent.dao.utils.MybatisUtils;

public class DaoTest {

	  public void buildUseXml() throws IOException {  
	    String resource = "conf/mybatis-config.xml";  
	    Reader reader = Resources.getResourceAsReader(resource);  
	    SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);  
	    SqlSession session = sqlSessionFactory.openSession();  
	    try {  
	      Event event = session.selectOne("com.jiang.gent.dao.EventDao.getEventById",1);  
	      System.out.println(event.getName()); // - read books

	    } finally {  
	      session.close();  
	    }  
	  }  
	
	public static void main(String[] args) throws IOException{
		/*
		User user = new User();
		user.setEmail("shanelman@gmail.com");
		user.setPassword("123456");
		user.setCreateTime(new Date());
		SqlSession session = null;
		try {
			session = MybatisUtils.getSession();
			//UserDao userDao = session.getMapper(UserDao.class);
			//userDao.insertUser(user);
			//int count = session.insert("com.jiang.gent.dao.UserDao.insertUser", user); // 返回更新条数
			//System.out.println(user.getId());
			User result = MybatisUtils.getSession().selectOne("com.jiang.gent.dao.UserDao.getUser",10);
			System.out.println("邮箱: "+result.getEmail());
			//session.commit();// session commit is required while insert operation.
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			session.close();
		} */
		/*User user = new User();
		user.setEmail("shanelman@gmail.com");
		user.setPassword("123456");
		ArrayList<User> list = null;
		SqlSession session = null;
		session = MybatisUtils.getSession();
		list = (ArrayList) session.selectList("com.jiang.gent.dao.UserDao.checkUser", user);
		System.out.println(list.get(0).getId());*/
		System.out.println(new Timestamp(new Date().getTime()));
		
		ArrayList<User> list = null;
		SqlSession session = null;
		Map paramMap = new HashMap();
		paramMap.put("eventId", 11);
		paramMap.put("today", new Timestamp(new Date().getTime()));
		
		session = MybatisUtils.getSession();
		List event = session.selectList("com.jiang.gent.dao.RecordDao.getRecordByEventId", paramMap );
		System.out.println(event.size());
		System.out.println(new Gson().toJson(event));
	}

}
