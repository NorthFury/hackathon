require(['jquery', 'underscore', 'settings', 'login', 'viewtasks'], function($, _, settings, login, viewtasks) {
    $('#loginButton').on('click', function() {
        login();
    });
    $('#doitButton').on('click', function() {
        if (!_.isUndefined(settings.login)) {
            var container = $('#container');
            viewtasks(container);
        }
    });
});
