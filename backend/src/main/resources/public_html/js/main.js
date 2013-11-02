require(['jquery', 'login'], function($, login) {
    $('#loginButton').on('click', function() {
        var container = $('.starter-template');
        login();
    });
});
