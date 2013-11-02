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

    public AuthenticaitonFilter(String path, String acceptType) {
        super(path, acceptType);
    }

    public AuthenticaitonFilter(String path) {
        super(path);
    }

    @Override
    public void handle(Request request, Response response) {
        final String authenticationToken = request.headers("token");
        final Token token = Ebean.find(Token.class).where().eq("token", authenticationToken).findUnique();
        if (token == null) {
            halt(403, GoogleOpenIdHelper.INVALID_AUTHENTICATION_JSON);
        }
    }

}
