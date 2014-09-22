
// 程序主入口 

require.config({
    //配置angular的路径
    paths:{
        "angular":"angular-1.2.21/angular", 
        "angular-route":"angular-1.2.21/angular-route"
    },
    //这个配置是你在引入依赖的时候的包名
    shim:{
        "angular":{
            exports:"angular"
        },
        "angular-route":{
            exports:"angular-route"
        }
    }
});

require(["user"], function(user){
	new user();
});

// require   define  获取文件路径的不同