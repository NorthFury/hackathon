/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hackathon.doit.rest;

import com.avaje.ebean.Ebean;
import hackathon.doit.model.Account;
import hackathon.doit.model.Token;
import hackathon.doit.rest.util.GoogleOpenIdHelper;
import java.io.IOException;
import java.util.ArrayList;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.codehaus.jackson.map.ObjectMapper;
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
            if (account != null) {
                updateToken(account, t);
                return "{\"token\":\""
                        + authenticationToken
                        + "\", \"account\":"
                        + asJson(account)
                        + "}";
            } else {
                final Account registeredAccount = registerAccount(username, t);
                return "{\"token\":\""
                        + authenticationToken
                        + "\", \"account\":"
                        + asJson(registeredAccount)
                        + "}";
            }
        }
    }

    private String asJson(Object o) {
        final ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.writeValueAsString(o);
        } catch (IOException ex) {
            Logger.getLogger(LoginRoute.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "";
    }

    private void updateToken(Account account, Token t) {
        account.getTokens().add(t);
        t.setUsername(account.getEmail());
        Ebean.save(t);
    }

    private Account registerAccount(final String username, Token t) {
        Account newAccount = new Account();
        newAccount.setEmail(username);
        newAccount.setTokens(new ArrayList<Token>());
        t.setUsername(username);
        newAccount.getTokens().add(t);
        Ebean.save(newAccount);
        return newAccount;
    }
}
