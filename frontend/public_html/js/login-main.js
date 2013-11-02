require(['jquery', 'settings'], function($, settings) {
    $.ajax({
        contentType: 'application/json',
        data: location.search.substring(1),
        dataType: 'json',
        success: function(data) {
            window.parent.login(data);
            window.close();
        },
        error: function() {
            console.log('login failure');
            window.close();
        },
        processData: false,
        type: 'POST',
        url: settings.apiDomain + 'accounts/login'
    });
});
