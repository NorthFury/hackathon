define(['jquery', 'settings'], function($, settings) {
    function popItUp(url) {
        var newwindow = window.open(url, 'name', 'height=400,width=650');
        if (window.focus) {
            newwindow.focus();
        }
        return false;
    }

    return function() {
        var openIdLink = settings.getGoogleOpenIdLink();

        window.login = function(data) {
            settings.login = data;
            delete(window.login);

            $('#loginButton').hide();
            var logoutButton = $('#logoutButton');
            logoutButton.show();
            logoutButton.on('click', function() {
                window.location.reload();
            });
            logoutButton.find('.user-name').html(data.account.email);
        };

        window.loginFailed = function() {
            console.log("Login failed");
        };

        popItUp(openIdLink);
    };
});
