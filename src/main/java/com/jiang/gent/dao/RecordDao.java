package com.jiang.gent.dao;

import java.util.List;
import java.util.Map;

import com.jiang.gent.bean.Record;

public interface RecordDao {
	
	// 插入记录数据
	public int insertRecord(Record record);
	public List<Record> getRecordByMap(Map map);
	// 根据事件标识查询记录列表
	public List<Record> listRecordsByEventId(int eventId);
}
