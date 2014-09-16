(function(){
	var keepConfig = (function(id){
		return {
			userId: id
		};
	})(userId);
	
	var keepApp = angular.module('keepApp', ['ngRoute'])
		.run(function(){
			console.log("keepapp running...");
		});
	keepApp.controller('toolController', ["$scope", function($scope){
		$scope.toolFlag = false;
		$scope.toggleTool = function(){
			if($scope.toolFlag){
				$scope.toolFlag = false;
			}else{
				$scope.toolFlag = true;
			}
		}
	}]);
	
	keepApp.config(['$routeProvider', 
	  function($routeProvider) {
	    $routeProvider.
	      when('/events', {
	      	templateUrl: "events.html",
	      	controller: 'EventsController'
	      }).
	      when('/eventForm', {
	      	templateUrl: "eventForm.html",
	      	controller: 'EventFormController'
	      }).
	      when('/detail/:eventId/:eventName', {
	      	templateUrl: "detail.html",
	      	controller: 'DetailController'
	      }).
	      otherwise({
	        redirectTo: '/events'
	      });
	  }
	]);
	
	keepApp.controller('EventsController', ['$scope', function($scope){
		
		$scope.events = [
		  {name: 'play basketball', createTime: '', count: 514},
		  {name: '统计不吃辣', createTime: '', count: 88},
		  {name: '进城玩耍', createTime: '', count: 14},
		  {name: 'read book', createTime: '', count: 56},
		  {name: '麻将时间', createTime: '', count: 10},
		  {name: '统计不吃辣', createTime: '', count: 88},
		  {name: '进城玩耍', createTime: '', count: 14},
		  {name: 'read book', createTime: '', count: 56},
		  {name: '麻将时间', createTime: '', count: 10}
		]
	
	}]);
	
	keepApp.controller('EventFormController', ['$scope', function($scope){
		$scope.userId = keepConfig.userId;
		$scope.addFlag = true;
	
	}]);
})();

