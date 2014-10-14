// CMD 写法
// AMD 写法
// jQuery 插件
// angularjs 插件



// Definition Functions without Dependencies

define(function(){
	var days = ["星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"],
		simpleDays = ["日", "一", "二", "三", "四", "五", "六"],
		currentDate = new Date(); // 后期可配置
	
	var tmpDate = new Date();
	tmpDate.setDate(1);
	console.log(tmpDate.getDay()); // 0~6
	
	function initDayArray(curDate){
		var day = curDate.getDay();
		var num = countDays(curDate.getMonth() + 1, curDate.getFullYear());
		var alls = [];
		var items = [];
		var i, d=1;
		
		for(i = 1; i<6; i++){
			for(j = 1; j < 8; j++){
				if(i==1 && j<=day ){
					items.push("");
				}else{
					d > num ? d = "" : d = d ;
					items.push(d);
					d== ""?d="":d++;
				}
				
			}
			alls.push(items)
			items = [];
		}
		// 5 行
		return alls;
	}
	
	function countDays(month, year){
		var num = 30;
		console.log(month == 2)
		if(month == 2){
			(year % 4 == 0) ? num = 29 : num = 28;
			return num;
		}
		
		if(month < 7 && month != 2){
			(month % 2 == 0) ? num = 30 : num = 31;
		}else{
			(month % 2 == 0) ? num = 31 : num = 30;
		}
		
		return num;
	}
		
	return {
		days: days,
		simpleDays: simpleDays,
		currentDate: currentDate,
		month: currentDate.getMonth() + 1,
		getDay: function(){
			return days[currentDate.getDay()];
		},
		// 获取月份
		getMonth: function(){
			this.curMonth = currentDate.getMonth() + 1;
			return this.curMonth;
		},
		// 获取天数
		getDate: function(){
			return currentDate.getDate();
		},
		// 获取年份
		getYear: function(){
			return currentDate.getFullYear();
		},
		getAll: function(date){
			date = date || tmpDate;
			var alls = initDayArray(date);
			return alls;
		},
		previous: function(plus){
			var date = new Date();
			this.month = this.month + plus;
			if(plus == 0){
				this.month = this.curMonth;
			}
			date.setMonth(this.month-1);
			date.setDate(1);
			this.items = this.getAll(date);
			this.curDate = date.getFullYear() + "年" + (date.getMonth()+1) + "月";
			
			return {
				month: this.month,
				items: this.items,
				curDate: this.curDate
			}
		}
	};
});