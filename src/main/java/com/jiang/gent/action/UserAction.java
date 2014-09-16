package com.jiang.gent.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.google.gson.Gson;
import com.jiang.gent.bean.User;
import com.jiang.gent.service.UserServiceImpl;
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
	
	/**
	 * 检测邮箱是否已经存在
	 * @return
	 */
	public boolean checkEmail(String email){
		boolean flag = true;
		
		if(email.equals("")){
			flag = false;
		}else{
			// 查询输入的邮箱号是否存在
		}
		
		return flag;
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
		LOG.info(userName, password);
		HttpServletRequest request = ServletActionContext.getRequest();
		if(null != this.userName && null != password){
			User user = new User();
			user.setEmail(this.userName);
			user.setPassword(this.password);
			User pUser = new UserServiceImpl().checkUser(user);
			if(pUser != null && pUser.getId() > 0 ){
				request.getSession().setAttribute("keep_user", pUser);
				return this.SUCCESS;
			}else{
				
				request.setAttribute("test", true);
				return "login";
			}
		}else{
			request.setAttribute("test", true);
			return "login";
		}
	}
	public String logout(){
		HttpServletRequest request = ServletActionContext.getRequest();
		request.getSession().removeAttribute("keep_user");
		return "login";
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
