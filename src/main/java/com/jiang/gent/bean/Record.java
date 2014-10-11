package com.jiang.gent.bean;

import java.sql.Timestamp;
import java.util.Date;

public class Record {

	private int eventId;
	private int id;
	private Timestamp record_time;
	private long recordTime;
	private String note;
	
	public long getRecordTime() {
		return recordTime;
	}
	public void setRecordTime(long recordTime) {
		this.recordTime = recordTime;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public int getEventId() {
		return eventId;
	}
	public void setEventId(int eventId) {
		this.eventId = eventId;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getRecord_time() {
		return record_time;
	}
	public void setRecord_time(Timestamp record_time) {
		this.record_time = record_time;
		this.setRecordTime(record_time.getTime());
	}
	
}
