package com.jiang.gent.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.google.gson.Gson;
import com.jiang.gent.bean.Record;
import com.jiang.gent.service.RecordServiceImpl;
import com.opensymphony.xwork2.ActionSupport;

public class RecordAction extends ActionSupport {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int eventId;
	private String note;
	
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

	/**
	 * 添加记录
	 */
	public void addRecord(){
		Map resultMap = new HashMap();
		Record record = new Record();
		if(eventId != 0){
			record.setEventId(eventId);
			record.setNote(note);
			record.setRecord_time(new Timestamp(System.currentTimeMillis()));
			boolean flag = new RecordServiceImpl().addRecord(record);
			resultMap.put("success", true);
			resultMap.put("data", flag);
		}else{
			resultMap.put("success", false);
			resultMap.put("msg", "添加失败");
		}
		this.responseMsg(resultMap);
	}

	private void responseMsg(Map resultMap){
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
