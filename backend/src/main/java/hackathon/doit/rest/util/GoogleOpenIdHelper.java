/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hackathon.doit.rest.util;

import hackathon.doit.rest.filters.AuthenticaitonFilter;
import java.io.IOException;
import java.io.StringWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import spark.Request;
import spark.utils.IOUtils;

/**
 *
 * @author Dutza
 */
public class GoogleOpenIdHelper {

    public static final String INVALID_AUTHENTICATION_JSON = "{\"authenticated\":\"false\"}";
    private static final String GOOGLE_OPEN_ID_URI = "https://www.google.com/accounts/o8/ud";

    private static final String openidmodeid_res = "openid.mode=id_res";
    private static final String openidmodecheck_authentication = "openid.mode=check_authentication";

    public boolean isAuthenticated(Request request) {
        String googleResponseString = getGoogleAuthenticationStatus(request);
        return googleResponseString.contains("is_valid:false");
    }

    private String getGoogleAuthenticationStatus(Request request) {
        try {
            final String queryString = request.queryString();

            final String refactoredGoogleQuery = queryString.replace(openidmodeid_res, openidmodecheck_authentication);
            HttpGet get = new HttpGet(GOOGLE_OPEN_ID_URI + refactoredGoogleQuery);

            DefaultHttpClient client = new DefaultHttpClient();

            final HttpResponse googleResponse = client.execute(get);
            return asStringResponse(googleResponse);
        } catch (IOException ex) {
            Logger.getLogger(AuthenticaitonFilter.class.getName()).log(Level.SEVERE, null, ex);
            return "is_valid:false";
        }
    }

    private String asStringResponse(final HttpResponse googleResponse) throws IOException, IllegalStateException {
        final HttpEntity entity = googleResponse.getEntity();
        StringWriter writer = new StringWriter();
        IOUtils.copy(entity.getContent(), writer);
        String googleResponseString = writer.toString();
        return googleResponseString;
    }
}
