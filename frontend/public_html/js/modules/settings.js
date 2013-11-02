define({
    apiDomain: 'http://localhost:8085/',
    authenticationAge: 10,
    getGoogleOpenIdLink: function() {
        var baseUrl = 'https://www.google.com/accounts/o8/ud?openid.ns=http://specs.openid.net/auth/2.0&openid.ns.pape=http://specs.openid.net/extensions/pape/1.0&openid.claimed_id=http://specs.openid.net/auth/2.0/identifier_select&openid.identity=http://specs.openid.net/auth/2.0/identifier_select&openid.mode=checkid_setup&openid.ui.ns=http://specs.openid.net/extensions/ui/1.0&openid.ui.mode=popup&openid.ui.icon=true&openid.ns.ax=http://openid.net/srv/ax/1.0&openid.ax.mode=fetch_request&openid.ax.type.email=http://axschema.org/contact/email&openid.ax.required=email';
        return baseUrl + '&openid.ns.max_auth_age=' + this.authenticationAge + '&openid.return_to=' + this.domain + '&openid.realm=' + this.domain;
    }
});
