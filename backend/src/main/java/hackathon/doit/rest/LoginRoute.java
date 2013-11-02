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
import java.util.ArrayList;
import java.util.UUID;
import javax.persistence.OptimisticLockException;
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
            String authenticationToken = generateToken(request);

            return "{\"token\":\"" + authenticationToken + "\"}";
        }
    }

    private String generateToken(Request request) throws OptimisticLockException {
        final String authenticationToken = UUID.randomUUID().toString();
        final String username = request.queryMap().get(USERNAME_ATTRIBUTE).value();
        Account account = Ebean.find(Account.class).where()
                .eq("username", username).findUnique();
        Token t = new Token();
        t.setToken(authenticationToken);
        if (account != null) {
            updateToken(account, t);
        } else {
            registerAccount(username, t);
        }
        return authenticationToken;
    }

    private void updateToken(Account account, Token t) throws OptimisticLockException {
        account.getTokens().add(t);
        t.setUsername(account.getUsername());
        Ebean.save(t);
    }

    private void registerAccount(final String username, Token t) throws OptimisticLockException {
        Account newAccount = new Account();
        newAccount.setUsername(username);
        newAccount.setTokens(new ArrayList<Token>());
        t.setUsername(username);
        newAccount.getTokens().add(t);
        Ebean.save(newAccount);
    }

}
