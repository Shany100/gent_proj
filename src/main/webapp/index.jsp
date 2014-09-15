<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@page import="com.jiang.gent.bean.User"%>    
<%
	User user = (User)session.getAttribute("keep_user");
	String email = user.getEmail();
%>    
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1" >
<title>Keep - Welcome</title>
<link href="/resources/js/bootstrap-3.2.0-dist/css/bootstrap.css" rel="stylesheet" >
</head>
<body>
<jsp:include page="/head.jsp"></jsp:include>

<div class="container">
	<h1>Keep</h1>
	<h2><%=email %></h1>
	<h3 data-info="坚持就是胜利">Insist！</h3>
</div>
</body>
</html>