;(function(){

	var userApp = angular.module('userApp', []);
	userApp.run(function(){
	
	});	
	
	userApp.controller('LoginController', ['$scope', function($scope) {
		$scope.checked = true;
		$scope.login = function(userName, password, checked){
			console.log(arguments);
		};
		
		$scope.$watch("userName", function(newVal, oldVal, scope){
			console.log(arguments);
		});
	}]);
})();