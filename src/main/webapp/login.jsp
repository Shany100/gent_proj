<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%
	Object o = request.getAttribute("test");
	boolean test = false;
	if(null != o){
		test = (Boolean)o;	
	}
	
%>    
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1" >
<META HTTP-EQUIV="CACHE-CONTROL" CONTENT="NO-CACHE, NO-STORE">
<title>login - Keep</title>
<link href="/resources/js/bootstrap-3.2.0-dist/css/bootstrap.css" rel="stylesheet" >

<link href="/resources/css/login.css" rel="stylesheet" >
<script data-main="/resources/js/main.js" src="/resources/js/requirejs/require.js"></script>
<script type="text/javascript">
	var loginFlag = <%=test %>;
</script>
</head>
<body ng-app="userApp">
<div class="head_wrap">
	<h1 class="title">Keep</h1>
</div>
<!-- login -->
<div class="container" ng-controller="LoginController">
	<form action="/login" method="post" class="" ng-submit="login(userName, password, checked)">
		<div class="form-group">
			<label for="emailIpt" class="sr-only">账户</label>
			<input id="emailIpt" name="userName" type="text" class="form-control input-lg" autofocus placeholder="输入邮箱地址" ng-model="userName" ng-blur="validEmail(userName)">
		</div>
		<div class="form-group">
			<label for="psdIpt" class="sr-only">密码</label>
			<input id="psdIpt" name="password" type="password" class="form-control input-lg" placeholder="输入密码" ng-model="password">
		</div>
		<div class="error_tip" ng-show="errorTipFlag">
			您输入的电子邮件或密码不正确。
		</div>
		
		<!-- 记住密码 这一功能在现在的很多应用当中都是默认的。 故而不需要显示在界面上。 'checkShow' default value is false. -->
		<div class="checkbox" ng-show="checkShow">
			<label>
				<input type="checkbox" name="remeber" ng-checked={{checked}} ng-model="checked"> 记住密码 
			</label>
		</div>
		<button type="submit" class="btn btn-primary btn-block btn-lg" >登录</button>
	</form>
</div>

<!-- register -->

<!-- 页尾 -->
<footer class="footer">
  <div class="container">
    <p>Designed by <a href="http://weibo.com/jantol" target="_blank">@鱼统江湖</a>.</p>
    <p>当前版本： v0.0.1</p>
    <p><a href="https://github.com/Shany100/gent_proj">GitHub 仓库</a></p>
  </div>
</footer>

</body>
</html>