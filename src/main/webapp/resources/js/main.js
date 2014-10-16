
// 程序主入口 

requirejs.config({
	baseUrl: '/resources',
	paths:{
		'angular': "components/angular-1.2.21/angular",
		'angular-route': "components/angular-1.2.21/angular-route",
		'calendar': 'components/calendar/calendar',
		'util': 'js/utils/util'
	},
	shim:{
		"angular":{
            exports:"angular"
        },
        "angular-route":{
        	deps: ['angular']
        }
    }
});

require(["js/user"], function(user){
	new user();
});

// require   define  获取文件路径的不同