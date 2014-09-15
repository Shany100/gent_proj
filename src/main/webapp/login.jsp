<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1" >
<title>login - Keep</title>
<link href="/resources/js/bootstrap-3.2.0-dist/css/bootstrap.css" rel="stylesheet" >
<script type="text/javascript" src="/resources/js/angular-1.2.21/angular.js"></script>
<style>
	.head_wrap{
		position:relative;
		z-index:-1;
	}
	.head_wrap img{
		width:100%;
	}
	.title{
		text-align: center;
		background: #0E5E94;
		margin: 10px auto 30px;
		color: rgb(252, 252, 252);
		width: 120px;
		height: 120px;
		border-radius: 100%;
		line-height: 120px;
	}
	.banner_big{
		border-radius: 50px;
	}
</style>
</head>
<body ng-app="userApp">
<div class="head_wrap">
	<h1 class="title">Keep</h1>
</div>
<!-- login -->
<div class="container" ng-controller="LoginController">
	<form action="/login" method="post" class="">
		<div class="form-group">
			<label for="emailIpt" class="sr-only">账户</label>
			<input id="emailIpt" name="userName" type="text" class="form-control input-lg" autofocus placeholder="输入邮箱地址" ng-model="userName">
		</div>
		<div class="form-group">
			<label for="psdIpt" class="sr-only">密码</label>
			<input id="psdIpt" name="password" type="password" class="form-control input-lg" placeholder="输入密码" ng-model="password">
		</div>
		<div class="checkbox">
			<label>
				<input type="checkbox" name="remeber" ng-checked={{checked}} ng-model="checked"> 记住密码 
			</label>
		</div>
		<button type="button" class="btn btn-primary btn-block btn-lg" ng-click="login(userName, password, checked)">登录</button>
	</form>
	<div>邮箱：{{userName}}<br/>密码：{{password}}</div>
</div>

<!-- register -->

<script type="text/javascript" src="/resources/js/user.js"></script>
</body>
</html>