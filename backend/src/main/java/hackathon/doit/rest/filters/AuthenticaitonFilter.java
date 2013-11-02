/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hackathon.doit.rest.filters;

import spark.Filter;
import spark.Request;
import spark.Response;

/**
 *
 * @author Dutza
 */
public class AuthenticaitonFilter extends Filter {

    public AuthenticaitonFilter(String path, String acceptType) {
        super(path, acceptType);
    }

    @Override
    public void handle(Request request, Response response) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
