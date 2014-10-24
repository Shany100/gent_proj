module.exports = function(grunt) {
  // Project configuration.
  grunt.initConfig({
    pkg: grunt.file.readJSON('package.json'),
    uglify: {
      options: {
        banner: '/*! <%= pkg.name %> <%= grunt.template.today("yyyy-mm-dd") %> */\n'
      },
      build: {
        src: 'resources/css/postcss/<%= pkg.name %>.js',
        dest: 'build/resources/css/<%= pkg.name %>.min.js'
      }
    },
    postcss: {
	    options: {
	      processors: [
	        require('autoprefixer-core')({browsers: 'last 1 version'}).postcss
	      ]
	    },
	    dist: {
	      src: 'resources/css/postcss/*.css',
	      dest: 'build/resources/css/a.css'
	    }
	  }
  });

  // Load the plugin that provides the "uglify" task.
  grunt.loadNpmTasks('grunt-contrib-uglify');
  grunt.loadNpmTasks('grunt-postcss'); // 给css属性添加浏览器前缀
  
  // Default task(s).
  grunt.registerTask('default',["uglify","postcss"]);

};