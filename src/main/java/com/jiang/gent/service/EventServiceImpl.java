package com.jiang.gent.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
	
	public List<Event> ListEvents(int userId, int page, int limit){
		SqlSession session = null;
		List<Event> events = new ArrayList<Event>();
		try {
			session = MybatisUtils.getSession();
			EventDao ed = session.getMapper(EventDao.class);
			events = ed.listEvents(userId);
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			session.close();
		}
		return events;
	}
	
	public Event getEvent(int id){
		SqlSession session = null;
		Event event = null;
		try {
			session = MybatisUtils.getSession();
			EventDao ed = session.getMapper(EventDao.class);
			event = ed.getEventById(id);
			event.setCreateTime(event.getCreate_time().getTime());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			session.close();
		}
		return event;
	}
	
}
