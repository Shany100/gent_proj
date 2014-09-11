package com.jiang.gent.interceptor;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class SecurityInterceptor extends AbstractInterceptor {

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		String userName = (String) invocation.getInvocationContext().getSession().get("userName");
		if(null != userName && userName.equals("test@meizu.com")){
			System.out.println("合法用户");
			return invocation.invoke();
		}else{
			return Action.LOGIN;
		}
	}

}
