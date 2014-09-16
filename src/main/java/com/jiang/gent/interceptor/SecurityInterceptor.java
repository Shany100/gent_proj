package com.jiang.gent.interceptor;

import com.jiang.gent.bean.User;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class SecurityInterceptor extends AbstractInterceptor {

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		User keep_user = null;
		keep_user = (User) invocation.getInvocationContext().getSession().get("keep_user");
		if(null != keep_user ){
			System.out.println("合法用户");
			return invocation.invoke();
		}else{
			return Action.LOGIN;
		}
	}

}
