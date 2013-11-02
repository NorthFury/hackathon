define(['settings'], function(settings) {
    function popitup(url) {
        newwindow = window.open(url, 'name', 'height=400,width=650');
        if (window.focus) {
            newwindow.focus();
        }
        return false;
    }

    return function() {
        var openIdLink = settings.getGoogleOpenIdLink();

        window.login = function(data) {
            console.log(data);
        };
        popitup(openIdLink);
    };
});
