<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@page import="com.jiang.gent.bean.User"%>    
<%
	Object o = session.getAttribute("keep_user");
	if(null == o){
		response.sendRedirect("/login.jsp");
	}
	User user = (User)session.getAttribute("keep_user");
	String email = user.getEmail();
	int userId = user.getId();
%>    
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=0" >
<title>Keep - Welcome</title>
<link href="/resources/components/bootstrap-3.2.0-dist/css/bootstrap.css" rel="stylesheet" >

<script src="/resources/components/requirejs/require.js"></script>


<script type="text/javascript">var userId=<%=userId%>;</script>

<link rel="stylesheet" href="/resources/css/base.css">
</head>
<body>
<jsp:include page="/head.jsp"></jsp:include>
<div class="container" style="display:none;">
	<h1>Keep</h1>
	<h2><%=email %></h1>
	<h3 data-info="坚持就是胜利">Insist！</h3>
</div>

<div ng-view></div>

<jsp:include page="/foot.jsp"></jsp:include>
<script type="text/javascript" src="/resources/js/app.js"></script>
</body>
</html>