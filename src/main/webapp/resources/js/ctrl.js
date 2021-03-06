define(['angular', 'angular-route'], function(angular, angularroute , calendar){
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
	/**
	 * remove 'ng-app="keepApp"'  because angular-route unable to instantiate module when loaded using RequireJS. 
	 * 参考： https://code.angularjs.org/1.2.1/docs/guide/bootstrap#overview_deferred-bootstrap 
	 * #Manual Initialization#
	 */  
	angular.element(document).ready(function () {
        angular.bootstrap(document, ['keepApp']);
    });
	
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
	      when('/detail/:eventId', {
	      	templateUrl: "detail.html",
	      	controller: 'DetailController'
	      }).
	      otherwise({
	        redirectTo: '/events'
	      });
	  }
	]);
	
	keepApp.controller('EventsController', ['$scope','$http', function($scope, $http){
		
		$http({method: 'GET', url: '/event_listEvents?userId=' + keepConfig.userId}).
		  success(function(data, status, headers, config){
			console.log(data)
			$scope.events = data.data;
		  }).
		  error(function(data, status, headers, config) {
		    
		  });
	}]);
	
	keepApp.controller('EventFormController', ['$scope', function($scope){
		$scope.userId = keepConfig.userId;
		$scope.addFlag = true;
	
	}]);
		
	return keepApp;
});
