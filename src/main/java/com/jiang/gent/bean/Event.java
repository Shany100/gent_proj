package com.jiang.gent.bean;

import java.util.Date;

public class Event {
	private int id;
	
	private String name;
	
	private Date createTime;
	
	private int flag;
	
	public String loveStart;
	
	public void Event(){
		
	}
	
	public void Event(String name, Date createTime, int flag){
		this.name = name;
		this.createTime = createTime;
		this.flag = flag;
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

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
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
