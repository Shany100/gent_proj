<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1" >
<title>个人神器 - Welcome</title>
<link href="/resources/js/bootstrap-3.2.0-dist/css/bootstrap.css" rel="stylesheet" >
</head>
<body>
<jsp:include page="head.jsp"></jsp:include>
<div class="container">
	<h1>Welcome To Fish 1! Please login</h1>
	<form action="/login" method="post" class="form-inline">
		<div class="form-group">
			<label for="emailIpt" class="sr-only">账户</label>
			<input id="emailIpt" name="userName" type="email" class="form-control" autofocus placeholder="输入邮箱地址">
		</div>
		<div class="form-group">
			<label for="psdIpt" class="sr-only">密码</label>
			<input id="psdIpt" name="password" type="password" class="form-control" placeholder="输入密码">
		</div>
		<div class="checkbox">
			<label>
				<input type="checkbox" name="remeber"> 记住密码
			</label>
		</div>
		<button type="submit" class="btn btn-primary">登录</button>
	</form>
</div>
</body>
</html>