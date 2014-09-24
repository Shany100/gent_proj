
define(["angular", "utils/util"], function(angular, util){

	return function(){
		var userApp = angular.module('userApp', []);
		userApp.run(function(){
			console.log("app run."); 
		});	
		userApp.factory('loginFactory', ["$http",function($http) {
		  return {
		    login: function(userName, password) {
		      var data = "userName="+userName+"&"+"password="+password;
		      $http.post('/login',data,{
		      	 headers: {'Content-Type': 'application/x-www-form-urlencoded'}	      	
		      }).success( function(data, status) {
		      		console.log(data);
		      	}).error( function(data, status){
		      		console.log(data)
		      	});
		    }
		  };
		}]);
		
		// 手动获取
		//var injector = angular.injector(['userApp', 'ng']);
		//var loginFactory = injector.get('loginFactory');
		
		userApp.controller('LoginController', ['$scope','loginFactory', function($scope, loginFactory) {
			
			$scope.errorTipFlag = loginFlag;
			$scope.userName = "jantollong@sina.com";
			$scope.password = "123456";
			$scope.checked = true;
			$scope.login = function(userName, password, checked){
				alert(util.getRan());
				if(!userName || !password){
					$scope.errorTipFlag = true;
				}else{
					$scope.errorTipFlag = false;
					//loginFactory.login(userName, password);
				}
			};
			
			$scope.$watch("userName", function(newVal, oldVal, scope){
				// 监听账户的输入情况
			});
			
			//校验邮箱
			$scope.validEmail = function(userName){
				var rg = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
				console.log(rg.test(userName));
			}
		}]);
	}
});