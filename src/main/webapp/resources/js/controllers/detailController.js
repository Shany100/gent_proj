/*
 * record controller
 */
define(["js/services/recordService", 'calendar'], function(keepApp, calendar){
	var v = "0.0.1";
	
	keepApp.controller('DetailController', ['$scope','recordService','$routeParams', 
	  function($scope, recordService, $routeParams){
		
		$scope.eventId = $routeParams.eventId;
		$scope.totalRecordNum = 98954;
		$scope.formShowFlag = true;
		$scope.tipShowFlag = false;
		$scope.numAnimation = "";
		$scope.addTipCls = "";
		
		recordService.listRecords($scope, $routeParams.eventId);

		$scope.takeNote = function(event){
			recordService.addRecord($scope, $routeParams.eventId, $scope.note);
		}
	}]);
	
	keepApp.controller('CalendarController',['$scope', function($scope){
		$scope.curDate = calendar.getYear() + "年" + calendar.getMonth() + "月";
		$scope.days = calendar.simpleDays;
		$scope.items = calendar.getAll();
		$scope.today = calendar.getDate();
		$scope.month = calendar.getMonth(); // 变量
		$scope.curmonth = calendar.getMonth();// 长量
		
		// 切换月份
		$scope.previous = function(plus){
			angular.extend($scope, calendar.previous(plus));
		}
	}]);
	
	
	return keepApp;
});