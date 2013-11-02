package hackathon.doit.rest;

import com.avaje.ebean.Ebean;
import hackathon.doit.model.Account;
import hackathon.doit.model.Token;
import hackathon.doit.rest.util.GoogleOpenIdHelper;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import spark.Request;
import spark.Response;

/**
 *
 * @author Dutza
 */
public class LoginRoute extends JsonTransformer {

    private static final String USERNAME_ATTRIBUTE = "openid.ext1.value.email";

    public LoginRoute(String path) {
        super(path);
    }

    public LoginRoute(String path, String acceptType) {
        super(path, acceptType);
    }

    @Override
    public Object handle(Request request, Response response) {
        GoogleOpenIdHelper helper = new GoogleOpenIdHelper();

        if (helper.isAuthenticated(request)) {
            response.body(GoogleOpenIdHelper.INVALID_AUTHENTICATION_JSON);
            response.status(403);
            return null;
        } else {
            final String username = request.queryMap().get(USERNAME_ATTRIBUTE).value();

            final String authenticationToken = UUID.randomUUID().toString();

            Account account = Ebean.find(Account.class).where()
                    .eq("username", username).findUnique();
            Token t = new Token();
            t.setToken(authenticationToken);
            if (account == null) {
                account = registerAccount(username);
            }
            updateToken(account, t);

            Map<String, Object> responseObject = new HashMap<>();
            responseObject.put("token", authenticationToken);
            responseObject.put("account", account);

            return responseObject;
        }
    }

    private void updateToken(Account account, Token t) {
        account.getTokens().add(t);
        t.setUsername(account.getEmail());
        Ebean.save(t);
    }

    private Account registerAccount(final String username) {
        Account newAccount = new Account();
        newAccount.setEmail(username);
        Ebean.save(newAccount);
        return newAccount;
    }
}
