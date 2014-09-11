package com.jiang.gent.service;

import java.io.IOException;

import org.apache.ibatis.session.SqlSession;

import com.jiang.gent.bean.User;
import com.jiang.gent.dao.UserDao;
import com.jiang.gent.dao.utils.MybatisUtils;

public class UserServiceImpl {
	
	public boolean addUser(User user){
		boolean flag = false;
		SqlSession session = null;
		
		try {
			session = MybatisUtils.getSession();
			UserDao ud = session.getMapper(UserDao.class);
			int count = ud.insertUser(user);
			session.commit();
			if(count == 1){
				flag = true;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			session.close();
		}
		
		return flag;
	}
	
}
