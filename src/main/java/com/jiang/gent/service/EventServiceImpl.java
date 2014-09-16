package com.jiang.gent.service;

import java.io.IOException;

import org.apache.ibatis.session.SqlSession;

import com.jiang.gent.bean.Event;
import com.jiang.gent.dao.EventDao;
import com.jiang.gent.dao.utils.MybatisUtils;

public class EventServiceImpl {
	/**
	 * 添加事件
	 * @param event
	 */
	public boolean addEvent(Event event){
		boolean flag = false;
		SqlSession session = null;
		
		try {
			session = MybatisUtils.getSession();
			EventDao ed = session.getMapper(EventDao.class);
			int count = ed.insertEvent(event);
			session.commit(); // 提交事务
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
