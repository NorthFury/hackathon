require(['zepto', 'settings'], function($, settings) {
    $.ajax({
        contentType: 'application/json',
        data: location.search.substring(1),
        dataType: 'json',
        success: function(data) {
            console.log(data);
        },
        error: function() {
            location.href = settings.getGoogleOpenIdLink();
        },
        processData: false,
        type: 'POST',
        url: settings.domain + 'accounts/login'
    });
});
