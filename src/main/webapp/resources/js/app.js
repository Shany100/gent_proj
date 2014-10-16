// 引入 requirejs

requirejs.config({
	baseUrl: '/resources',
	paths:{
		'angular': "components/angular-1.2.21/angular",
		'angular-route': "components/angular-1.2.21/angular-route",
		'calendar': 'components/calendar/calendar'
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

require(['js/controllers/detailController'],function(keepApp){
	
	
});
