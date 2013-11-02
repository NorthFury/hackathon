/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hackathon.doit.rest;

import spark.Request;
import spark.Response;

/**
 *
 * @author Dutza
 */
public class LoginRoute extends JsonTransformer {

    public LoginRoute(String path) {
        super(path);
    }

    public LoginRoute(String path, String acceptType) {
        super(path, acceptType);
    }

    @Override
    public Object handle(Request request, Response response) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

}
