package com.jiang.gent.test;

import java.io.IOException;
import java.io.Reader;
import java.util.Date;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

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
	
	public static void main(String[] args){
		User user = new User();
		user.setEmail("shanelman@gmail.com");
		user.setPassword("123456");
		user.setCreateTime(new Date());
		SqlSession session = null;
		try {
			session = MybatisUtils.getSession();
			//UserDao userDao = session.getMapper(UserDao.class);
			//userDao.insertUser(user);
			int count = session.insert("com.jiang.gent.dao.UserDao.insertUser", user); // 返回更新条数
			System.out.println(user.getId());
			//User result = MybatisUtils.getSession().selectOne("com.jiang.gent.dao.UserDao.getUser",1);
			//System.out.println(result.getEmail());
			session.commit();// session commit is required while insert operation.
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			session.close();
		}
	}

}
