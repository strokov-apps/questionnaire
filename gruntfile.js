module.exports = function (grunt) {

    grunt.initConfig({

        //minify js
        uglify: {
            files: {
                cwd: 'src/main/resources/static',
                src: ['js/**/*.js'],  
                dest: 'src/main/static-compiled/resources',
                ext: '.min.js'
            }
        },

        //minify css
        cssmin: {
            files: {
                cwd: 'src/main/static-compiled/temp/css',
                src: '**/*.css',
                dest: 'src/main/static-compiled/resources/css',
                expand: true,
                ext: '.min.css'
            }
        },

        sass : {
            compile : {
                options : {
                    sourcemap : 'none',
                    compass: true
                },
                files : [{
                    expand : true,
                    cwd : 'src/main/resources/scss',
                    src : ['**/*.scss', '**/*.css'],
                    dest : 'src/main/static-compiled/temp/css',
                    ext : '.css'
                }]
            }
        },

        copy: {
            normal: {
                files: [
                    {
                        cwd: 'src/main/resources/static-src', src: '**/*',
                        dest: 'src/main/resources/static', expand: true
                    }
                ]
            },
            min: {
                files: [
                    { cwd: 'src/main/webapp/resources/locales', src: '**/*', dest: 'src/main/static-compiled/resources/locales', expand: true },
                    { cwd: 'src/main/webapp/resources/fonts', src: '**/*', dest: 'src/main/static-compiled/resources/fonts', expand: true },
                    { cwd: 'src/main/webapp/resources/images', src: '**/*', dest: 'src/main/static-compiled/resources/images', expand: true },
                    { cwd: 'src/main/webapp/resources/vendor', src: '**/*', dest: 'src/main/static-compiled/resources/vendor', expand: true },
                    { cwd: 'src/main/webapp/resources', src: '*', dest: 'src/main/static-compiled/resources', expand: true, filter: 'isFile' }
                ]
            },
            // replace WEB-INF
            web: {
                cwd: 'src/main/static-compiled/temp/src/main/webapp/WEB-INF',
                src: '**/*',
                dest: 'src/main/static-compiled/WEB-INF',
                expand: true
            }
        },
        clean: {
            temp: ['src/main/static-compiled/temp'],
            static: ['src/main/resources/static']
        },
        //  .js -> .js.min && .css -> css.min
        replace: {
            normal: {
                options: {
                    patterns: [
                        {   // use @@sufix-js
                            match: 'sufix-js',
                            replacement: 'js'
                        },
                        {   // use @@sufix-css
                            match: 'sufix-css',
                            replacement: 'css'
                        }
                    ]
                },
                files: [
                    {
                        src: 'src/main/webapp/WEB-INF/**/*',
                        dest: 'src/main/static-compiled/temp',
                        expand: true
                    }
                ]
            },
            min: {
                options: {
                    patterns: [
                        {
                            match: 'sufix-js',
                            replacement: 'min.js'
                        },
                        {
                            match: 'sufix-css',
                            replacement: 'min.css'
                        }
                    ]
                },
                files: [
                    {
                        src: 'src/main/webapp/WEB-INF/**/*',
                        dest: 'src/main/static-compiled/temp',
                        expand: true
                    }
                ]
            }
        }
    });

    // load plugins
    grunt.loadNpmTasks('grunt-contrib-cssmin');
    grunt.loadNpmTasks('grunt-contrib-uglify');
    grunt.loadNpmTasks('grunt-contrib-clean');
    grunt.loadNpmTasks('grunt-contrib-copy');
    grunt.loadNpmTasks('grunt-replace');
    grunt.loadNpmTasks('grunt-contrib-sass');

    // list of tasks
    //grunt.registerTask('minify', ['clean:static-compiled', 'sass', 'copy:min', 'uglify', 'cssmin', 'replace:min', 'copy:web', 'clean:temp']);
    grunt.registerTask('normal', ['clean:static', 'copy:normal']);
};