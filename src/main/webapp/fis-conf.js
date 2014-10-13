// 利用 fis 工具对前端资源进行优化


fis.config.set('pack', {
    '/resources/pkg/lib.js': [
        '/resources/js/angular-1.2.21/angular.js',
        '/resources/js/angular-1.2.21/angular-route.js'
    ]
});