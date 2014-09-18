package com.jiang.gent.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.google.gson.Gson;
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
		if(name == null && !name.equals("")){
			return "failure";
		}
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
	/**
	 * 查询事件列表
	 */
	public void listEvents(){
		// 接收分页参数  page  limit
		Map resultMap = new HashMap();
		if(userId > 0){
			List<Event> events = new EventServiceImpl().ListEvents(userId, 0, 0);
			resultMap.put("success", true);
			resultMap.put("data", events);
		}else{
			resultMap.put("success", false);
			resultMap.put("msg", "用户不存在");
		}
		responseMsg(resultMap);
	}
	public void responseMsg(Map resultMap){
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
		PrintWriter pw;
		try {
			pw = response.getWriter();
			Gson gson = new Gson();
			pw.print(gson.toJson(resultMap));
			pw.flush();
			pw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
