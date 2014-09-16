package com.jiang.gent.action;

import java.util.Date;

import com.jiang.gent.bean.Event;
import com.jiang.gent.service.EventServiceImpl;
import com.opensymphony.xwork2.ActionSupport;

public class EventAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4217148269183900179L;
	
	private String name;
	private int userId;
	private String note;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	
	public String addEvent(){
		boolean flag = false;
		Event event = new Event();
		event.setName(name);
		event.setNote(note);
		event.setUserId(userId);
		event.setCreateTime(new Date());
		flag = new EventServiceImpl().addEvent(event);
		if(flag){
			return this.SUCCESS;
		}else{
			return "failure";
		}
	}
	
}
