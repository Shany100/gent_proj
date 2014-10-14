require.config({
	paths: {
		"angular":"../angular-1.2.21/angular"
	},
	shim:{
		"angular":{
            exports:"angular"
        }
    }
});

// 'calendar' 相对路径为当前文件的路径一致
require(['calendar', 'angular'], function(calendar, angular){
	var CalendarApp = angular.module('CalendarApp', []);
	CalendarApp.controller('CalendarController',['$scope', function($scope){
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
});