/*
 * record service
 */
define(["js/ctrl"], function(keepApp){
	var v = "0.0.1";
	
	keepApp.factory("recordService", ["$http","$window", function($http, $window){
		var listRecordUrl = "/event_getEvent", // special api. event object contain records
			addRecordUrl = '/record_addRecord'; // 添加记录URL

		return {
			listRecords: function(scope, id){
				$http({
					method: 'get', 
					url: listRecordUrl,
					params: {id: id}
				}).
				success(function(data){
					console.log("recordService ", data);
					if(data.success){
						scope.event = data.data;
						scope.records = data.data.records;
						scope.totalRecordNum = data.data.records.length;
						scope.todayHasRecordFlag = data.todayHasRecordFlag;
					}
				}).
				error(function(data){
					
				});
			},
			addRecord: function(scope, id, note){
				$http({
					method: 'post',
					params:{
						note: note,
						eventId: id
					} , 
					url: addRecordUrl
				}).
				success(function(data){
					if(data.success){
						scope.totalRecordNum++;
						scope.formShowFlag = false;
						scope.tipShowFlag = true;
						scope.numAnimation = "num-anim";
						scope.addTipCls = "add-tip";
					}
				}).
				error(function(data){
					
				});
			}
		}
	}]);
	
	
	return keepApp;
});