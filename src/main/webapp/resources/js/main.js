
// 程序主入口 

requirejs.config({
	baseUrl: '/resources',
	paths:{
		'angular': "components/angular-1.2.21/angular"
	},
	shim:{
		"angular":{
            exports:"angular"
        }
    }
});

require(["js/user"], function(user){
	new user();
});

// require   define  获取文件路径的不同