package com.jiang.gent.bean;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

public class Event {
	private int id;
	
	private String name;
	
	private int userId;
	
	private String note;
	
	private Timestamp create_time;
	
	private int flag;
	private long createTime;
	
	private List<Record> records;

	public List<Record> getRecords() {
		return records;
	}

	public void setRecords(List<Record> records) {
		this.records = records;
	}

	public Timestamp getCreate_time() {
		return create_time;
	}

	public void setCreate_time(Timestamp create_time) {
		this.create_time = create_time;
	}

	public void setCreateTime(long createTime) {
		this.createTime = createTime;
	}

	public String loveStart;
	
	public void Event(){
		
	}
	
	public void Event(String name, Timestamp createTime, int flag){
		this.name = name;
		this.create_time = createTime;
		this.flag = flag;
	}
	
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getCreateTime() {
		return createTime;
	}

	public int getFlag() {
		return flag;
	}

	public void setFlag(int flag) {
		this.flag = flag;
	}

	public String getLoveStart() {
		return loveStart;
	}

	public void setLoveStart(String loveStart) {
		this.loveStart = loveStart;
	}
	
}
