require(['jquery', 'settings'], function($, settings) {
    $.ajax({
        contentType: 'application/json',
//        data: location.search.substring(1),
        dataType: 'json',
        success: function(data) {
            window.opener.login(data);
            window.close();
        },
        error: function() {
            window.opener.loginFailed();
            window.close();
        },
        processData: false,
        type: 'POST',
        url: settings.apiDomain + 'account/login' + location.search
    });
});
