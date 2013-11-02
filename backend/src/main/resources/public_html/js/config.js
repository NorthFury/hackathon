requirejs.config({
    baseUrl: "js/modules",
    urlArgs: "timestamp=" + (new Date()).getTime(),
    shim: {
        'underscore': {
            exports: '_'
        }
    },
    paths: {
        'underscore': '../libs/underscore',
        'text': '../libs/text'
    }
});

define("jquery", [], function() {
    return window.jQuery;
});
