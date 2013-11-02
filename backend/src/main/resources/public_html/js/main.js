require(['jquery', 'login'], function($, login) {
    $('#logginButton').on('click', function() {
        var container = $('.starter-template');
        login();
    });
});
