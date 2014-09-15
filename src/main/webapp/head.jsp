<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>

<%
	String pageName = request.getParameter("pageModule");
	//response.getWriter().print("当前页面名称是： "+pageName);
%>    
    
<link href="/resources/js/bootstrap-3.2.0-dist/css/bootstrap.css" rel="stylesheet" >
<script type="text/javascript" src="/resources/js/angular-1.2.21/angular.js"></script>
<script type="text/javascript">
	(function(){
		var indexApp = angular.module('indexApp', []);
		indexApp.controller('toolController', ["$scope", function($scope){
			$scope.toolFlag = false;
			$scope.toggleTool = function(){
				if($scope.toolFlag){
					$scope.toolFlag = false;
				}else{
					$scope.toolFlag = true;
				}
			}
		}]);
	})();
</script>
<div class="navbar navbar-default navbar-inverse" ng-app="indexApp">
	<div class="container" ng-controller="toolController">
	 <div class="navbar-header">
	    <button type="button" class="navbar-toggle collapsed" ng-click="toggleTool()">
	      <span class="sr-only">Toggle navigation</span>
	      <span class="icon-bar"></span>
	      <span class="icon-bar"></span>
	      <span class="icon-bar"></span>
	    </button>
	    <a class="navbar-brand" href="/index">Keep</a>
	  </div>
	  <div class="collapse navbar-collapse" ng-show="toolFlag" style="display:block">
	    <ul class="nav navbar-nav">
	      <li class="active"><a href="/list.jsp" title="事件列表">事件列表</a></li>
	    </ul>
	    <ul class="nav navbar-nav navbar-right">
	      <li><a href="#"  title="添加事件"><span class="glyphicon glyphicon-plus"></span></a></li>
	      <li><a href="/logout">退出</a></li>
	    </ul>
	  </div><!--/.nav-collapse -->
	</div>
</div>