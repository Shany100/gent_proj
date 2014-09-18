package com.jiang.gent.dao;

import java.util.List;

import com.jiang.gent.bean.Event;

public interface EventDao {
	public Event getEventById(int id);
	public int insertEvent(Event event);
	public List<Event> listEvents(int userId);
	
	//public List<Event> listEvents(int userId, int page, int limit); // 参数问题
}
