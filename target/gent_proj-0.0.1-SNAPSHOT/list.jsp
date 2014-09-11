<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1" >
<title>个人神器 - Welcome</title>
</head>
<body>
<jsp:include page="/head.jsp"></jsp:include>
	
<div class="container">
	<h1>事件列表  / 添加事件</h1>
	<form role="form">
	  <div class="form-group">
	    <label for="exampleInputEmail1" class="label label-warning">少年，多做事吧</label>
	    <input type="email" class="form-control" id="exampleInputEmail1" placeholder="输入事件名称">
	  </div>
	</form>
	<ul class="list-group">
	  <li class="list-group-item">打篮球 <span class="badge">1285</span></li>
	  <li class="list-group-item list-group-item-danger">看书<span class="badge">0</span></li>
	  <li class="list-group-item">写日记<span class="badge">237</span></li>
	  <li class="list-group-item">吃辣椒<span class="badge">155</span></li>
	  <li class="list-group-item">煮饭<span class="badge">8</span></li>
	  <li class="list-group-item">打麻将<span class="badge">15</span></li>
	</ul>
</div>
	
</body>
</html>