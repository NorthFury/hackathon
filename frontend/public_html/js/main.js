require(['zepto', 'logger'], function($, logger) {
    $(document.body).append("<div>Hello World</div>");
    logger.log('logging: Hello World');
});
