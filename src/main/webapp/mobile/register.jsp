<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1" >
<title>注册 - 个人神器</title>
	<link rel="stylesheet" href="/resources/js/jquery.mobile-1.4.3/jquery.mobile-1.4.3.min.css" />
	
	<style type="text/css" rel="stylesheet">
		#tipView{color:red;font-size:12px;line-height:16px;}
	</style>
</head>
<body>
	<div data-role="page">
		<div data-role="header" data-theme="b" class="ui-bar-b">
			<a href="#" data-icon="home" class="ui-btn-left">首页</a>
			<h1>注册 - 个人神器</h1>
			<a href="#" data-icon="user" class="ui-btn-right">登录</a>
		</div><!-- /header -->
	
		<div role="main" class="ui-content">
			<p>少年，来的还不晚，赶紧注册一个吧。</p>
			<form method="post" id="registerForm" data-ajax="true">
				<input type="text" name="email" id="emailIpt" placeholder="邮箱地址" value=""  data-clear-btn="true">
				<input type="password" name="password" id="passwordIpt" value="" autocomplete="off" placeholder="密码"  data-clear-btn="true">
				<input type="password" name="passwordRe" id="passwordReIpt" value="" autocomplete="off" placeholder="确认密码"  data-clear-btn="true">
				<a id="submitBtn" href="javascript:void(0)" class="ui-btn ui-corner-all ui-shadow ui-icon-arrow-r ui-btn-icon-right">注册</a>
				
				<p id="tipView" data-default="register operation info"></p>
			</form>
		</div><!-- /content -->
	
		<div data-role="footer"  data-theme="b">
			<h4>诞生时间: 2014-08-14 14:00:00</h4>
		</div><!-- /footer -->
	
	</div><!-- /page -->

	<script src="/resources/js/jquery.mobile-1.4.3/demos/js/jquery.min.js"></script>
	<script type="text/javascript">
	$(document).on('mobileinit', function(){ 
		//You must connect a handler to the mobileinit event before you load jQuery Mobile, 
		//because it is triggered as part of the library's loading process. 
	});
	</script>
	<script src="/resources/js/jquery.mobile-1.4.3/jquery.mobile-1.4.3.min.js"></script>
	<script type="text/javascript" src="/resources/mobile/js/register.js"></script>
</body>
</html>