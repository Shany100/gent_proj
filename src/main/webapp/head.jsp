<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>

<%
	String pageName = request.getParameter("pageModule");
	response.getWriter().print("当前页面名称是： "+pageName);
%>    
    
<link href="/resources/js/bootstrap-3.2.0-dist/css/bootstrap.css" rel="stylesheet" >

<div class="navbar navbar-default navbar-inverse">
	<div class="container">
	 <div class="navbar-header">
	    <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target=".navbar-collapse">
	      <span class="sr-only">Toggle navigation</span>
	      <span class="icon-bar"></span>
	      <span class="icon-bar"></span>
	      <span class="icon-bar"></span>
	    </button>
	    <a class="navbar-brand" href="/index">绅士神器</a>
	  </div>
	  <div class="collapse navbar-collapse">
	    <ul class="nav navbar-nav">
	      <li class="active"><a href="/index">首页</a></li>
	      <li><a href="/list.jsp">查看事件</a></li>
	    </ul>
	    <ul class="nav navbar-nav navbar-right">
	      <li><a href="/login.jsp">登录</a></li>
	      <li><a href="/mobile/register.jsp">注册</a></li>
	      <li><a href="#about">关于神器</a></li>
	    </ul>
	  </div><!--/.nav-collapse -->
	</div>
</div>