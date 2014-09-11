<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%
	HttpSession sesssion = request.getSession();
	String email = (String)session.getAttribute("gentUserEmail");
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1" >
<title>首页 - 个人神器</title>
	<link rel="stylesheet" href="/resources/js/jquery.mobile-1.4.3/jquery.mobile-1.4.3.min.css" />
	
	<style type="text/css" rel="stylesheet">
		#tipView{color:red;font-size:12px;line-height:16px;}
	</style>
</head>
<body>
	<div data-role="page">
		<div data-role="header" data-theme="b" class="ui-bar-b">
			<h1>一统江湖神器</h1>
			<a href="#" data-icon="user" class="ui-btn-right">登录</a>
		</div><!-- /header -->
	
		<div role="main" class="ui-content">
			<p style="text-align:center;"><%=email%></p>
			<ul data-role="listview" data-count-theme="b" data-inset="true">
			    <li><a href="#">打篮球 <span class="ui-li-count">172</span></a></li>
			    <li><a href="#">看书 <span class="ui-li-count">0</span></a></li>
			    <li><a href="#">写日记 <span class="ui-li-count">235</span></a></li>
			    <li><a href="#">煮饭 <span class="ui-li-count">12</span></a></li>
			    <li><a href="#">打麻将 <span class="ui-li-count">62</span></a></li>
			</ul>
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
	<script type="text/javascript" src="/resources/mobile/js/index.js"></script>
</body>
</html>