package com.jiang.gent.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
	
}
