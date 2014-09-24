/**
 * 集合工具的模块
 */
define(function(){
	var tmp = "util", 
		version = "0.0.1";
	
	return {
		version: version,
		getRan: function(){
			return Math.random() * 10; // random 产生0 ~ 1直接的随机数
		}
	}
	
});