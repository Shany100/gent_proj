package com.jiang.gent.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.google.gson.Gson;
import com.jiang.gent.bean.User;
import com.jiang.gent.service.UserServiceImpl;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class UserAction extends ActionSupport {
	private String email;
	private String userName;
	private String password;
	private String passwordRe;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPasswordRe() {
		return passwordRe;
	}

	public void setPasswordRe(String passwordRe) {
		this.passwordRe = passwordRe;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public void register(){
		boolean pswdFlag = this.password.equals(this.passwordRe);
		boolean result = false;
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		if(pswdFlag){
			User user = new User();
			user.setCreateTime(new Date());
			user.setEmail(email);
			user.setPassword(password);
			result = new UserServiceImpl().addUser(user);
			resultMap.put("success", result);
			if(result){
				resultMap.put("msg", "注册成功");
				 HttpSession hs = ServletActionContext.getRequest().getSession();
				hs.setAttribute("gentUserEmail", user.getEmail());
				System.out.println(hs.getAttribute("gentUserEmail").toString());
			}else{
				resultMap.put("msg", "数据未添加成功，注册失败");
			}
		}else{
			resultMap.put("success", false);
			resultMap.put("passwordLegal", false);
			resultMap.put("msg", "填写的密码不一致");
		}
		this.responseMsg(resultMap);
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
	
	public String login() throws Exception{
		
		System.out.println(this.userName + " / " + this.password);
		if(null != this.userName && "test@meizu.com".equals(this.userName)){
			ActionContext.getContext().getSession().put("userName", this.userName);
			return this.SUCCESS;
		}else{
			return "login";
		}
	}
	
	public String list() throws Exception{
		
		return "list";
		/*
		ActionContext ac = ActionContext.getContext();
		Map session = ac.getSession();
		String name = (String) session.get("userName");
		if(name != null){
			return "list";
		}
		return "failure";
		*/
	}
}
