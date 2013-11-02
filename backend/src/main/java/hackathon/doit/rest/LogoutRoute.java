/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hackathon.doit.rest;

import com.avaje.ebean.Ebean;
import hackathon.doit.model.Token;
import spark.Request;
import spark.Response;

/**
 *
 * @author Dutza
 */
public class LogoutRoute extends JsonTransformer {

    public LogoutRoute(String path) {
        super(path);
    }

    public LogoutRoute(String path, String acceptType) {
        super(path, acceptType);
    }

    @Override
    public Object handle(Request request, Response response) {
        final String token = request.headers("token");

        final Token theToken = Ebean.find(Token.class).where().eq("token", token).findUnique();
        if(theToken == null){
            return "";
        }
        Ebean.delete(theToken);
        return "";
    }

}
