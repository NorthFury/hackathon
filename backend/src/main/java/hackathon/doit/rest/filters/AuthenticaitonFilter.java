package hackathon.doit.rest.filters;

import com.avaje.ebean.Ebean;
import hackathon.doit.model.Token;
import hackathon.doit.rest.util.GoogleOpenIdHelper;
import spark.Filter;
import spark.Request;
import spark.Response;

/**
 *
 * @author Andrei Onu
 */
public class AuthenticaitonFilter extends Filter {

    private static final String USERNAME_ATTRIBUTE = "openid.ext1.value.email";

    public AuthenticaitonFilter(String path, String acceptType) {
        super(path, acceptType);
    }

    @Override
    public void handle(Request request, Response response) {
        final String authenticationToken = request.headers("token");
        final String username = request.queryMap().get(USERNAME_ATTRIBUTE).value();

        final Token token = Ebean.find(Token.class).where().eq("username", username).eq("token", authenticationToken).findUnique();

        if (token == null) {
            response.body(GoogleOpenIdHelper.INVALID_AUTHENTICATION_JSON);
            response.status(403);
        }
    }

}
