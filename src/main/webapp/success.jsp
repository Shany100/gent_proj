<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@page import="com.jiang.gent.bean.User"%>
<%
	
	//User user = (User)session.getAttribute("keep_user");
	String email = "tmp@sina.com"; //user.getEmail();
	
	response.sendRedirect("/index.jsp");
%>    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1" >
<link href="/resources/js/bootstrap-3.2.0-dist/css/bootstrap.css" rel="stylesheet" >
<title>access successful</title>
</head>
<body>
	<div class="container">
		<h1><%=email %></h1>
		<h2>访问成功</h2>
		<a href="/logout">退出</a>
	</div>
</body>
</html>