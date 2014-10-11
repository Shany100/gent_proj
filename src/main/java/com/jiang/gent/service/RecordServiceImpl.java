package com.jiang.gent.service;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.jiang.gent.bean.Event;
import com.jiang.gent.bean.Record;
import com.jiang.gent.dao.EventDao;
import com.jiang.gent.dao.RecordDao;
import com.jiang.gent.dao.utils.MybatisUtils;

public class RecordServiceImpl {
	/**
	 * 添加事件
	 * @param record
	 */
	public boolean addRecord(Record record){
		
		boolean flag = false;
		SqlSession session = null;
		
		try {
			session = MybatisUtils.getSession();
			RecordDao rd = session.getMapper(RecordDao.class);
			int count = rd.insertRecord(record);
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
	
	public boolean hasRecord(int eventId){
		
		boolean flag = false;
		SqlSession session = null;
		
		try {
			session = MybatisUtils.getSession();
			RecordDao rd = session.getMapper(RecordDao.class);
			Map paramMap = new HashMap();
			paramMap.put("eventId", eventId);
			paramMap.put("today", new Timestamp(new Date().getTime()));
			
			List<Record> records= rd.getRecordByMap(paramMap);
			if(records != null && records.size() > 0){
				flag = true;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			session.close();
		}
		
		return flag;
	}
	
	public List<Record> listRecordsByEventId(int eventId){
		List<Record> records = new ArrayList<Record>();
		SqlSession session = null;
		
		try {
			session = MybatisUtils.getSession();
			RecordDao rd = session.getMapper(RecordDao.class);
			records = rd.listRecordsByEventId(eventId);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return records;
	}
}
